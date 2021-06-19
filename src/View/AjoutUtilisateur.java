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
	 * Méthode permettant de récupérer la liste des JTextField présents sur la page
	 * @return la liste des JTextField
	 */
	public LinkedList<JTextField> getText() {
		return page.getTextes();
	}
	
	/**
	 * Méthode permettant de récupérer la liste des JPasswordField présents sur la page
	 * @return la liste des JPasswordField
	 */
	public LinkedList<JPasswordField> getPW() {
		return page.getmdp();
	}

	/**
	 * Méthode permettant de récupérer la liste des JCheckBox présents sur la page
	 * @return la liste des JCheckBox
	 */
	public LinkedList<JCheckBox> getCB() {
		return page.getChoches();
	}
	
	
	
	/**
	 * Méthode permettant de fermer la page
	 */
	public void close() {
		page.close();
	}
}
