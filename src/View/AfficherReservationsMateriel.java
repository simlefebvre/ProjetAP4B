package View;

import javax.swing.JPanel;

import Model.Agenda.Agenda;
import Model.Agenda.Reservation;
import Model.DataBase.BaseDeDonee;
import Model.Materiel.Materiel;

public class AfficherReservationsMateriel {
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
			JPanel pan = page.addTextField("Debut : " + res.getDebut(),"debut");
			//TODO changer format des dates
			page.addLabel("          ", pan);
			page.addTextField("Fin : " + res.getFin(), "fin", pan);
			page.addLabel("          ", pan);
			page.addTextField("par : " + res.getPar().getNom() + " " + res.getPar().getPrenom(), "par", pan);
			
			//TODO boutons mmodifier et supprimer
			
		}
		
		
		//Pied de page
		page.addButtonFoot("Annuler", "annuler", null);
		
		//page.addButtonFoot("Réserver", "reserver", null);
		
		
	}

	public void close() {
		page.close();
	}
}