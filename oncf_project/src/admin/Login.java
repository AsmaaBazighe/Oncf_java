dmin;

import codes.*;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Login {

    public static JPanel window() {

        final JPanel mainPanel = new JPanel(new GridBagLayout());
        Styles.bgColor(mainPanel);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        final JTextField user = new JTextField();
        user.setColumns(10);
        final JPasswordField psw = new JPasswordField();
        psw.setColumns(10);
        final JButton submitButton = new JButton("Soumettre");
        Styles.organiserPay(mainPanel, submitButton, user, psw);

        
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String enteredUsername = user.getText();
                String enteredPassword = new String(psw.getPassword());
                
                System.out.println("Entered Username: " + enteredUsername);
                System.out.println("Entered Password: " + enteredPassword);

                
                Statement st = Connexion.connectONCF();
                ArrayList<User> data = new ArrayList<User>();
                try {
                    ResultSet res = st.executeQuery("SELECT * FROM admin");
                    while (res.next()) {
                        String username = res.getString(1);
                        String password = res.getString(2);
                        User user = new User(username, password);
                        data.add(user);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(mainPanel, "Error connecting to database.", "Login Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

               
                boolean authenticated = false;
                for (User u : data) {
                    System.out.println("Database Username: " + u.getUsername());
                    System.out.println("Database Password: " + u.getPassword());
                    if (u.getUsername().equals(enteredUsername) && u.getPassword().equals(enteredPassword)) {
                        authenticated = true;
                        break;
                    }
                }

                
                if (authenticated) {
                    GoTo.choix(submitButton);
                } else {
                    
                	JOptionPane.showMessageDialog(mainPanel, "Nom d'utilisateur ou mot de passe incorrect. Veuillez réessayer.", "Erreur de connexion", JOptionPane.ERROR_MESSAGE);

                }
            }
        });

        return mainPanel;
    }
}
