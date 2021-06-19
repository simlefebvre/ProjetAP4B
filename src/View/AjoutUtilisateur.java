package View;

import java.util.LinkedList;

import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controller.AjoutUtilisateurController;

/**
 * Classe d'ajout d'utilisateurs
 */
public class AjoutUtilisateur {
	//Attributs
	private PopUp page;
	private AjoutUtilisateurController ajoutUC;

	// Constructeur
	public AjoutUtilisateur(ViewManager newvm) {
		this.ajoutUC = new AjoutUtilisateurController(newvm);
		page = new PopUp();
		
		// Entete
		page.addTitle("Ajout d'un utilisateur");
		// Contenu de la page
		page.addTextField("Saisir le nom ", "nom");
		page.addTextField("Saisir le prenom ", "prenom");
		page.addPasswordField("Saisir le mot de passe ", "mdp");
		page.addPasswordField("Resaisir le mot de passe ", "mdpRe");
		page.addTextField("Saisir l'adresse mail ", "mail");
		page.addCheckBox("L'utilisateur est un administrateur", "admin");
		// Pied de page
		page.addButtonFoot("Annuler", "annuler", ajoutUC);
		page.addButtonFoot("Valider", "valider", ajoutUC);
	}

	
	
	/**
	 * M�thode permettant de r�cup�rer la liste des JTextField pr�sents sur la page
	 * @return la liste des JTextField
	 */
	public LinkedList<JTextField> getText() {
		return page.getTextes();
	}
	
	/**
	 * M�thode permettant de r�cup�rer la liste des JPasswordField pr�sents sur la page
	 * @return la liste des JPasswordField
	 */
	public LinkedList<JPasswordField> getPW() {
		return page.getmdp();
	}

	/**
	 * M�thode permettant de r�cup�rer la liste des JCheckBox pr�sents sur la page
	 * @return la liste des JCheckBox
	 */
	public LinkedList<JCheckBox> getCB() {
		return page.getChoches();
	}
	
	
	
	/**
	 * M�thode permettant de fermer la page
	 */
	public void close() {
		page.close();
	}
}
