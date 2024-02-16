package codes;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class Page {
	public static JPanel window() {

        JPanel mainPanel = new JPanel();
        JButton b1 = new JButton("J’achète mon billet avec tarif normal");
        JButton b2 = new JButton("J’achète mon billet avec tarif réduit");
        
        GoTo.tarifnormal(b1);
        GoTo.tarifreduit(b2);
        
        Styles.bgColor(mainPanel);
        Styles.buttonStyle(b1);
        Styles.buttonStyle(b2);
        Styles.buttonSize(500, 100, b1);
        Styles.buttonSize(500, 100,b2);
        Styles.centerButtons(mainPanel, b1,b2);
        
        
        return mainPanel;
    }
}
