package View;

import java.util.LinkedList;

/**
 * Page permettant l'ajout d'un mat�riel
 */
public class AjoutMateriel {
	//Constructeur
	public AjoutMateriel() {
		Formulaire page = new Formulaire();
		//Entete
		page.addTitle("Ajouter un mat�riel");
		//Contenu de la page
		//TODO Remplcer checkbox par radioButton
		LinkedList<String> choix = new LinkedList<>();
		choix.add("Un ordinateur");
		choix.add("Un videoprojecteur");
		choix.add("Une tablette");
		page.addRadioButtonGroup(3,"Quel mat�riel voulez-vous ajouter ?",choix);
		
		//Pied de page
		page.addButtonFoot("Annuler", null);
		page.addButtonFoot("Valider", null);
	}

}
