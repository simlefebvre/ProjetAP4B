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
	private PopUp page;
	private ViewManager vm;
	private AjoutUtilisateurController ajoutUC;

	// Constructeur
	public AjoutUtilisateur(ViewManager newvm) {
		this.vm = newvm;
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

	public void close() {
		page.close();
	}
	
	public LinkedList<JTextField> getText() {
		return page.getTextes();
	}
	
	public LinkedList<JPasswordField> getPW() {
		return page.getmdp();
	}

	public LinkedList<JCheckBox> getCB() {
		return page.getChoches();
	}
}
