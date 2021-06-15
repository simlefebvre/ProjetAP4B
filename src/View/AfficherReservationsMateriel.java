package View;

import javax.swing.JPanel;

import Controller.AffInfoMatController;
import Controller.AffReservationController;
import Model.Agenda.Reservation;
import Model.DataBase.BaseDeDonee;
import Model.Materiel.Materiel;
import Model.Materiel.Ordinateur;
import Model.Materiel.Tablette;
import Model.Utilisateur.Utilisateur;

public class AfficherReservationsMateriel {	
	//Attributs
	private Formulaire page;
	private ViewManager vm;
	private AffReservationController arc;
	private AffInfoMatController aimc;
	// Constructeurs
	public AfficherReservationsMateriel(Formulaire page, int idMat,ViewManager vm) {
		
		aimc = new AffInfoMatController(vm);
		
		this.page=null;
		this.vm = vm;
		page.addLabel("reservations","Réservations du matériel : ");		
		
		Materiel mat = BaseDeDonee.getInstance().getMateriel(idMat);
		
		for (Reservation res : mat.getReservations()) {
			JPanel instance = new JPanel();
			page.addLabel("Debut : " + Reservation.formatDate.format(res.getDebut()), instance);
			page.addLabel("          ", instance);
			page.addLabel("Fin : " + Reservation.formatDate.format(res.getFin()), instance);
			page.addLabel("          ", instance);
			page.addLabel("par : " + res.getPar().getNom() + " " + res.getPar().getPrenom(), instance);
			//TODO Si temps, vérifier que personne qui supprime a fait la résa ou est admin
			page.addButton("suppr_"+ res.getID()+"_" + mat.getID(), "Supprimer", aimc, instance);
		}	
		
		page.addButton("Ajouter", "ajouter", aimc);
	}
	
	
	
	
	
	
	public AfficherReservationsMateriel(ViewManager vm, Utilisateur user) {
		arc = new AffReservationController(vm);
		this.vm = vm;
		page = new Formulaire(true);
		
		page.addTitle("Mes réservations : ");
		
		//Pour chaque matériel
		for(Materiel mat : BaseDeDonee.getInstance().getMateriels()) {
			for (Reservation res : mat.getReservations()) {
				if (res.getPar() == user) {
					JPanel instance;
					
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
			}
		}
		page.addButton("ajouter", "Ajouter", arc);		
		
		page.addButtonFoot("Retour ", "retour", arc);
	}






	public void close() {
		page.close();		
	}
}