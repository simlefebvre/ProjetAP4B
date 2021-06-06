package View;

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
		page.addCheckBox("Un ordinateur");
		page.addCheckBox("Un videoprojecteur");
		page.addCheckBox("Une tablette");
		//Pied de page
		page.addButtonFoot("Annuler", null);
		page.addButtonFoot("Valider", null);
	}

}
