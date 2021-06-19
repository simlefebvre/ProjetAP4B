package View;

import javax.swing.JPanel;

import Controller.AffInfoMatController;
import Controller.AffReservationController;
import Model.Agenda.Reservation;
import Model.DataBase.ConnexionSQL;
import Model.Materiel.Materiel;
import Model.Materiel.Ordinateur;
import Model.Materiel.Tablette;
import Model.Utilisateur.Utilisateur;

/**
 * Classe permettant d'affiche les r�servations effectu�es
 */
public class AfficherReservationsMateriel {	
	//Attributs
	private Formulaire page;
	private AffReservationController arc;
	private AffInfoMatController aimc;
	
	
	//Constructeurs
	/**
	 * Constructeur permettant d'afficher les r�servations effectu�es pour un mat�riel
	 * @param page	Page sur laquelle afficher les r�servations
	 * @param idMat	identifiant du mat�riel dont les r�servations sont affich�es
	 * @param vm	le ViewManager
	 */
	public AfficherReservationsMateriel(Formulaire page, int idMat,ViewManager vm) {
		aimc = new AffInfoMatController(vm);
		this.page=null;
		page.addLabel("reservations","R�servations du mat�riel : ");		
		
		for (Reservation res : ConnexionSQL.getReservationMat(idMat)) {
			JPanel instance = new JPanel();
			page.addLabel("Debut : " + Reservation.formatDate.format(res.getDebut()), instance);
			page.addLabel("          ", instance);
			page.addLabel("Fin : " + Reservation.formatDate.format(res.getFin()), instance);
			page.addLabel("          ", instance);
			page.addLabel("par : " + res.getPar().getNom() + " " + res.getPar().getPrenom(), instance);
			page.addButton("suppr_"+ res.getID()+"_" + idMat, "Supprimer", aimc, instance);
		}	
		
		page.addButton("Ajouter", "ajouter", aimc);
	}
	
	
	
	
	
	/**
	 * Constructeur permettant d'afficher les r�servations effectu�es par un utilisateur
	 * @param vm	le ViewManager
	 * @param user	l'utilisateur dont les r�servations sont affich�es
	 */
	public AfficherReservationsMateriel(ViewManager vm, Utilisateur user) {
		arc = new AffReservationController(vm);
		page = new Formulaire(true);
		
		page.addTitle("Mes r�servations : ");
		
		//Pour chaque mat�riel, afficher les r�servations faites par l'utilisateur
			for (Reservation res : ConnexionSQL.getReservationUsr(user.getMail())) {
					JPanel instance;
					Materiel mat = res.getMat();
					
					if (mat instanceof Ordinateur) {
						instance = page.addLabel("infosMat", "Ordinateur            id : " + mat.getID() + "          Salle : " + mat.getSalle() + "          ");
					} else if (mat instanceof Tablette) {
						instance = page.addLabel("infosMat", "  Tablette              id : " + mat.getID() + "          Salle : " + mat.getSalle() + "          ");
					} else {
						instance = page.addLabel("infosMat", "Videoprojecteur       id : " + mat.getID() + "          Salle : " + mat.getSalle() + "          ");
					}
					
					page.addLabel("Debut : "+ Reservation.formatDate.format(res.getDebut()), instance);
					page.addLabel("          ", instance);
					page.addLabel("Fin : "+ Reservation.formatDate.format(res.getFin()), instance);
					page.addLabel("          ", instance);
					
					page.addButton("suppr_"+ res.getID()+"_" + mat.getID(), "Supprimer", arc, instance);
		}
			
		page.addButton("ajouter", "Ajouter", arc);		
		page.addButtonFoot("Retour ", "retour", arc);
	}



	/**
	 * M�thode permettant de fermer la page
	 */
	public void close() {
		page.close();		
	}
}