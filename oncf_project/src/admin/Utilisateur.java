package admin;

import codes.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Utilisateur {
    public static JPanel window() {
        JPanel mainPanel = new JPanel(new GridBagLayout());

        try {
            Statement st = Connexion.connectONCF();
            ResultSet res = st.executeQuery("select * from utilisateur");

            final String[][] data1 = new String[10][4];
            final String[][] data2 = new String[10][4];

            int rowCount = 0;
            while (res.next()) {
                String user = res.getString(1);
                String pwd = res.getString(2);

                // Store the data in the array
                data1[rowCount][0] = user;
                data1[rowCount][1] = pwd;

                rowCount++;
            }
            res = st.executeQuery("select * from admin");
            rowCount = 0;
            while (res.next()) {
                String user = res.getString(1);
                String pwd = res.getString(2);

                // Store the data in the array
                data2[rowCount][0] = user;
                data2[rowCount][1] = pwd;

                rowCount++;
            }

            // Create tables with the data
            final String[] columnNames1 = {"utilisateur", "mots de passe"};
            final JTable table1 = new JTable(data1, columnNames1);
            final String[] columnNames2 = {"admin", "mots de passe"};
            final JTable table2 = new JTable(data2, columnNames2);

            // Add tables to scroll panes
            JScrollPane scrollPane1 = new JScrollPane(table1);
            scrollPane1.setPreferredSize(new Dimension(300, 150));
            JScrollPane scrollPane2 = new JScrollPane(table2);
            scrollPane2.setPreferredSize(new Dimension(300, 150));
            mainPanel.add(scrollPane1);
            mainPanel.add(scrollPane2);

            // ActionListener for deleting user
            JButton supprimerutilisateurButton = new JButton("Supprimer utilisateur");
            supprimerutilisateurButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int rowIndex = table1.getSelectedRow();
                    if (rowIndex != -1) {
                        String user = data1[rowIndex][0];

                        int confirmation = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment supprimer cet utilisateur ?", "Confirmation", JOptionPane.YES_NO_OPTION);
                        if (confirmation == JOptionPane.YES_OPTION) {
                            Connexion.supprimerUtilisateur(user);
                            DefaultTableModel model = (DefaultTableModel) table1.getModel();
                            model.removeRow(rowIndex);
                            JOptionPane.showMessageDialog(null, "Utilisateur supprimé avec succès.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Veuillez sélectionner un utilisateur à supprimer.");
                    }
                }
            });
            JButton ajouterUtilisateurButton = new JButton("Ajouter utilisateur");
            ajouterUtilisateurButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Display input dialogs to get the new utilisateur details
                    String newUser = JOptionPane.showInputDialog(null, "Entrez le nom de l'utilisateur :");
                    String newPwd = JOptionPane.showInputDialog(null, "Entrez le mot de passe de l'utilisateur :");

                    // Check if the input fields are not null and not empty
                    if (newUser != null && newPwd != null && !newUser.isEmpty() && !newPwd.isEmpty()) {
                        try {
                            // Call the method to add the utilisateur in the database
                            Connexion.ajouterUtilisateur(newUser, newPwd);

                            // Refresh the utilisateur table
                            Statement st = Connexion.connectONCF();
                            ResultSet res = st.executeQuery("select * from utilisateur");
                            DefaultTableModel model = (DefaultTableModel) table1.getModel();
                            model.setRowCount(0); // Clear the table
                            int rowCount = 0;
                            while (res.next()) {
                                String user = res.getString(1);
                                String pwd = res.getString(2);
                                model.addRow(new Object[]{user, pwd});
                                rowCount++;
                            }

                            JOptionPane.showMessageDialog(null, "Utilisateur ajouté avec succès.");
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Erreur lors de l'ajout de l'utilisateur : " + ex.getMessage());
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs.");
                    }
                }
            });
            JButton modifierUtilisateurButton = new JButton("Modifier utilisateur");
            modifierUtilisateurButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int rowIndex = table1.getSelectedRow();
                    if (rowIndex != -1) {
                        String ancienUtilisateur = data1[rowIndex][0];
                        String nouvelUtilisateur = JOptionPane.showInputDialog(null, "Entrez le nouveau nom de l'utilisateur :", ancienUtilisateur);
                        String nouveauMotDePasse = JOptionPane.showInputDialog(null, "Entrez le nouveau mot de passe de l'utilisateur :");

                        // Check if the input fields are not null and not empty
                        if (nouvelUtilisateur != null && nouveauMotDePasse != null && !nouvelUtilisateur.isEmpty() && !nouveauMotDePasse.isEmpty()) {
                            try {
                                // Call the method to modify the utilisateur in the database
                                Connexion.modifierUtilisateur(ancienUtilisateur, nouvelUtilisateur, nouveauMotDePasse);

                                // Refresh the utilisateur table
                                Statement st = Connexion.connectONCF();
                                ResultSet res = st.executeQuery("select * from utilisateur");
                                DefaultTableModel model = (DefaultTableModel) table1.getModel();
                                model.setRowCount(0); // Clear the table
                                int rowCount = 0;
                                while (res.next()) {
                                    String user = res.getString(1);
                                    String pwd = res.getString(2);
                                    model.addRow(new Object[]{user, pwd});
                                    rowCount++;
                                }

                                JOptionPane.showMessageDialog(null, "Utilisateur modifié avec succès.");
                            } catch (SQLException ex) {
                                ex.printStackTrace();
                                JOptionPane.showMessageDialog(null, "Erreur lors de la modification de l'utilisateur : " + ex.getMessage());
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Veuillez sélectionner un utilisateur à modifier.");
                    }
                }
            });
            JButton supprimeradminButton = new JButton("Supprimer admin");
            supprimeradminButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int rowIndex = table2.getSelectedRow();
                    if (rowIndex != -1) {
                        String user = data2[rowIndex][0];

                        int confirmation = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment supprimer cet admin ?", "Confirmation", JOptionPane.YES_NO_OPTION);
                        if (confirmation == JOptionPane.YES_OPTION) {
                            Connexion.supprimerAdmin(user);
                            DefaultTableModel model = (DefaultTableModel) table2.getModel();
                            model.removeRow(rowIndex);
                            JOptionPane.showMessageDialog(null, "Admin supprimé avec succès.");
                            
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Veuillez sélectionner un admin à supprimer.");
                    }
                }
            });
            JButton ajouteradminButton = new JButton("Ajouter admin");
            ajouteradminButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Display input dialogs to get the new utilisateur details
                    String newUser = JOptionPane.showInputDialog(null, "Entrez le nom de l'admin :");
                    String newPwd = JOptionPane.showInputDialog(null, "Entrez le mot de passe de l'admin :");

                    // Check if the input fields are not null and not empty
                    if (newUser != null && newPwd != null && !newUser.isEmpty() && !newPwd.isEmpty()) {
                        try {
                            // Call the method to add the utilisateur in the database
                            Connexion.ajouterAdmin(newUser, newPwd);

                            // Refresh the utilisateur table
                            Statement st = Connexion.connectONCF();
                            ResultSet res = st.executeQuery("select * from admin");
                            DefaultTableModel model = (DefaultTableModel) table2.getModel();
                            model.setRowCount(0); // Clear the table
                            int rowCount = 0;
                            while (res.next()) {
                                String user = res.getString(1);
                                String pwd = res.getString(2);
                                model.addRow(new Object[]{user, pwd});
                                rowCount++;
                            }

                            JOptionPane.showMessageDialog(null, "Admin ajouté avec succès.");
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Erreur lors de l'ajout de l'admin : " + ex.getMessage());
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs.");
                    }
                }
            });
            JButton modifierAdminButton = new JButton("Modifier admin");
            modifierAdminButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int rowIndex = table2.getSelectedRow();
                    if (rowIndex != -1) {
                        String ancienUtilisateur = data2[rowIndex][0];
                        String nouvelUtilisateur = JOptionPane.showInputDialog(null, "Entrez le nouveau nom de l'admin :", ancienUtilisateur);
                        String nouveauMotDePasse = JOptionPane.showInputDialog(null, "Entrez le nouveau mot de passe de l'admin :");

                        // Check if the input fields are not null and not empty
                        if (nouvelUtilisateur != null && nouveauMotDePasse != null && !nouvelUtilisateur.isEmpty() && !nouveauMotDePasse.isEmpty()) {
                            try {
                                // Call the method to modify the utilisateur in the database
                                Connexion.modifierAdmin(ancienUtilisateur, nouvelUtilisateur, nouveauMotDePasse);

                                // Refresh the utilisateur table
                                Statement st = Connexion.connectONCF();
                                ResultSet res = st.executeQuery("select * from admin");
                                DefaultTableModel model = (DefaultTableModel) table2.getModel();
                                model.setRowCount(0); // Clear the table
                                int rowCount = 0;
                                while (res.next()) {
                                    String user = res.getString(1);
                                    String pwd = res.getString(2);
                                    model.addRow(new Object[]{user, pwd});
                                    rowCount++;
                                }

                                JOptionPane.showMessageDialog(null, "Admin modifié avec succès.");
                            } catch (SQLException ex) {
                                ex.printStackTrace();
                                JOptionPane.showMessageDialog(null, "Erreur lors de la modification de l'admin : " + ex.getMessage());
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Veuillez sélectionner un admin à modifier.");
                    }
                }
            });




            // Add components to the main panel
            mainPanel.add(supprimerutilisateurButton);
            mainPanel.add(ajouterUtilisateurButton);
            mainPanel.add(modifierUtilisateurButton);
            mainPanel.add(supprimeradminButton);
            mainPanel.add(ajouteradminButton);
            mainPanel.add(modifierAdminButton );

            JButton retourButton = new JButton("Retour");
            mainPanel.add(retourButton);
            GoTo.page(retourButton);
            Styles.bgColor(mainPanel);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mainPanel;
    }
}
