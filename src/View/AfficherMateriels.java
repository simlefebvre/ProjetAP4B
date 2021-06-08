package View;

import javax.swing.JPanel;

import Controller.MainClass;
import Controller.listeMaterielController;
import Model.DataBase.BaseDeDonee;
import Model.Materiel.Materiel;
import Model.Materiel.Ordinateur;
import Model.Materiel.Tablette;
import Model.Utilisateur.Administrateur;

/**
 * Page qui affiche le contenu de la liste de matériels de la base de données
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
		page = new Formulaire();

		// TODO Ouvrir en plein écran

		// Entete
		page.addTitle("Liste des matériels");

		// Contenu de la page
		JPanel instance;
		for (Materiel mat : BaseDeDonee.getInstance().getMateriels()) {

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
		//TODO Ajouter réservation à tous les matériels cochés
	}

	public void close() {
		page.close();
	}
	
	public void refresh() {
		page.refresh();
	}
}
