	package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Model.DataBase.ConnexionSQL;
import Model.Utilisateur.Administrateur;
import Model.Utilisateur.Utilisateur;
import View.ViewManager;

public class ModifierInfosUtilisateurController implements MouseListener{
	private ViewManager vm;
	private Utilisateur util;
	private String ouvertPar;

	public ModifierInfosUtilisateurController(ViewManager vm, Utilisateur util, String ouvertPar) {
		this.vm = vm;
		this.util = util;
		this.ouvertPar = ouvertPar;
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() instanceof JButton) {
			JButton b = (JButton) e.getSource();
			if (b.getName().equalsIgnoreCase("valider")) {
								
				//Controler la validité des champs
				for(JTextField tf : vm.pModifInfoUtil.getText()) {
					if(tf.getText().isEmpty()) {
						//Vérifier que tout est rempli
						JOptionPane.showMessageDialog(null, "Il faut remplir tous les champs", "Erreur champs mal remplis", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				
				//Controler la validité des mots de passe si utilisateur connecté est admin et qu'il ne modifie pas son profil
				String NewMDP = new String();
				boolean nouveauMDP = false;
				for(JPasswordField pw : vm.pModifInfoUtil.getmdp()) {
					String pwname =pw.getName();
					if(ouvertPar.compareTo("profil")==0) {
						//Vérifier que ancien mdp valide
						if(pwname.equals("mdpAncien")) {
							NewMDP = new String(pw.getPassword());
							if (!util.controleMDP(NewMDP)) {
								JOptionPane.showMessageDialog(null, "Erreur mauvais mot de passe", "Erreur saisie mot de passe", JOptionPane.ERROR_MESSAGE);
								return;
							}
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
						}
						
					}
				}
				
				
				String nom = new String();
				String prenom = new String();
				String NouveauMail = new String();
				
				//Ajouter les valeurs des champs à l'utilisateur
				for(JTextField tf : vm.pModifInfoUtil.getText()) {
					String tfname =tf.getName();
					if(tfname.equals("nom")) {
						nom = tf.getText();
					}else if(tfname.equals("prenom")) {
						prenom = tf.getText();
					}else if(tfname.equals("mail")) {
						NouveauMail = tf.getText();
					}
				}
			
				
				
				//Sauvegarder les nouvelles informations dans la base de données
				//TODO prendre en compte changement admin
				
				//TODO ne pas changer le mail ==> enlever champ mail dans modif profil
				//TODO -------------------------A prendre aussi en compte de là------------------------
				String ancienMail = util.getMail();
				if(nouveauMDP) {
					if(util instanceof Administrateur) {
						ConnexionSQL.modifUtil(ancienMail, NouveauMail, nom, prenom, NewMDP, true);
					}else {
						ConnexionSQL.modifUtil(ancienMail, NouveauMail, nom, prenom, NewMDP, false);
					}
				}else {
					if(util instanceof Administrateur) {
						ConnexionSQL.modifUtil(ancienMail, NouveauMail, nom, prenom, true);
					}else {
						ConnexionSQL.modifUtil(ancienMail, NouveauMail, nom, prenom, false);
					}
				}
				
				if(MainClass.connecte.getMail().equals(ancienMail)){
					MainClass.connecte = ConnexionSQL.getUtilisateur(NouveauMail);
				}
				
				//TODO ------------------------------------------A de là-----------------------------------
					
				JOptionPane.showMessageDialog(null, "Modifications Sauvegardées");
				vm.pModifInfoUtil.close();
				
				if(ouvertPar.compareTo("profil")==0) {
					//Mise à jour de la page showProfil
					this.vm.pProfil.close();
					this.vm.showProfil();
				}else {
					//Mise à jour de la page showAfficherReservation
					this.vm.pAffUtilisateurs.close();
					this.vm.showAfficherUtilisateurs();
				}
				
				
			
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
