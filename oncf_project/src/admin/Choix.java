package admin;
import codes.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import admin.*;

public class Choix {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
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

                JPanel userPanel = createUserPanel();
                JPanel reductionPanel = createReductionPanel();
                JPanel trainPanel = createTrainPanel();

                tabbedPane.addTab("Recutions",reductionPanel);
                tabbedPane.addTab("Trains", trainPanel);
                tabbedPane.addTab("Utilisateurs",userPanel);

                f.getContentPane().add(tabbedPane, BorderLayout.CENTER);

                
                f.setVisible(true);
            }

            private static JPanel createReductionPanel() {
            	JPanel panel = new JPanel();
        	    panel.setLayout(new BorderLayout());
        	    JPanel adminContentPanel = Reduction.window();
        	    panel.add(adminContentPanel, BorderLayout.CENTER);
        	    return panel;
            }
            private static JPanel createTrainPanel() {
            	JPanel panel = new JPanel();
        	    panel.setLayout(new BorderLayout());
        	    JPanel adminContentPanel = Trains.window();
        	    panel.add(adminContentPanel, BorderLayout.CENTER);
        	    return panel;
            }
            private static JPanel createUserPanel() {
            	    JPanel panel = new JPanel();
            	    panel.setLayout(new BorderLayout());
            	    JPanel userContentPanel = Utilisateur.window();
            	    panel.add(userContentPanel, BorderLayout.CENTER);
            	    return panel;
            	
            }
          }
