package View;

/**
 * Page d'ajout d'un ordinateur
 *
 */
public class AjouterOrdinateur {
	//Constructeur
	public AjouterOrdinateur() {
		Formulaire page = new Formulaire();
		//Entete
		page.addTitle("Ajout d'un ordinateur");
		//Contenu de la page
		page.addTextField("Saisir l'identifiant ");
		page.addTextField("Saisir l'�tat ");
		page.addTextField("Saisir la salle ");
		page.addCheckBox("L'ordinateur est fixe ");
		page.addCheckBox("L'ordinateur poss�de une souris");
		page.addTextField("Saisir la capacit� ");
		//Pied de page
		page.addButtonFoot("Annuler", null);
		page.addButtonFoot("Valider", null);
	}
}
