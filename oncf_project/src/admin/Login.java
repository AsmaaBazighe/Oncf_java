package admin;

import codes.*;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Login {
    
    public static JPanel window() {
        JPanel mainPanel = new JPanel(new GridBagLayout());
        Styles.bgColor(mainPanel);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        Statement st = Connexion.connectONCF();
        final ArrayList<User> data = new ArrayList<User>();
        try {
            ResultSet res = st.executeQuery("select * from admin");
            while (res.next()) {
                String username = res.getString(1);
                String password = res.getString(2);
                User user = new User(username, password);
                data.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        final JTextField userField = new JTextField(10);
        final JPasswordField passwordField = new JPasswordField(10);
        JButton submitButton = new JButton("Soumettre");

        Styles.organiserPay(mainPanel, submitButton, userField, passwordField);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enteredUsername = userField.getText();
                String enteredPassword = new String(passwordField.getPassword());

                boolean authenticated = false;
                for (User u : data) {
                    if (u.getUsername().equals(enteredUsername) && u.getPassword().equals(enteredPassword)) {
                        authenticated = true;
                        break;
                    }
                }

                if (authenticated) {
                    JOptionPane.showMessageDialog(null, "Connexion réussie !");
                    // Go to the next page
                    GoTo.choix(null); // Replace null with the appropriate parameter if needed
                } else {
                    JOptionPane.showMessageDialog(null, "Nom d'utilisateur ou mot de passe incorrect !");
                }
            }
        });

        return mainPanel;
    }

    
}
    
    

    
}

