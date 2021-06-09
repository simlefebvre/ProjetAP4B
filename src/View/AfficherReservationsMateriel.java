package View;

import javax.swing.JPanel;

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
	// Constructeurs
	public AfficherReservationsMateriel(Formulaire page, int idMat) {
		
		this.page=null;
		this.vm = null;
		page.addLabel("reservations","Réservations du matériel : ");		
		
		Materiel mat = BaseDeDonee.getInstance().getMateriel(idMat);
		
		for (Reservation res : mat.getReservations()) {
			JPanel instance = page.addTextField("Debut : " + res.getDebut(),"debut");
			page.addLabel("          ", instance);
			page.addTextField("Fin : " + res.getFin(), "fin", instance);
			page.addLabel("          ", instance);
			page.addTextField("par : " + res.getPar().getNom() + " " + res.getPar().getPrenom(), "par", instance);
				
			page.addButton("modifier_" + res.getID(), "Modifier", null, instance);
			page.addButton("suppr_" + res.getID(), "Supprimer", null, instance);
		}	
		
		page.addButton("Ajouter", "ajouter", null);
	}
	
	
	
	
	
	
	public AfficherReservationsMateriel(ViewManager vm, Utilisateur user) {
		arc = new AffReservationController(vm);
		this.vm = vm;
		page = new Formulaire(true);
		
		page.addTitle("Mes réservations : ");
		
		//Pour chaque matériel
		for(Materiel mat : BaseDeDonee.getInstance().getMateriels()) {
			//pour chaque résa, check sur faite par user ou pas
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
					//page.addButton("modif_"+ mat.getID() + "_" +res.getID(), "Modifier", arc, instance);
					//TODO ajouter un bouton modifier
					page.addButton("suppr_"+ res.getID()+"_" + mat.getID() , "Supprimer", arc, instance);
				}
			}
		}
		
		page.addButton("Ajouter", "ajouter", arc);		
		
		page.addButtonFoot("Retour", "retour", arc);
	}






	public void close() {
		page.close();		
	}
}