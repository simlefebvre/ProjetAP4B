package View;

/**
 * Page d'ajout d'un videoprojecteur
 *
 */

public class AjouterVideoprojecteur {
	//Constructeur
	public AjouterVideoprojecteur() {
		Formulaire page = new Formulaire();
		//Entete
		page.addTitle("Ajout d'un videoprojecteur");
		//Contenu de la page
		page.addTextField("Saisir l'identifiant ");
		page.addTextField("Saisir l'�tat ");
		page.addTextField("Saisir la salle ");
		page.addCheckBox("Le videoprojecteur poss�de une t�l�commande ");
		//Pied de page
		page.addButtonFoot("Annuler", null);
		page.addButtonFoot("Valider", null);
	}
}
