package codes;

import java.awt.*;
import javax.swing.*;

public class Styles {
	public static void buttonStyle(JButton button) {
            button.setBackground(new Color(224,224,236));
            button.setForeground(new Color(0, 0, 0));
            button.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        
    }

    public static void buttonSize(int x, int y, JButton button) {
            button.setPreferredSize(new Dimension(x, y));
    }

    public static void bgColor(JPanel panel) {
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(176,178,207));

    }

    public static void centerButtons(JPanel panel, JButton... buttons) {

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(20, 20, 20, 20);

        
        for (JButton button : buttons) {
            panel.add(button, gbc);
            gbc.gridy++;
        }
        
    }
    public static void organiserNormal(JPanel panel,JPanel buttonPanel, JComboBox<String> departComboBox,JComboBox<String> arriveeComboBox,JComboBox<String> listdate) {
    	Font labelFont = new Font("Comic Sans MS", Font.BOLD, 14);
        Color labelColor = new Color(255, 255, 255); 

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(20, 20, 20, 20);
        JLabel departLabel = new JLabel("Gare de départ:");
        departLabel.setFont(labelFont);
        departLabel.setForeground(labelColor);
        panel.add(departLabel, gbc);
        gbc.gridx++;
        departComboBox.setBackground(new Color(240, 168, 17));
        departComboBox.setForeground(new Color(0, 0, 0));
        panel.add(departComboBox, gbc);
        gbc.gridy++;
        gbc.gridx--;
        JLabel arriveeLabel = new JLabel("Gare d'arrivée:");
        arriveeLabel.setFont(labelFont);
        arriveeLabel.setForeground(labelColor);
        panel.add(arriveeLabel, gbc);
        gbc.gridx++;
        arriveeComboBox.setBackground(new Color(240, 168, 17));
        arriveeComboBox.setForeground(new Color(0, 0, 0));
        panel.add(arriveeComboBox, gbc);
        gbc.gridy++;
        gbc.gridx--;
        JLabel dateLabel = new JLabel("Date de départ:");
        dateLabel.setFont(labelFont);
        dateLabel.setForeground(labelColor);
        panel.add(dateLabel, gbc);
        gbc.gridx++;
        listdate.setBackground(new Color(240, 168, 17));
        listdate.setForeground(new Color(0, 0, 0));
        panel.add(listdate, gbc);
        gbc.gridy++;
        gbc.gridx--;
        gbc.gridx = 1;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.SOUTHEAST; // Coin inférieur droit
        panel.add(buttonPanel, gbc);
        
    }
    
    public static void organiserReduit(JPanel  panel,JPanel buttonPanel,JComboBox<String> maCarte,JTextField monCode, JComboBox<String> departComboBox,JComboBox<String> arriveeComboBox,JComboBox<String> listdate) {
    	Font labelFont = new Font("Comic Sans MS", Font.BOLD, 14);
        Color labelColor = new Color(255, 255, 255); 

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(20, 20, 20, 20);
        JLabel departLabel = new JLabel("Gare de départ:");
        departLabel.setFont(labelFont);
        departLabel.setForeground(labelColor);
        panel.add(departLabel, gbc);
        gbc.gridx++;
        departComboBox.setBackground(new Color(240, 168, 17));
        departComboBox.setForeground(new Color(0, 0, 0));
        panel.add(departComboBox, gbc);
        gbc.gridy++;
        gbc.gridx--;
        JLabel arriveeLabel = new JLabel("Gare d'arrivée:");
        arriveeLabel.setFont(labelFont);
        arriveeLabel.setForeground(labelColor);
        panel.add(arriveeLabel, gbc);
        gbc.gridx++;
        arriveeComboBox.setBackground(new Color(240, 168, 17));
        arriveeComboBox.setForeground(new Color(0, 0, 0));
        panel.add(arriveeComboBox, gbc);
        gbc.gridy++;
        gbc.gridx--;
        JLabel dateLabel = new JLabel("Date de départ:");
        dateLabel.setFont(labelFont);
        dateLabel.setForeground(labelColor);
        panel.add(dateLabel, gbc);
        gbc.gridx++;
        listdate.setBackground(new Color(240, 168, 17));
        listdate.setForeground(new Color(0, 0, 0));
        panel.add(listdate, gbc);
        gbc.gridy++;
        gbc.gridx--;
        JLabel carteLabel = new JLabel("Ma carte:");
        carteLabel.setFont(labelFont);
        carteLabel.setForeground(labelColor);
        panel.add(carteLabel, gbc);
        gbc.gridx++;
        maCarte.setBackground(new Color(240, 168, 17));
        maCarte.setForeground(new Color(0, 0, 0));
        panel.add(maCarte, gbc);
        gbc.gridy++;
        gbc.gridx--;
        JLabel codeLabel = new JLabel("Code d'adherence:");
        codeLabel.setFont(labelFont);
        codeLabel.setForeground(labelColor);
        panel.add(codeLabel, gbc);
        gbc.gridx++;
        monCode.setBackground(new Color(240, 168, 17));
        monCode.setForeground(new Color(0, 0, 0));
        panel.add(monCode, gbc);
        gbc.gridy++;
        gbc.gridx--;
        gbc.gridx = 1;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.SOUTHEAST; // Coin inférieur droit
        panel.add(buttonPanel, gbc);
        
    	
    }
    
    
    public static void organiserTrain(JPanel mainPanel,String gd,String ga,String d ,int p,int poucentValue) {
    	Font labelFont = new Font("Comic Sans MS", Font.BOLD, 14);
        Color labelColor = new Color(255, 255, 255); 
    	GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 20, 0);
        JLabel dapartLabel = new JLabel("Depart:");
        dapartLabel.setFont(labelFont);
        dapartLabel.setForeground(labelColor);
        mainPanel.add(dapartLabel, gbc);
        gbc.gridx++;
        JLabel gdLabel = new JLabel(gd);
        gdLabel.setFont(labelFont);
        gdLabel.setForeground(labelColor);
        mainPanel.add(gdLabel, gbc);
        gbc.gridx++;
        JLabel arriveLabel = new JLabel("Arrivée:");
        arriveLabel.setFont(labelFont);
        arriveLabel.setForeground(labelColor);
        mainPanel.add(arriveLabel, gbc);
        gbc.gridx++;
        JLabel gaLabel = new JLabel(ga);
        gaLabel.setFont(labelFont);
        gaLabel.setForeground(labelColor);
        mainPanel.add(gaLabel, gbc);
        gbc.gridx++;
        JLabel dateLabel = new JLabel("Date:");
        dateLabel.setFont(labelFont);
        dateLabel.setForeground(labelColor);
        mainPanel.add(dateLabel, gbc);
        gbc.gridx++;
        JLabel dLabel = new JLabel(d);
        dLabel.setFont(labelFont);
        dLabel.setForeground(labelColor);
        mainPanel.add(dLabel, gbc);
        gbc.gridx++;
        JLabel prixLabel = new JLabel("Prix:");
        prixLabel.setFont(labelFont);
        prixLabel.setForeground(labelColor);
        mainPanel.add(prixLabel, gbc);
        gbc.gridx++;
        int prix=p-((p*poucentValue)/100);
        JLabel pLabel = new JLabel(Integer.toString(prix));
        pLabel.setFont(labelFont);
        pLabel.setForeground(labelColor);
        mainPanel.add(pLabel, gbc);
        gbc.gridx++;
        JButton choixButton = new JButton("Choisir");
        GoTo.payement(choixButton,gd,ga,d,p);
        Styles.buttonStyle(choixButton);
        mainPanel.add(choixButton, gbc);
        gbc.gridx--;
        gbc.gridx--;
        gbc.gridx--;
        gbc.gridx--;
        gbc.gridx--;
        gbc.gridx--;
        gbc.gridx--;
        gbc.gridx--;
        gbc.gridy++;
    }
    
    public static void organiserPay(JPanel mainPanel,JButton submitButton,JTextField user,JTextField psw) {
    	Font labelFont = new Font("verdana", Font.BOLD, 14);
        Color labelColor = new Color(255, 255, 255); 
    	GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 20, 0);
        JLabel utiLabel = new JLabel("Utilisateur:");
        utiLabel.setFont(labelFont);
        utiLabel.setForeground(labelColor);
        mainPanel.add(utiLabel, gbc);
        gbc.gridx++;
        user.setBackground(new Color(253,247,248));
        user.setForeground(new Color(0, 0, 0));
        mainPanel.add(user, gbc);
        gbc.gridy++;
        gbc.gridx--;
        JLabel mdpLabel = new JLabel("Mot de passe:");
        mdpLabel.setFont(labelFont);
        mdpLabel.setForeground(labelColor);
        mainPanel.add(mdpLabel, gbc);
        gbc.gridx++;
        psw.setBackground(new Color(253,247,248));
        psw.setForeground(new Color(0, 0, 0));
        mainPanel.add(psw, gbc);
        
        gbc.gridy++;
        gbc.gridx--;
        Styles.buttonStyle(submitButton);
        mainPanel.add(submitButton,gbc);
    }

}
