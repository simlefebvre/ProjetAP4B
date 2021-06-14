	package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Model.Utilisateur.Utilisateur;
import View.ViewManager;

public class ModifierInfosUtilisateurController implements MouseListener{
	private ViewManager vm;
	private Utilisateur util;

	public ModifierInfosUtilisateurController(ViewManager vm, Utilisateur util) {
		this.vm = vm;
		this.util = util;
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() instanceof JButton) {
			JButton b = (JButton) e.getSource();
			if (b.getName().equalsIgnoreCase("valider")) {
								
				//Controler la validit� des champs
				for(JTextField tf : vm.pModifInfoUtil.getText()) {
					if(tf.getText().isEmpty()) {
						//V�rifier que tout est rempli
						JOptionPane.showMessageDialog(null, "Il faut remplir tous les champs", "Erreur champs mal remplis", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				
				//Controler la validit� des mots de passe si utilisateur connect� est admin et qu'il ne modifie pas son profil
				String NewMDP = "";
				boolean nouveauMDP = false;
				for(JPasswordField pw : vm.pModifInfoUtil.getmdp()) {
					String pwname =pw.getName();
					//TODO prendre en compte cas o� l'admin change mdp d'un utilisateur
					//V�rifier que ancien mdp valide
					if(pwname.equals("mdpAncien")) {
						NewMDP = new String(pw.getPassword());
						if (!util.controleMDP(NewMDP)) {
							JOptionPane.showMessageDialog(null, "Erreur mauvais mot de passe", "Erreur saisie mot de passe", JOptionPane.ERROR_MESSAGE);
							return;
						}
					}
					
					//Controle si mdpNouveau saisi
					if(pwname.equals("mdpNouveau")) {
						String testNewMDP = new String(pw.getPassword());
						if(!testNewMDP.isEmpty()) {
							NewMDP = testNewMDP;
							nouveauMDP = true;
						}
					}
					
					//Controle si mdpConfimer saisi et existe
					if(pwname.equals("mdpConfirmer")) {
						if(nouveauMDP) {
							String testNewMDP = new String(pw.getPassword());
							if(testNewMDP.isEmpty()) {
								JOptionPane.showMessageDialog(null, "Erreur confirmer le nouveau mot de passe", "Erreur saisie confirmation mot de passe", JOptionPane.ERROR_MESSAGE);
								return;
							}
							if(testNewMDP.compareTo(NewMDP)!=0) {
								JOptionPane.showMessageDialog(null, "Erreur les mots de passe ne correspondent pas", "Erreur saisie mots de passe", JOptionPane.ERROR_MESSAGE);
								return;
							}
							//Enregistrer nouveau mot de passe
							util.setMDP(NewMDP);
						}
						
					}
				}
				
				
				
				//Ajouter les valeurs des champs � l'utilisateur
				for(JTextField tf : vm.pModifInfoUtil.getText()) {
					String tfname =tf.getName();
					if(tfname.equals("nom")) {
						this.util.setNom(tf.getText());
					}else if(tfname.equals("prenom")) {
						this.util.setPrenom(tf.getText());
					}else if(tfname.equals("mail")) {
						this.util.setMail(tf.getText());
					}
				}
			
				JOptionPane.showMessageDialog(null, "Modifications Sauvegard�es");
				vm.pModifInfoUtil.close();
				
				//TODO Si besoin, passer une variable en paramtere qui donne la page qui a ouvert celle l�
				//Mise � jour de la page showProfil
				//this.vm.pProfil.close();
				//this.vm.showProfil();
			
			} else if (b.getName().equals("retour")) {
				this.vm.pModifInfoUtil.close();
			} 
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
}
