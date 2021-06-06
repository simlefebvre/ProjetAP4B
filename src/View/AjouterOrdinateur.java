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
		page.addTextField("Saisir l'�tat ", "etat");
		page.addTextField("Saisir la salle ", "salle");
		page.addCheckBox("L'ordinateur est fixe ", "fixe");
		page.addCheckBox("L'ordinateur poss�de une souris", "souris");
		page.addTextField("Saisir la capacit� ", "capacite");
		//Pied de page
		page.addButtonFoot("Annuler", "valider", null);
		page.addButtonFoot("Valider", "annuler", null);
	}
	
	public void close() {
		page.close();
	}
}
