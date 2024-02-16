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
}
