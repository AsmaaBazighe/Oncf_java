package codes;
import java.sql.*;
import javax.swing.*;
import java.awt.*;


public class Train {
    
    public static void window(Poucent poucentInstance,String dep,String arr,String dat) {
    	int poucentValue = poucentInstance.getValue();
        JFrame f = new JFrame();
        f.setTitle("ONCF");
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel(new GridBagLayout());
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        f.add(scrollPane);
        
        try {
            Statement st = Connexion.connectONCF();
            ResultSet resGare = st.executeQuery("select * from train");

            while (resGare.next()) {
            	if (resGare.getString(1).equals(dep) && resGare.getString(2).equals(arr)) {
            		String gd=resGare.getString(1);//depart
            		String ga=resGare.getString(2);//arrivée
            		String d=resGare.getString(3);//date
            		int p=resGare.getInt(4);//prix
            		Styles.organiserTrain(mainPanel,gd,ga,d,p,poucentValue);
            	}  
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        JButton returnButton = new JButton("Retour");
        GoTo.page(returnButton);
        mainPanel.add(returnButton);
        Styles.bgColor(mainPanel);
        f.setVisible(true);
    }   
}
