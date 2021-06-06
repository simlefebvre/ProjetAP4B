package View;

/**
 * Classe d'ajout d'utilisateurs
 */
public class AjoutUtilisateur {
	private Formulaire page;
	//Constructeur
	public AjoutUtilisateur() {
		page = new Formulaire();
		//Entete
		page.addTitle("Ajout d'un utilisateur");
		//Contenu de la page
		page.addTextField("Saisir le nom ");
		page.addTextField("Saisir le prenom ");
		//TODO transformer en mdp
		page.addTextField("Saisir le mot de passe ");
		page.addTextField("Saisir l'adresse mail ");
		page.addCheckBox("L'utilisateur est un administrateur");
		//Pied de page
		page.addButtonFoot("Annuler", null);
		page.addButtonFoot("Valider", null);
	}
	
	public void close() {
		page.close();
	}

}
