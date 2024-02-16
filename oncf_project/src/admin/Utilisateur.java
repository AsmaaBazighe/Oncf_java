package admin;

import codes.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Utilisateur {
    public static void window() {
        JFrame f = new JFrame();
        f.setTitle("ONCF");
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel(new GridBagLayout());

        try {
            Statement st = Connexion.connectONCF();
            ResultSet res = st.executeQuery("select * from utilisateur");

            String[][] data1 = new String[10][4];
            String[][] data2 = new String[10][4];

            int rowCount = 0;
            while (res.next()) {
                String user = res.getString(1);
                String pwd = res.getString(2);
                JButton modifier = new JButton("Modifier");
                JButton supprimer = new JButton("Supprimer");

                // Stocker les données dans le tableau
                data1[rowCount][0] = user;
                data1[rowCount][1] = pwd;

                rowCount++;
            }
            res = st.executeQuery("select * from admin");
            rowCount = 0;
            while (res.next()) {
                String user = res.getString(1);
                String pwd = res.getString(2);
                JButton modifier = new JButton("Modifier");
                JButton supprimer = new JButton("Supprimer");

                // Stocker les données dans le tableau
                data2[rowCount][0] = user;
                data2[rowCount][1] = pwd;

                rowCount++;
            }

            // Créer un tableau avec les données
            String[] columnNames1 = {"utilisateur", "mots de passe"};
            JTable table1 = new JTable(data1, columnNames1);
            String[] columnNames2 = {"admin", "mots de passe"};
            JTable table2 = new JTable(data2, columnNames2);

            // Ajouter le tableau à un JScrollPane
            JScrollPane scrollPane1 = new JScrollPane(table1);
            JScrollPane scrollPane2 = new JScrollPane(table2);
            mainPanel.add(scrollPane1);
            mainPanel.add(scrollPane2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JButton retourButton = new JButton("Retour");
        mainPanel.add(retourButton);
        GoTo.page(retourButton);

        Styles.bgColor(mainPanel);
        f.add(mainPanel);
        f.setVisible(true);
    }
    



    
}
