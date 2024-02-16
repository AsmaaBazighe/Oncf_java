package codes;
import admin.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;



public class GoTo {
	
	
	public static void train(JButton button,final JComboBox<String> departComboBox,final JComboBox<String> arriveeComboBox,final JComboBox<String> listdate,final Poucent poucentInstance) {
		button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Object selectedDepartItem = departComboBox.getSelectedItem();
         		String selectedDepartText = selectedDepartItem.toString();
         		Object selectedArriveItem = arriveeComboBox.getSelectedItem();
         		String selectedArriveText = selectedArriveItem.toString();
         		Object selectedDateItem = listdate.getSelectedItem();
         		String selectedDateText = selectedDateItem.toString();
         		Train.window(poucentInstance, selectedDepartText,selectedArriveText,selectedDateText);
        	}
        });
    }
	
	public static void trainreduit(JButton button,final ArrayList<RedData> data,final JComboBox<String> departComboBox,final JComboBox<String> arriveeComboBox,final JComboBox<String> listdate,final JTextField monCode,final JComboBox<String> maCarte,final Poucent poucentInstance) {
		 button.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                String selectedCard = maCarte.getSelectedItem().toString();
	                String enteredCode = monCode.getText().trim();

	                // Vérifier si la carte et le code sont corrects
	                boolean credentialsCorrect = checkCredentials(selectedCard, enteredCode);

	                if (credentialsCorrect) {
	                    // Les informations sont correctes, récupérer le pourcentage et passer à la fenêtre suivante
	                    int pourcentage = getPourcentage(selectedCard);
	                    // Vous pouvez utiliser "pourcentage" comme vous le souhaitez ici
	                    poucentInstance.setValue(pourcentage);
	                    Object selectedDepartItem = departComboBox.getSelectedItem();
	            		String selectedDepartText = selectedDepartItem.toString();
	            		Object selectedArriveItem = arriveeComboBox.getSelectedItem();
	            		String selectedArriveText = selectedArriveItem.toString();
	            		Object selectedDateItem = listdate.getSelectedItem();
	            		String selectedDateText = selectedDateItem.toString();
	            		Train.window(poucentInstance, selectedDepartText,selectedArriveText,selectedDateText);
	                } else {
	                    // Les informations ne sont pas correctes, effacer les zones de texte
	                    monCode.setText("");
	                    // Vous pouvez également ajouter un message d'erreur ou une action supplémentaire si nécessaire
	                }
	            }

	            // Méthode pour vérifier si la carte et le code sont corrects
	            private boolean checkCredentials(String card, String code) {
	                // Mettez votre logique de vérification ici
	                // Par exemple, vous pouvez rechercher dans la liste des données (data) pour vérifier la correspondance
	                for (RedData redData : data) {
	                    if (redData.getCard().equals(card) && redData.getCode().equals(code)) {
	                        return true;
	                    }
	                }
	                return false;
	            }

	            // Méthode pour obtenir le pourcentage associé à la carte
	            private int getPourcentage(String card) {
	                // Mettez votre logique pour obtenir le pourcentage à partir de la liste des données (data)
	                for (RedData redData : data) {
	                    if (redData.getCard().equals(card)) {
	                        return redData.getPourcentage();
	                    }
	                }
	                return 0; // Vous pouvez définir une valeur par défaut ou gérer le cas où la carte n'est pas trouvée
	            }
	        });
	}
	
	public static void page(JButton button) {
		button.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                Main.main(null);
            }
        });
    }
	public static void loginAdmin(JButton button) {
		button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
         		Login.window();
        	}
        });
    }
	
	
	public static void tarifnormal(JButton button) {
		button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Tarifnormal.window();
        	}
        });
    }
	
	
	public static void tarifreduit(JButton button) {
		button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Tarifreduit.window();
        	}
        });
    }
	
	
	public static void ticket(JButton button,final JTextField user,final JTextField psw,final ArrayList<User> data,final String gd,final String ga,final String d ,final int p) {
		button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String selectedUser = user.getText().trim();
        		String enteredPwd = psw.getText().trim();
        		boolean credentialsCorrect = checkCredentials(selectedUser, enteredPwd);
        		if (credentialsCorrect) {
        			Ticket.window(gd,ga,d,p);
        		}else {
        			psw.setText("");
        			user.setText("");
        		}
        	}

           
            private boolean checkCredentials(String card, String code) {
                for (User userData : data) {
                    if (userData.getUsername().equals(card) && userData.getPassword().equals(code)) {
                        return true;
                    }
                }
                return false;
            }
        });
    }
	
	
	public static void payement(JButton button,final String gd,final String ga,final String d ,final int p) {
		button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Payement.window(gd,ga,d,p);
        	}
        });
	}
	public static void choix(JButton button) {
		button.addActionListener(new ActionListener() {
        
            public void actionPerformed(ActionEvent e) {
                Choix.main(null);
            }
        });
    }
	public static void reduction(JButton button) {
		button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Reduction.window();
        	}
        });
    }
	public static void trains(JButton button) {
		button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Trains.window();
        	}
        });
    }
	public static void utilisateur(JButton button) {
		button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Utilisateur.window();
        	}
        });
    }
}
