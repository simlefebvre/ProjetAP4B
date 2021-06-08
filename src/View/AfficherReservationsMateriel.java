package View;

import javax.swing.JPanel;

import Model.Agenda.Agenda;
import Model.Agenda.Reservation;
import Model.DataBase.BaseDeDonee;
import Model.Materiel.Materiel;

public class AfficherReservationsMateriel {
	/*
	// Attributs
	protected Formulaire page;
	private ViewManager vm;

	// Constructeur
	public AfficherReservationsMateriel(ViewManager vm, int idMat) {
		this.vm = vm;
		page = new Formulaire();

		// Entete
		page.addTitle("Réservations du matériel");		
		
		Materiel mat = BaseDeDonee.getInstance().getMateriel(idMat);
		
		for (Reservation res : mat.getReservations()) {
			JPanel instance = page.addTextField("Debut : " + res.getDebut(),"debut");
			page.addLabel("          ", instance);
			page.addTextField("Fin : " + res.getFin(), "fin", instance);
			page.addLabel("          ", instance);
			page.addTextField("par : " + res.getPar().getNom() + " " + res.getPar().getPrenom(), "par", instance);
			
			//TODO faudra revoir comment on identifie une reservation
			page.addButton("modifier_" + res.getDebut(), "Modifier", null, instance);
			page.addButton("suppr_" + res.getDebut(), "Supprimer", null, instance);
		}
		
		//Pied de page
		page.addButtonFoot("Annuler", "annuler", null);		
	}

	public void close() {
		page.close();
	}
	*/
	
	// Constructeur
	public static void AfficherReservations(Formulaire page, int idMat) {
			// Entete
			page.addLabel("reservations","Réservations du matériel : ");		
			
			Materiel mat = BaseDeDonee.getInstance().getMateriel(idMat);
			
			for (Reservation res : mat.getReservations()) {
				JPanel instance = page.addTextField("Debut : " + res.getDebut(),"debut");
				page.addLabel("          ", instance);
				page.addTextField("Fin : " + res.getFin(), "fin", instance);
				page.addLabel("          ", instance);
				page.addTextField("par : " + res.getPar().getNom() + " " + res.getPar().getPrenom(), "par", instance);
				
				//TODO faudra revoir comment on identifie une reservation
				page.addButton("modifier_" + res.getDebut(), "Modifier", null, instance);
				page.addButton("suppr_" + res.getDebut(), "Supprimer", null, instance);
			}	
			
			page.addButton("Ajouter", "ajouter", null);
		}
	
	
}