	package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Model.DataBase.ConnexionSQL;
import Model.Utilisateur.Utilisateur;
import View.ViewManager;
/**
 * Controller permettant la gestion de la modification d'un utilisateur
 */
public class ModifierInfosUtilisateurController implements MouseListener{
	private ViewManager vm;
	private Utilisateur util;
	private String ouvertPar;
	
	/**
	 * 
	 * @param vm le view manager du projet
	 * @param util l'utilisateur à modifier
	 * @param ouvertPar l'utilisateur qui à ouvert la page
	 */
	public ModifierInfosUtilisateurController(ViewManager vm, Utilisateur util, String ouvertPar) {
		this.vm = vm;
		this.util = util;
		this.ouvertPar = ouvertPar;
	}
	
	/**
	 * Evenement permettant la gestion des boutons valider et retour qui modifie l'utilisateur si l'utilisateur qui ouvre la page possède les permissions nécéssaire. Cette fonction modifie ainsi l'utilisateur
	 */
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
				
				//Ajouter les valeurs des champs à l'utilisateur
				for(JTextField tf : vm.pModifInfoUtil.getText()) {
					String tfname =tf.getName();
					if(tfname.equals("nom")) {
						nom = tf.getText();
					}else if(tfname.equals("prenom")) {
						prenom = tf.getText();
					}
				}
			
				boolean admin = false;
				//Controle si case administrateur cochée ou non
				for(JCheckBox cb : vm.pModifInfoUtil.getCB()) {
					String cbname =cb.getName();
					if(cbname.equals("CheckAdmin")) {
						admin = cb.isSelected();
					}
				}
				
				//Sauvegarder les nouvelles informations dans la base de données
				String mail = util.getMail();
				if(nouveauMDP) {
					ConnexionSQL.modifUtil(mail, nom, prenom, NewMDP, admin);
				}else {
					ConnexionSQL.modifUtil(mail, nom, prenom, admin);
				}
				
				if(MainClass.connecte.getMail().equals(mail)){
					MainClass.connecte = ConnexionSQL.getUtilisateur(mail);
				}
					
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
