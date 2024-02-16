package admin;
import codes.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class Page1 {
	public static JPanel window() {

        JPanel mainPanel = new JPanel();
        JButton b1 = new JButton("Admin");
        JButton b2 = new JButton("User");
        
        
        GoTo.page(b2);
	GoTo.choix(b1);
        
        Styles.bgColor(mainPanel);
        Styles.buttonStyle(b1);
        Styles.buttonStyle(b2);
        Styles.buttonSize(500, 100, b1);
        Styles.buttonSize(500, 100,b2);
        Styles.centerButtons(mainPanel, b1,b2);
        
        
        return mainPanel;
    }
}
