package admin;

import codes.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

import java.sql.*;

public class Reduction {
    public static JPanel window() {
        
        JPanel mainPanel = new JPanel(new GridBagLayout());

        try {
            Statement st = Connexion.connectONCF();
            ResultSet res = st.executeQuery("select * from reduction");

            // Créer un tableau de données pour stocker les résultats de la requête
            final String[][] data = new String[25][5]; // Marquer comme final

            int rowCount = 0;
            while (res.next()) {
                String carte = res.getString(1);
                String code = res.getString(2);
                String pourcentage = res.getString(3);

                // Stocker les données dans le tableau
                data[rowCount][0] = carte;
                data[rowCount][1] = code;

                rowCount++;
            }

            // Créer un tableau avec les données
            String[] columnNames = {"Carte", "Code", "Pourcentage"};
           final JTable table = new JTable(data, columnNames);

            // Ajouter le tableau à un JScrollPane
            JScrollPane scrollPane = new JScrollPane(table);
            mainPanel.add(scrollPane);

            // Ajouter un bouton Modifier pour chaque ligne du tableau
            JButton modifierButton = new JButton("Modifier");
            modifierButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int rowIndex = table.getSelectedRow();
                    if (rowIndex != -1) {
                        String carte = data[rowIndex][0];
                        String codeAdherent = data[rowIndex][1];
                        String pourcentage = data[rowIndex][2];
 
                        String newCarte = JOptionPane.showInputDialog(null, "Entrez la nouvelle carte de réduction :", carte);
                        String newCodeAdherent = JOptionPane.showInputDialog(null, "Entrez le nouveau code adhérent :", codeAdherent);
                        String newPourcentage = JOptionPane.showInputDialog(null, "Entrez le nouveau pourcentage :", pourcentage);

                        if (newCarte != null && newCodeAdherent != null && newPourcentage != null &&
                                !newCarte.isEmpty() && !newCodeAdherent.isEmpty() && !newPourcentage.isEmpty()) {
                            int newPercentage = Integer.parseInt(newPourcentage);
                            int newCode = Integer.parseInt(newCodeAdherent);
                            Connexion.modifierCarteReduction(newCarte, newCode, newPercentage);
                            JOptionPane.showMessageDialog(null, "Carte de réduction modifiée avec succès.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Veuillez sélectionner une carte de réduction à modifier.");
                    }
                }
            });

            mainPanel.add(modifierButton); // Ajouter le bouton "Modifier" au panneau principal
         // Ajouter un bouton Supprimer pour chaque ligne du tableau
            JButton supprimerButton = new JButton("Supprimer");
            supprimerButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int rowIndex = table.getSelectedRow();
                    if (rowIndex != -1) {
                        String carte = data[rowIndex][0];
                        String codeAdherent = data[rowIndex][1];
                        String pourcentage = data[rowIndex][2];

                        int confirmation = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment supprimer cette entrée ?", "Confirmation", JOptionPane.YES_NO_OPTION);
                        if (confirmation == JOptionPane.YES_OPTION) {
                            Connexion.supprimerCarteReduction(carte, Integer.parseInt(codeAdherent));
                            // Supprimer la ligne de la JTable
                            DefaultTableModel model = (DefaultTableModel) table.getModel();
                            model.removeRow(rowIndex);
                            JOptionPane.showMessageDialog(null, "Carte de réduction supprimée avec succès.");
                            
                            
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Veuillez sélectionner une carte de réduction à supprimer.");
                    }
                }
            });
            
            mainPanel.add(supprimerButton); // Ajouter le bouton "Supprimer" au panneau principal
            GoTo.reduction(supprimerButton);
         // Ajouter un bouton Ajouter
            JButton ajouterButton = new JButton("Ajouter");
            ajouterButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String nouvelleCarte = JOptionPane.showInputDialog(null, "Entrez le nom de la nouvelle carte de réduction :");
                    String nouveauCode = JOptionPane.showInputDialog(null, "Entrez le nouveau code adhérent :");
                    String nouveauPourcentage = JOptionPane.showInputDialog(null, "Entrez le nouveau pourcentage :");

                    if (nouvelleCarte != null && nouveauCode != null && nouveauPourcentage != null &&
                            !nouvelleCarte.isEmpty() && !nouveauCode.isEmpty() && !nouveauPourcentage.isEmpty()) {
                        try {
                            int code = Integer.parseInt(nouveauCode);
                            int pourcentage = Integer.parseInt(nouveauPourcentage);
                            Connexion.ajouterCarteReduction(nouvelleCarte, code, pourcentage);
                            JOptionPane.showMessageDialog(null, "Carte de réduction ajoutée avec succès.");

                            // Mettre à jour la JTable
                            DefaultTableModel model = (DefaultTableModel) table.getModel();
                            model.addRow(new Object[]{nouvelleCarte, nouveauCode, nouveauPourcentage});
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "Veuillez saisir des valeurs numériques valides pour le code adhérent et le pourcentage.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs.");
                    }
                }
            });
            mainPanel.add(ajouterButton); // Ajouter le bouton "Ajouter" au panneau principal



        } catch (SQLException e) {
            e.printStackTrace();
        }
        JButton retourButton = new JButton("Retour");
        mainPanel.add(retourButton);
        GoTo.page(retourButton);

        Styles.bgColor(mainPanel);
        return mainPanel;
    }
}





    

