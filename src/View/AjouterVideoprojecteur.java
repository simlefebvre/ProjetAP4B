package View;

/**
 * Page d'ajout d'un videoprojecteur
 *
 */

public class AjouterVideoprojecteur {
	private Formulaire page;

	// Constructeur
	public AjouterVideoprojecteur() {
		page = new Formulaire();
		// Entete
		page.addTitle("Ajout d'un videoprojecteur");
		// Contenu de la page
		page.addTextField("Saisir l'identifiant ", "id");
		page.addTextField("Saisir l'état ", "etat");
		page.addTextField("Saisir la salle ", "salle");
		page.addCheckBox("Le videoprojecteur possède une télécommande ", "telecommande");
		// Pied de page
		page.addButtonFoot("Annuler", "annuler", null);
		page.addButtonFoot("Valider", "valider", null);
	}

	public void close() {
		page.close();
	}
}
