package View;

/**
 * Page d'ajout d'une tablette
 */

public class AjouterTablette {
	private Formulaire page;
	//Constructeur
	public AjouterTablette() {
		page = new Formulaire();
		//Entete
		page.addTitle("Ajout d'une tablette");
		//Contenu de la page
		page.addTextField("Saisir l'identifiant ");
		page.addTextField("Saisir l'état ");
		page.addTextField("Saisir la salle ");
		page.addCheckBox("La tablette possède un clavier");
		//Pied de page
		page.addButtonFoot("Annuler", null);
		page.addButtonFoot("Valider", null);
	}
	
	public void close() {
		page.close();
	}
}
