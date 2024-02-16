package codes;

import java.sql.*;

public class Connexion {
    public static Statement connectONCF() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oncf", "root", "");
            return con.createStatement();
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());

            return null;

        }
    }
    
    public static void ajouterTrajet(String gareDepart, String gareArrivee, String date, int prix) {
        try {
            Statement st = connectONCF();
            PreparedStatement statement = st.getConnection().prepareStatement("INSERT INTO train (GareDepart, GareArrivee, Date, Prix) VALUES (?, ?, ?, ?)");
            statement.setString(1, gareDepart);
            statement.setString(2, gareArrivee);
            statement.setString(3, date);
            statement.setInt(4, prix);
            statement.executeUpdate();
            System.out.println("Trajet ajouté avec succès.");
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout du trajet : " + e.getMessage());
        }
    }

    public static void supprimerTrajet(String gareDepart, String gareArrivee, String date) {
        try {
            Statement st = connectONCF();
            PreparedStatement statement = st.getConnection().prepareStatement("DELETE FROM train WHERE GareDepart = ? AND GareArrivee = ? AND Date = ?");
            statement.setString(1, gareDepart);
            statement.setString(2, gareArrivee);
            statement.setString(3, date);
            statement.executeUpdate();
            System.out.println("Trajet supprimé avec succès.");
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression du trajet : " + e.getMessage());
        }
    } 

    public static void modifierTrajet(String ancienGareDepart, String ancienGareArrivee, String ancienneDate,
            int ancienPrix, String nouveauGareDepart, String nouveauGareArrivee,
            String nouvelleDate, int nouveauPrix){
    	try {
    		Statement st = connectONCF();

    		// Supprimer l'ancien trajet
    		PreparedStatement deleteStatement = st.getConnection().prepareStatement(
    		"DELETE FROM train WHERE GareDepart = ? AND GareArrivee = ? AND Date = ? AND Prix = ?");
    		deleteStatement.setString(1, ancienGareDepart);
    		deleteStatement.setString(2, ancienGareArrivee);
    		deleteStatement.setString(3, ancienneDate);
    		deleteStatement.setInt(4, ancienPrix);
    		deleteStatement.executeUpdate();

    		// Ajouter le nouveau trajet
    		PreparedStatement insertStatement = st.getConnection().prepareStatement(
    		"INSERT INTO train (GareDepart, GareArrivee, Date, Prix) VALUES (?, ?, ?, ?)");
    		insertStatement.setString(1, nouveauGareDepart);
    		insertStatement.setString(2, nouveauGareArrivee);
    		insertStatement.setString(3, nouvelleDate);
    		insertStatement.setInt(4, nouveauPrix);
    		insertStatement.executeUpdate();

    		System.out.println("Trajet modifié avec succès.");
    		} catch (SQLException e) {
    		System.out.println("Erreur lors de la modification du trajet : " + e.getMessage());
    		}

}

    		





    public static void ajouterCarteReduction(String carte, int codeAdherent, int pourcentage) {
        try {
            Statement st = connectONCF();
            PreparedStatement statement = st.getConnection().prepareStatement("INSERT INTO reduction (Carte, CodeAdhérent, Pourcentage) VALUES (?, ?, ?)");
            statement.setString(1, carte);
            statement.setInt(2, codeAdherent);
            statement.setInt(3, pourcentage);
            statement.executeUpdate();
            System.out.println("Carte de réduction ajoutée avec succès.");
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de la carte de réduction : " + e.getMessage());
        }
    }
    public static void modifierCarteReduction(String ancienneCarte, int ancienCodeAdherent, int ancienPourcentage, String nouvelleCarte, int nouveauCodeAdherent, int nouveauPourcentage) {
        try {
            Statement st = connectONCF();
            // Supprimer l'ancienne carte de réduction
            PreparedStatement deleteStatement = st.getConnection().prepareStatement("DELETE FROM reduction WHERE Carte = ? AND CodeAdhérent = ?");
            deleteStatement.setString(1, ancienneCarte);
            deleteStatement.setInt(2, ancienCodeAdherent);
            deleteStatement.executeUpdate();

            // Ajouter la nouvelle carte de réduction
            PreparedStatement insertStatement = st.getConnection().prepareStatement("INSERT INTO reduction (Carte, CodeAdhérent, Pourcentage) VALUES (?, ?, ?)");
            insertStatement.setString(1, nouvelleCarte);
            insertStatement.setInt(2, nouveauCodeAdherent);
            insertStatement.setInt(3, nouveauPourcentage);
            insertStatement.executeUpdate();

            System.out.println("Carte de réduction modifiée avec succès.");
        } catch (SQLException e) {
            System.out.println("Erreur lors de la modification de la carte de réduction : " + e.getMessage());
        }
    }


    public static void supprimerCarteReduction(String carte, int codeAdherent) {
        try {
        	Statement st = connectONCF();
        	PreparedStatement statement = st.getConnection().prepareStatement("DELETE FROM reduction WHERE Carte = ? AND CodeAdhérent = ?");
            statement.setString(1, carte);
            statement.setInt(2, codeAdherent);
            statement.executeUpdate();
            System.out.println("Carte de réduction supprimée avec succès.");
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression de la carte de réduction : " + e.getMessage());

        }
    }
    public static void ajouterAdmin(String admin, String motDePasse) {
        try {
            Statement st = Connexion.connectONCF();
            PreparedStatement statement = st.getConnection().prepareStatement("INSERT INTO admin (user, pwd) VALUES (?, ?)");
            statement.setString(1, admin);
            statement.setString(2, motDePasse);
            statement.executeUpdate();
            System.out.println("Admin ajouté avec succès.");
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de l'admin : " + e.getMessage());
        }
    }
    public static void ajouterUtilisateur(String utilisateur, String motDePasse) {
        try {
            Statement st = Connexion.connectONCF();
            PreparedStatement statement = st.getConnection().prepareStatement("INSERT INTO utilisateur (User, Pwd) VALUES (?, ?)");
            statement.setString(1, utilisateur);
            statement.setString(2, motDePasse);
            statement.executeUpdate();
            System.out.println("Utilisateur ajouté avec succès.");
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de l'utilisateur : " + e.getMessage());
        }
    }

    public static void supprimerUtilisateur(String username) {
        try {
            Statement st = connectONCF();
            PreparedStatement statement = st.getConnection().prepareStatement("DELETE FROM utilisateur WHERE User = ?");
            statement.setString(1, username);
            statement.executeUpdate();
            System.out.println("Utilisateur supprimé avec succès.");
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression de l'utilisateur : " + e.getMessage());
        }
    }
    public static void modifierUtilisateur(String ancienUtilisateur, String nouvelUtilisateur, String nouveauMotDePasse) {
        try {
            // Connect to the database
            Statement st = Connexion.connectONCF();
            
            // Update the utilisateur details
            PreparedStatement updateStatement = st.getConnection().prepareStatement(
                    "UPDATE utilisateur SET User = ?, Pwd = ? WHERE User = ?");
            updateStatement.setString(1, nouvelUtilisateur);
            updateStatement.setString(2, nouveauMotDePasse);
            updateStatement.setString(3, ancienUtilisateur);
            updateStatement.executeUpdate();

            System.out.println("Utilisateur modifié avec succès.");
        } catch (SQLException e) {
            System.out.println("Erreur lors de la modification de l'utilisateur : " + e.getMessage());
        }
    }

    public static void supprimerAdmin(String username) {
        try {
            Statement st = connectONCF();
            PreparedStatement statement = st.getConnection().prepareStatement("DELETE FROM admin WHERE user = ?");
            statement.setString(1, username);
            statement.executeUpdate();
            System.out.println("Admin supprimé avec succès.");
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression de l'admin : " + e.getMessage());
        }
    }
    public static void modifierAdmin(String ancienAdmin, String nouvelAdmin, String nouveauMotDePasse) {
        try {
            // Connect to the database
            Statement st = Connexion.connectONCF();
            
            // Update the utilisateur details
            PreparedStatement updateStatement = st.getConnection().prepareStatement(
                    "UPDATE admin SET user = ?, pwd = ? WHERE user = ?");
            updateStatement.setString(1, nouvelAdmin);
            updateStatement.setString(2, nouveauMotDePasse);
            updateStatement.setString(3, ancienAdmin);
            updateStatement.executeUpdate();

            System.out.println("Admin modifié avec succès.");
        } catch (SQLException e) {
            System.out.println("Erreur lors de la modification de l'utilisateur : " + e.getMessage());
        }
    }


}


}
