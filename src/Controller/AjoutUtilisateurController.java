package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Model.DataBase.ConnexionSQL;
import Model.Utilisateur.Administrateur;
import Model.Utilisateur.Personnel;
import Model.Utilisateur.Utilisateur;
import View.ViewManager;
/**
 * Controller qui s'occupe de la page d'ajout d'un utilisateur
 */
public class AjoutUtilisateurController implements MouseListener{

	private ViewManager vm;
	
	public AjoutUtilisateurController(ViewManager newvm) {
		this.vm = newvm;
	}
	
	
	/**
	 * Fonction permettant de gérer le boutton annuler et lors d'un appuis sur le boutton valider la création d'un nouvel utilisateur avec les paramètres mis <br>
	 * dans les text field
	 * 
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() instanceof JButton) {
			JButton b = (JButton) e.getSource();
			String nomBouton = b.getName();

			if (nomBouton.equals("annuler")) {
				this.vm.pAjoutUtil.close();
			}else if (nomBouton.equals("valider")) {
				
				String prenom = new String();
				String nom = new String();
				String mail = new String();
				
				//Controler que les champs ne sont pas vides
				for(JTextField tf : vm.pAjoutUtil.getText()) {
					String texte = tf.getText();
					if(texte.isEmpty()) {
						//Vérifier que tout est rempli
						JOptionPane.showMessageDialog(null, "Il faut remplir tous les champs", "Erreur champs mal remplis", JOptionPane.ERROR_MESSAGE);
						return;
					}
					String tfname = tf.getName();
					if(tfname.equals("prenom")) {
						prenom = texte;
					}else if(tfname.equals("nom")) {
						nom = texte;
					}else if(tfname.equals("mail")) {
						//Teste si l'adresse mail existe ou non dans la base de données
						if(Utilisateur.uniciteMail(texte)) {
							mail = texte;
						}else {
							JOptionPane.showMessageDialog(null, "L'adresse mail est déjà présente dans la base de données", "Erreur adresse mail", JOptionPane.ERROR_MESSAGE);
							return;
						}
					}
				}
				
				//Controler que les mots de passe correspondent
				String testNewMDP = new String();
				for(JPasswordField pw : vm.pAjoutUtil.getPW()) {
					//Controle que tous les mots de passe sont remplis
					testNewMDP = new String(pw.getPassword());
					if(testNewMDP.isEmpty()) {
						//Vérifier que tout est rempli
						JOptionPane.showMessageDialog(null, "Il faut remplir tous les champs", "Erreur champs mal remplis", JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					//Controle correspondance des deux mots de passe saisis
					if(pw.getName().equals("mdp")) {
						testNewMDP = new String(pw.getPassword());
					}else {
						if(testNewMDP.compareTo(new String(pw.getPassword())) != 0) {
							JOptionPane.showMessageDialog(null, "Erreur les mots de passe ne correspondent pas", "Erreur saisie mots de passe", JOptionPane.ERROR_MESSAGE);
							return;
						}						
					}
				}
				
				
				//Controler si on crée un Administrateur ou un Personnel
				Boolean etatCoche = vm.pAjoutUtil.getCB().getFirst().isSelected();
				if(etatCoche) {
					ConnexionSQL.newUtil(new Administrateur(prenom,nom,mail,testNewMDP));
				}else{
					ConnexionSQL.newUtil(new Personnel(prenom,nom,mail,testNewMDP));
				}

				//Valider enregistrement
				JOptionPane.showMessageDialog(null, "Modifications Sauvegardées");
				
				//Fermer la page
				vm.pAjoutUtil.close();
				
				//MAJ Liste des utilisateurs
				this.vm.pAffUtilisateurs.close();
				this.vm.showAfficherUtilisateurs();
				
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}
}
