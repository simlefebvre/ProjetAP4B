package View;

import java.util.LinkedList;

import javax.swing.JTextField;

import Controller.MainClass;
import Controller.reservationController;
import Model.Materiel.Materiel;

public class AjoutReservation {
	//Attribut
	private Formulaire page;
	private ViewManager vm;
	private LinkedList<Materiel> ListeMat;
	private reservationController rc;
	//Constructeur
	public AjoutReservation(LinkedList<Materiel> ListeMat,ViewManager vm) {
		
		this.vm = vm;
		page = new Formulaire();
		this.ListeMat = ListeMat;
		rc = new reservationController(vm);
		
		//Entete
		page.addTitle("Nouvelle réservation");
		
		//Contenu de la page	
		page.addLabel("LabInstruction", "Saisir la date et l'heure selon le format suivant : jj/MM/yyyy hh:mm");
		page.addTextField("Date et heure de début  ", "debut");
		page.addTextField("Date et heure de fin  ", "fin");
		//
		

		page.addMarge(1);
		page.addTextField("Saisir votre adresse mail  ", "mail", MainClass.connecte.getMail(), null, true);
		
		
		//Pied de page
		page.addButtonFoot("Annuler", "annuler", rc);
		page.addButtonFoot("Valider", "valider", rc);
	}
	
	public LinkedList<Materiel> getmat(){
		return ListeMat;
	}
	
	public LinkedList<JTextField> getText(){
		return page.getTextes();
	}
	
	public void close() {
		page.close();
	}
}