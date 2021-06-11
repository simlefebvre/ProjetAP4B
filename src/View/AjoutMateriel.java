package View;

import java.util.LinkedList;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

import Controller.AjoutMatController;
import Model.Materiel.Materiel;
import Model.Materiel.Ordinateur;
import Model.Materiel.Tablette;

/**
 * Page permettant l'ajout d'un matériel
 */
public class AjoutMateriel {
	private PopUp page;
	private ViewManager vm;
	private Materiel mat;
	private AjoutMatController amc;
	
	// Constructeur
	public AjoutMateriel(ViewManager viewManager, Materiel mat) {

		page = new PopUp();
		this.vm = viewManager;
		this.amc = new AjoutMatController(vm);
		this.mat = mat;
		//Partie commune		
		//Contenu de la page
		page.addTextField("Saisir la marque ", "marque");
		page.addTextField("Saisir l'état ", "etat");
		page.addTextField("Saisir la salle ", "salle");
		
		// Pied de page
		page.addButtonFoot("Annuler", "annuler", amc);
		page.addButtonFoot("Valider", "valider", amc);
		
		
		
		//Partie propre	
		if (mat instanceof Ordinateur) {
			page.addTitle("Ajouter un ordinateur");
			page.addCheckBox("L'ordinateur est fixe ", "fixe", false, false, null);
			page.addCheckBox("L'ordinateur possède une souris", "souris", false, false, null);
			page.addTextField("Capacite : ", "capacite", "", null, false);
		} else if (mat instanceof Tablette) {
			page.addTitle("Ajouter une tablette");
			page.addCheckBox("La tablette possède un clavier", "clavier", false, false, null);
		} else {
			page.addTitle("Ajouter un videoprojecteur");
			page.addCheckBox("Le videoprojecteur possède une télécommande ", "telecommande", false, false, null);
		}
	}

	public void close() {
		page.close();
	}

	public Materiel getMat() {
		return mat;
	}
	
	public LinkedList<JTextField> getText() {
		return page.getTextes();
	}
	
	public LinkedList<JCheckBox> getCoches() {
		return page.getChoches();
	}
}
