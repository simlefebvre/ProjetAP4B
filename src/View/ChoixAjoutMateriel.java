package View;

import java.util.LinkedList;

/**
 * Page permettant de choisir le type de matériel à ajouter
 */
public class ChoixAjoutMateriel {
	//Attribut
	private Formulaire page;

	// Constructeur
	public ChoixAjoutMateriel() {
		page = new Formulaire();
		// Entete
		page.addTitle("Ajouter un matériel");
		// Contenu de la page
		LinkedList<String> choix = new LinkedList<>();
		choix.add("Un ordinateur");
		choix.add("Un videoprojecteur");
		choix.add("Une tablette");
		page.addRadioButtonGroup(3, "Quel matériel voulez-vous ajouter ?", choix);
		// Pied de page
		page.addButtonFoot("Annuler", "annuler", null);
		page.addButtonFoot("Valider", "valider", null);
	}

	public void close() {
		page.close();
	}
}
