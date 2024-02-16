package admin;

import codes.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Trains {
    public static void window() {
        JFrame f = new JFrame();
        f.setTitle("ONCF");
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel(new GridBagLayout());

        try {
            Statement st = Connexion.connectONCF();
            ResultSet res = st.executeQuery("select * from train");

            final String[][] data = new String[100][6];

            int rowCount = 0;
            while (res.next()) {
                String depart = res.getString(1);
                String arivee = res.getString(2);
                String time = res.getString(3);
                String price = res.getString(4);

                // Stocker les données dans le tableau
                data[rowCount][0] = depart;
                data[rowCount][1] = arivee;
                data[rowCount][2] = time;
                data[rowCount][3] = price;

                rowCount++;
            }

            // Créer un tableau avec les données
            String[] columnNames = {"Gare Depart", "Gare Arrivee", "Date", "Prix"};
            final JTable table = new JTable(data, columnNames);

            // Ajouter le tableau à un JScrollPane
            JScrollPane scrollPane = new JScrollPane(table);
            mainPanel.add(scrollPane);

            // Ajouter des boutons pour les opérations
            JButton ajouterButton = new JButton("Ajouter");
            JButton modifierButton = new JButton("Modifier");
            JButton supprimerButton = new JButton("Supprimer");

            // Ajouter des ActionListener pour chaque bouton
            
            modifierButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int rowIndex = table.getSelectedRow();
                    if (rowIndex != -1) {
                        String gareDepart = data[rowIndex][0];
                        String gareArrivee = data[rowIndex][1];
                        String date = data[rowIndex][2];
                        String prix = data[rowIndex][3];

                        // Display input dialogs to get new values for the journey details
                        String newGareDepart = JOptionPane.showInputDialog(null, "Entrez la nouvelle gare de départ :", gareDepart);
                        String newGareArrivee = JOptionPane.showInputDialog(null, "Entrez la nouvelle gare d'arrivée :", gareArrivee);
                        String newDate = JOptionPane.showInputDialog(null, "Entrez la nouvelle date :", date);
                        String newPrix = JOptionPane.showInputDialog(null, "Entrez le nouveau prix :", prix);

                        // Check if all fields are filled and not empty
                        if (newGareDepart != null && newGareArrivee != null && newDate != null && newPrix != null &&
                            !newGareDepart.isEmpty() && !newGareArrivee.isEmpty() && !newDate.isEmpty() && !newPrix.isEmpty()) {
                            
                            // Parse the new price to integer
                            int newPrice = Integer.parseInt(newPrix);
                            // Call the method to modify the journey in the database
                            Connexion.modifierTrajet(newGareDepart, newGareArrivee, newDate, newPrice);
                            JOptionPane.showMessageDialog(null, "Trajet modifié avec succès.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Veuillez sélectionner un trajet à modifier.");
                    }
                }
            });
            
            ajouterButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Display input dialogs to get new values for the journey details
                    String gareDepart = JOptionPane.showInputDialog(null, "Entrez la gare de départ :");
                    String gareArrivee = JOptionPane.showInputDialog(null, "Entrez la gare d'arrivée :");
                    String date = JOptionPane.showInputDialog(null, "Entrez la date :");
                    String prix = JOptionPane.showInputDialog(null, "Entrez le prix :");

                    // Check if all fields are filled and not empty
                    if (gareDepart != null && gareArrivee != null && date != null && prix != null &&
                        !gareDepart.isEmpty() && !gareArrivee.isEmpty() && !date.isEmpty() && !prix.isEmpty()) {
                        
                        // Parse the price to integer
                        int newPrice = Integer.parseInt(prix);
                        // Call the method to add the new journey to the database
                        Connexion.ajouterTrajet(gareDepart, gareArrivee, date, newPrice);
                        JOptionPane.showMessageDialog(null, "Trajet ajouté avec succès.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs.");
                    }
                }
            });
            
            supprimerButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Récupérer l'index de la ligne sélectionnée
                    int rowIndex = table.getSelectedRow();
                    if (rowIndex != -1) {
                        String gareDepart = data[rowIndex][0];
                        String gareArrivee = data[rowIndex][1];
                        String date = data[rowIndex][2];
                        Connexion.supprimerTrajet(gareDepart, gareArrivee, date);
                        // Supprimer la ligne de la JTable
                        DefaultTableModel model = (DefaultTableModel) table.getModel();
                        model.removeRow(rowIndex);
                        JOptionPane.showMessageDialog(null, "Trajet supprimé avec succès.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Veuillez sélectionner un trajet à supprimer.");
                    }
                }
            });




            
            // Ajouter les boutons au panel
            mainPanel.add(ajouterButton);
            mainPanel.add(modifierButton);
            mainPanel.add(supprimerButton);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        Styles.bgColor(mainPanel);
        f.add(mainPanel);
        f.setVisible(true);
    }
}
