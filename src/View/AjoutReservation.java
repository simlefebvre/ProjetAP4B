package View;

import java.util.LinkedList;

import Controller.MainClass;
import Model.Materiel.Materiel;

public class AjoutReservation {
	//Attribut
	private Formulaire page;
	private ViewManager vm;
	
	//Constructeur
	public AjoutReservation(LinkedList<Materiel> ListeMat) {
		page = new Formulaire();
		
		
		//Entete
		page.addTitle("Nouvelle réservation");
		
		//Contenu de la page	
		page.addLabel("LabInstruction", "Saisir la date et l'heure selon le format suivant : jj/MM/yyyy hh:mm");
		page.addTextField("Date et heure de début  ", "debut");
		page.addTextField("Date et heure de fin  ", "fin");
		//TODO Tester si conversion en Date ok 
		

		page.addMarge(1);
		page.addTextField("Saisir votre adresse mail  ", "mail", MainClass.connecte.getMail(), null, false);
		
		
		//Pied de page
		page.addButtonFoot("Annuler", "annuler", null);
		page.addButtonFoot("Valider", "valider", null);
	}
}