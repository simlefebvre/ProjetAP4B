package View;

import java.util.LinkedList;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

import Controller.ModifierInfoMaterielController;
import Model.Materiel.Materiel;
import Model.Materiel.Ordinateur;
import Model.Materiel.Tablette;
import Model.Materiel.VideoProjecteur;

public class ModifierInfoMateriel {
	//Attributs
	private PopUp page;
	private ModifierInfoMaterielController mimc;
	private Materiel mat;
	
	
	
	//Constructeur
	/**
	 * Constructeur de la classe ModifierInfosUtilisateur
	 * @param vm		le ViewManager
	 * @param util		le matériel dont les informations sont affichées
	 */
	public ModifierInfoMateriel(ViewManager vm,Materiel mat) {
		this.mat = mat;
		mimc = new ModifierInfoMaterielController(vm);
		this.page = new PopUp();
		affiche();
	}
	
	
	
	/**
	 * Méthode permettant de générer la page qui affiche les informations d'un matériel
	 */
	private void affiche() {
		page.addLabel("modif", "Veuillez entrer les modification que vous souhaitez apporter");
		page.addTextField("Saisir la marque", "marque", mat.getMarque(), null, false);
		page.addTextField("Saisir la l'état", "etat", mat.getEtat(), null, false);
		page.addTextField("Saisir la salle", "salle", mat.getSalle(), null, false);
		page.addButtonFoot("Annuler", "annuler", mimc);
		page.addButtonFoot("Valider", "valider", mimc);
		
		if(mat instanceof Ordinateur) {
			Ordinateur ordi = (Ordinateur) mat;
			page.addTitle("Modification d'un ordinateur");
			page.addTextField("Saisir la capacité de l'ordinateur", "capacite", "" +ordi.getCapacite(), null, false);
			page.addCheckBox("L'ordinateur est fixe", "fixe", ordi.getFixe(), false, null);
			page.addCheckBox("L'ordinateur possede une souris", "souris", ordi.getSouris(), false, null);
		}else if(mat instanceof Tablette) {
			Tablette tab = (Tablette) mat;
			page.addTitle("Modifier une tablette");
			page.addCheckBox("La tablette possède un clavier", "clavier", tab.getClavier(), false, null);
		} else if(mat instanceof VideoProjecteur){
			VideoProjecteur vp = (VideoProjecteur) mat;
			page.addTitle("Modifier un videoprojecteur");
			page.addCheckBox("Le videoprojecteur possède une télécommande ", "telecommande", vp.getTelecommande(), false, null);
		}
	}
	
	
	
	/**
	 * Méthode permettant de récupérer la liste des JCheckBox présentes sur la page 
	 * @return la liste des JCheckBox
	 */
	public LinkedList<JCheckBox> getCoche(){
		return this.page.getChoches();
	}
	
	/**
	 * Méthode permettant de récupérer la liste des JTextField présents sur la page 
	 * @return la liste des JTextField
	 */
	public LinkedList<JTextField> getText(){
		return page.getTextes();
	}
	
	
	
	/**
	 * Méthode permettant de récupérer le matériel 
	 * @return le matériel
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
