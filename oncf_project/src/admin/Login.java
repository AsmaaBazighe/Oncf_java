package admin;

import codes.*;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class Login {
	
    public static void window() {
        JFrame f = new JFrame();
        f.setTitle("ONCF");
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel(new GridBagLayout());
        Styles.bgColor(mainPanel);

        
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20,20, 20));

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
        
        
        final JTextField user = new JTextField();
        user.setColumns(10);
        final JPasswordField psw = new JPasswordField();
        psw.setColumns(10);
        JButton submitButton = new JButton("Soumettre");
        Styles.organiserPay(mainPanel,submitButton,user,psw);
        GoTo.choix(submitButton);
        
        f.setContentPane(mainPanel);
        f.setVisible(true);
    }
    
    

    
}

