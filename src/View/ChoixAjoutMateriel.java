package View;

import java.util.LinkedList;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

import Controller.ChoixAjoutMatController;

/**
 * Page permettant de choisir le type de matériel à ajouter
 */
public class ChoixAjoutMateriel {
	//Attribut
	private ChoixAjoutMatController camc;
	private PopUp page;
	private ViewManager vm;

	// Constructeur
	public ChoixAjoutMateriel(ViewManager vm) {
		this.vm = vm;
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

	public void close() {
		page.close();
	}
	
	public LinkedList<JRadioButton> getButton() {
		return page.getGroupes();
	}
}
