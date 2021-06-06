package View;

/**
 * Page d'ajout d'un ordinateur
 *
 */
public class AjouterOrdinateur {
	//Constructeur
	private Formulaire page;
	public AjouterOrdinateur() {
		page = new Formulaire();
		//Entete
		page.addTitle("Ajout d'un ordinateur");
		//Contenu de la page
		page.addTextField("Saisir l'identifiant ", "id");
		page.addTextField("Saisir l'état ", "etat");
		page.addTextField("Saisir la salle ", "salle");
		page.addCheckBox("L'ordinateur est fixe ", "fixe");
		page.addCheckBox("L'ordinateur possède une souris", "souris");
		page.addTextField("Saisir la capacité ", "capacite");
		//Pied de page
		page.addButtonFoot("Annuler", "valider", null);
		page.addButtonFoot("Valider", "annuler", null);
	}
	
	public void close() {
		page.close();
	}
}
