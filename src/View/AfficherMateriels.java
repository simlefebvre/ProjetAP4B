package View;

import java.util.LinkedList;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

import Controller.MainClass;
import Controller.listeMaterielController;
import Model.DataBase.ConnexionSQL;
import Model.Materiel.Materiel;
import Model.Materiel.Ordinateur;
import Model.Materiel.Tablette;
import Model.Utilisateur.Administrateur;

/**
 * Page qui affiche la liste de matériels contenus dans la base de données
 */
public class AfficherMateriels {
	// Attribut
	private Formulaire page;
	private ViewManager vm;
	private listeMaterielController lmc;

	// Constructeur
	public AfficherMateriels(ViewManager vm) {
		this.vm = vm;
		this.lmc = new listeMaterielController(vm);
		page = new Formulaire(true);

		// Entete
		page.addTitle("Liste des matériels");

		// Contenu de la page
		JPanel instance;
		page.addLabel("consigne", "Pour réserver des matériels, cocher les cases des matériels souhaités puis cliquer sur Réserver");
		for (Materiel mat : ConnexionSQL.getMateriels()) {

			if (mat instanceof Ordinateur) {
				instance = page.addLabel("infosMat", "Ordinateur            id : " + mat.getID() + "          Etat : "
						+ mat.getEtat() + "          Salle : " + mat.getSalle() + "          ");
			} else if (mat instanceof Tablette) {
				instance = page.addLabel("infosMat", "Tablette               id : " + mat.getID() + "          Etat : "
						+ mat.getEtat() + "          Salle : " + mat.getSalle() + "          ");
			} else {
				instance = page.addLabel("infosMat", "Videoprojecteur       id : " + mat.getID() + "          Etat : "
						+ mat.getEtat() + "          Salle : " + mat.getSalle() + "          ");
			}
			page.addCheckBox("", "selec_" + mat.getID(), instance);

			page.addButton("info_" + mat.getID(), "Plus d'informations", lmc, instance);

			
		}

		// Pied de page
		page.addButtonFoot("Retour", "retour", lmc);
		page.addButtonFoot("Reserver", "reserver", lmc);
		if(MainClass.connecte instanceof Administrateur) {
			page.addButtonFoot("Ajout", "ajout", lmc);
		}
	}

	
	
	/**
	 * Méthode retournant la liste des JCheckBox présentes sur la page
	 * @return la liste des JCheckBox présentes sur la page
	 */
	public LinkedList<JCheckBox> getBox(){
		return page.getChoches();
	}
	
	
	
	/**
	 * Méthode permettant de fermer la page
	 */
	public void close() {
		page.close();
	}
}
