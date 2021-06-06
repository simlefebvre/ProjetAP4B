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
		page.addTextField("Saisir l'identifiant ","id");
		page.addTextField("Saisir l'état ","etat");
		page.addTextField("Saisir la salle ","salle");
		page.addCheckBox("La tablette possède un clavier","clavier");
		//Pied de page
		page.addButtonFoot("Annuler", "annuler", null);
		page.addButtonFoot("Valider", "valider", null);
	}
	
	public void close() {
		page.close();
	}
}
