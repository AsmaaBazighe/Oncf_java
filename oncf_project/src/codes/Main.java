package codes;

import javax.swing.*;
import java.awt.*;
import admin.*;

public class Main {
    public static void main(String[] args) {
    	SwingUtilities.invokeLater(new Runnable() {
    	   
    	    public void run() {
    	        createAndShowGUI();
    	    }
    	});
    }

    private static void createAndShowGUI() {
    	JFrame f = new JFrame();
        f.setTitle("ONCF");
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel adminPanel = createAdminPanel();
        JPanel userPanel = createUserPanel();

        tabbedPane.addTab("Admin", adminPanel);
        tabbedPane.addTab("User", userPanel);

        f.getContentPane().add(tabbedPane, BorderLayout.CENTER);

        
        f.setVisible(true);
    }

    private static JPanel createAdminPanel() {
    	JPanel panel = new JPanel();
	    panel.setLayout(new BorderLayout());
	    JPanel adminContentPanel = Login.window();
	    panel.add(adminContentPanel, BorderLayout.CENTER);
	    return panel;
    }

    private static JPanel createUserPanel() {
    	    JPanel panel = new JPanel();
    	    panel.setLayout(new BorderLayout());
    	    JPanel userContentPanel = Page.window();
    	    panel.add(userContentPanel, BorderLayout.CENTER);
    	    return panel;
    	
    }
}
