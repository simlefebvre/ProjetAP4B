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
	//Attributs
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
		
		//------Partie commune------	
		//Contenu de la page
		page.addTextField("Saisir la marque ", "marque");
		page.addTextField("Saisir l'état ", "etat");
		page.addTextField("Saisir la salle ", "salle");
		
		// Pied de page
		page.addButtonFoot("Annuler", "annuler", amc);
		page.addButtonFoot("Valider", "valider", amc);
		

		//------Partie propre------
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

	

	/**
	 * Méthode permettant de récupérer la liste des JTextField présents sur la page
	 * @return la liste des JTextField
	 */
	public LinkedList<JTextField> getText() {
		return page.getTextes();
	}
	
	
	
	/**
	 * Méthode permettant de récupérer la liste des JCheckBox présents sur la page
	 * @return la liste des JCheckBox
	 */
	public LinkedList<JCheckBox> getCoches() {
		return page.getChoches();
	}
	
	
	
	/**
	 * Méthodes retournant le matériel ajouté
	 * @return le matériel ajouté
	 */
	public Materiel getMat() {
		return mat;
	}
	
	
	
	/**
	 * Méthode permettant de fermer la page
	 */
	public void close() {
		page.close();
	}
}
