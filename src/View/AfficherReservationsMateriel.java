package View;

import javax.swing.JPanel;

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
		//TODO Quand ajout résa, vérifier si matériel disponible ou non
	}
	
	
	
	
	
	
	public AfficherReservationsMateriel(ViewManager vm, Utilisateur user) {
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
					
					page.addTextField("Debut : ","debut", Reservation.formatDate.format(res.getDebut()), instance, true);
					page.addLabel("          ", instance);
					page.addTextField("Fin : ", "fin", Reservation.formatDate.format(res.getFin()), instance, true);
					page.addLabel("          ", instance);
					page.addButton("modif_"+ res.getID(), "Modifier", null, instance);
					page.addButton("suppr_"+ res.getID(), "Supprimer", null, instance);
				}
			}
		}
		
		page.addButton("Ajouter", "ajouter", null);
		//TODO Rediriger vers liste matériels
		
		
		page.addButtonFoot("Retour", "retour", null);
	}
}