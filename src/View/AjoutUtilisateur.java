package View;

/**
 * Classe d'ajout d'utilisateurs
 */
public class AjoutUtilisateur {
	private Formulaire page;

	// Constructeur
	public AjoutUtilisateur() {
		page = new Formulaire();
		// Entete
		page.addTitle("Ajout d'un utilisateur");
		// Contenu de la page
		page.addTextField("Saisir le nom ", "nom");
		page.addTextField("Saisir le prenom ", "prenom");
		page.addPasswordField("Saisir le mot de passe ", "mdp");
		page.addTextField("Saisir l'adresse mail ", "mail");
		//TODO Tester si addresse existe pas deja dans la BDD ==> uniciteMail(String addresse)
		page.addCheckBox("L'utilisateur est un administrateur", "admin");
		// Pied de page
		page.addButtonFoot("Annuler", "annuler", null);
		page.addButtonFoot("Valider", "valider", null);
	}

	public void close() {
		page.close();
	}

}
