package View;

import java.util.LinkedList;

import javax.swing.JRadioButton;

import Controller.ChoixAjoutMatController;

/**
 * Page permettant de choisir le type de mat�riel � ajouter
 */
public class ChoixAjoutMateriel {
	//Attribut
	private ChoixAjoutMatController camc;
	private PopUp page;

	// Constructeur
	public ChoixAjoutMateriel(ViewManager vm) {
		camc = new ChoixAjoutMatController(vm);
		page = new PopUp();
		// Entete
		page.addTitle("Ajouter un mat�riel");
		// Contenu de la page
		LinkedList<String> choix = new LinkedList<>();
		choix.add("Un ordinateur");
		choix.add("Un videoprojecteur");
		choix.add("Une tablette");
		page.addRadioButtonGroup(3, "Quel mat�riel voulez-vous ajouter ?", choix);
		// Pied de page
		page.addButtonFoot("Annuler", "annuler", camc);
		page.addButtonFoot("Valider", "valider", camc);
	}

	
	
	
	/**
	 * M�thode permettant de r�cup�rer la liste des JRadioButton pr�sents sur la page
	 * @return la liste des JRadioButton
	 */
	public LinkedList<JRadioButton> getButton() {
		return page.getGroupes();
	}
	
	
	
	/**
	 * M�thode permettant de fermer la page
	 */
	public void close() {
		page.close();
	}
}
