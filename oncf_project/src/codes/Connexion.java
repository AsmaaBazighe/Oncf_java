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
            return null; // You might want to handle the error more gracefully based on your application's requirements
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

    public static void modifierTrajet(String GareDepart, String GareArrivee, String Date, int Prix) {
        try {
            Statement st = connectONCF();
            PreparedStatement statement = st.getConnection().prepareStatement("UPDATE train SET Prix = ? WHERE GareDepart = ? AND GareArrivee = ? AND Date = ?");
            statement.setInt(1, Prix);
            statement.setString(2, GareDepart);
            statement.setString(3, GareArrivee);
            statement.setString(4, Date);
            statement.executeUpdate();
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
    public static void modifierCarteReduction(String carte, int codeAdherent, int pourcentage) {
        try {
            Statement st = connectONCF();
            PreparedStatement statement = st.getConnection().prepareStatement("UPDATE reduction SET Pourcentage = ? WHERE Carte = ? AND CodeAdhérent = ?");
            statement.setInt(1, pourcentage);
            statement.setString(2, carte);
            statement.setInt(3, codeAdherent);
            statement.executeUpdate();
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
}
