package View;

import java.util.LinkedList;

/**
 * Page permettant l'ajout d'un mat�riel
 */
public class AjoutMateriel {
	private Formulaire page;
	//Constructeur
	public AjoutMateriel() {
		page = new Formulaire();
		//Entete
		page.addTitle("Ajouter un mat�riel");
		//Contenu de la page
		LinkedList<String> choix = new LinkedList<>();
		choix.add("Un ordinateur");
		choix.add("Un videoprojecteur");
		choix.add("Une tablette");
		page.addRadioButtonGroup(3,"Quel mat�riel voulez-vous ajouter ?",choix);
		//Pied de page
		page.addButtonFoot("Annuler", "annuler", null);
		page.addButtonFoot("Valider", "valider", null);
	}
	
	public void close() {
		page.close();
	}

}
