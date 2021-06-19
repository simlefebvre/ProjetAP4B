package View;

import java.util.LinkedList;

import javax.swing.JRadioButton;

import Controller.ChoixAjoutMatController;

/**
 * Page permettant de choisir le type de matériel à ajouter
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
		page.addTitle("Ajouter un matériel");
		// Contenu de la page
		LinkedList<String> choix = new LinkedList<>();
		choix.add("Un ordinateur");
		choix.add("Un videoprojecteur");
		choix.add("Une tablette");
		page.addRadioButtonGroup(3, "Quel matériel voulez-vous ajouter ?", choix);
		// Pied de page
		page.addButtonFoot("Annuler", "annuler", camc);
		page.addButtonFoot("Valider", "valider", camc);
	}

	
	
	
	/**
	 * Méthode permettant de récupérer la liste des JRadioButton présents sur la page
	 * @return la liste des JRadioButton
	 */
	public LinkedList<JRadioButton> getButton() {
		return page.getGroupes();
	}
	
	
	
	/**
	 * Méthode permettant de fermer la page
	 */
	public void close() {
		page.close();
	}
}
