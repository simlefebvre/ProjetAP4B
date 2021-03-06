package View;

import Controller.AffInfoMatController;
import Controller.MainClass;
import Model.DataBase.ConnexionSQL;
import Model.Materiel.Materiel;
import Model.Materiel.Ordinateur;
import Model.Materiel.Tablette;
import Model.Materiel.VideoProjecteur;
import Model.Utilisateur.Administrateur;

/**
 * Classe permettant d'afficher les informations d'un mat?riel
 */
public class AfficherInfosMateriel {
	// Attributs
	private PopUp page;
	private AffInfoMatController lmc;
	private Materiel mat;
	

	// Constructeur
	/**
	 * Constructeur permettant d'afficher les informations d'un mat?riel
	 * @param vm	le ViewManager
	 * @param idMat l'identifiant du mat?riel dont les informations sont affich?es
	 */
	public AfficherInfosMateriel(ViewManager vm, int idMat) {
		this.lmc = new AffInfoMatController(vm);
		page = new PopUp(700,700);

		mat = ConnexionSQL.getMateriel(idMat);

		//------Contenu commun------
		page.addTextField("Identifiant : ", "id", ""+mat.getID(), null, true);
		page.addTextField("Marque : ", "marque", mat.getMarque(), null, true);
		page.addTextField("Etat : ", "etat", mat.getEtat(), null, true);
		page.addTextField("Salle : ", "salle", mat.getSalle(), null, true);

		// Pied de page
		page.addButtonFoot("Retour", "retour", lmc);
		if (MainClass.connecte instanceof Administrateur) {
			page.addButtonFoot("Modifier", "Modifier", lmc);
			page.addButtonFoot("Supprimer","Supprimer",  lmc);
		}

		//------Contenu propre au mat?riel------
		// Entete
		if (mat instanceof Ordinateur) {
			page.addTitle("Ordinateur");
			page.addCheckBox("L'ordinateur est fixe ", "fixe", ((Ordinateur) mat).getFixe(), true, null);
			page.addCheckBox("L'ordinateur poss?de une souris", "souris", ((Ordinateur) mat).getSouris(), true, null);
			page.addTextField("Capacite : ", "capacite", ""+((Ordinateur) mat).getCapacite(), null, true);

		} else if (mat instanceof Tablette) {
			page.addTitle("Tablette");
			page.addCheckBox("La tablette poss?de un clavier", "clavier", ((Tablette) mat).getClavier(), true, null);
		} else {
			page.addTitle("Videoprojecteur");
			page.addCheckBox("Le videoprojecteur poss?de une t?l?commande ", "telecommande", ((VideoProjecteur) mat).getTelecommande(), true, null);
		}

		
		page.addMarge(30);
		
		//Affichage des r?servations du mat?riel
		new AfficherReservationsMateriel(page, idMat,vm);
		
		page.addMarge(30);
	}

	
	
	/**
	 * Fonction retournant le mat?riel dont les informations sont affich?es
	 * @return le mat?riel dont les informations sont affich?es
	 */
	public Materiel getMat() {
		return mat;
	}
	
	
	
	/**
	 * M?thode permettant de fermer la page
	 */
	public void close() {
		page.close();
	}
}
