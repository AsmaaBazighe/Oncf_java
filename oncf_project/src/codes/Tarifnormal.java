package codes;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Tarifnormal {
    public static void window() {
        JFrame f = new JFrame();
        f.setTitle("ONCF");
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5); // Add some padding

        Statement st = Connexion.connectONCF();
        
        ArrayList<String> gares = new ArrayList<String>();
        Set<String> dates = new HashSet<String>();
        try {
            ResultSet res = st.executeQuery("select * from gares");
            while (res.next()) {
                gares.add(res.getString(2));
            }
            ResultSet restrain = st.executeQuery("select * from train");
            while (restrain.next()) {
                String datePart = Todate.convertTimestampToDate(restrain.getString(3));
                dates.add(datePart);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String[] gare = gares.toArray(new String[0]);
        String[] date = dates.toArray(new String[0]);

        // Panels for label and combo box pairs
        JPanel departPanel = new JPanel(new BorderLayout());
        JLabel departLabel = new JLabel("Gare de départ:");
        JComboBox<String> departComboBox = new JComboBox<String>(gare);
        departPanel.add(departLabel, BorderLayout.NORTH);
        departPanel.add(departComboBox, BorderLayout.CENTER);

        JPanel arriveePanel = new JPanel(new BorderLayout());
        JLabel arriveeLabel = new JLabel("Gare d'arrivée:");
        JComboBox<String> arriveeComboBox = new JComboBox<String>(gare);
        arriveePanel.add(arriveeLabel, BorderLayout.NORTH);
        arriveePanel.add(arriveeComboBox, BorderLayout.CENTER);

        JPanel datePanel = new JPanel(new BorderLayout());
        JLabel dateLabel = new JLabel("Date:");
        JComboBox<String> listdate = new JComboBox<String>(date);
        datePanel.add(dateLabel, BorderLayout.NORTH);
        datePanel.add(listdate, BorderLayout.CENTER);
        
        final Poucent poucentInstance = new Poucent();
        poucentInstance.setValue(0);
        
        JButton submitButton = new JButton("Suivant");
        JButton returnButton = new JButton("Retour");
        GoTo.train(submitButton, departComboBox, arriveeComboBox, listdate, poucentInstance);
        GoTo.page(returnButton);
       
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(submitButton);
        buttonPanel.add(returnButton);
        
        mainPanel.add(departPanel, gbc);
        gbc.gridy++;
        mainPanel.add(arriveePanel, gbc);
        gbc.gridy++;
        mainPanel.add(datePanel, gbc);
        gbc.gridy++;
        mainPanel.add(buttonPanel, gbc);

        Styles.bgColor(mainPanel);
        Styles.buttonStyle(returnButton);
        Styles.buttonStyle(submitButton);
        f.setContentPane(mainPanel);
        f.setVisible(true);
    }
}
