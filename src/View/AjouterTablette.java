package View;

/**
 * Page d'ajout d'une tablette
 */

public class AjouterTablette {
	//Constructeur
	public AjouterTablette() {
		Formulaire page = new Formulaire();
		//Entete
		page.addTitle("Ajout d'une tablette");
		//Contenu de la page
		page.addTextField("Saisir l'identifiant ");
		page.addTextField("Saisir l'�tat ");
		page.addTextField("Saisir la salle ");
		page.addCheckBox("La tablette poss�de un clavier");
		//Pied de page
		page.addButtonFoot("Annuler", null);
		page.addButtonFoot("Valider", null);
	}
}
