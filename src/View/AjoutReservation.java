package View;

import java.util.Date;

import Model.Utilisateur.Utilisateur;

public class AjoutReservation {
	//Attribut
	private Formulaire page;
	private ViewManager vm;
	
	//Constructeur
	public AjoutReservation() {
		page = new Formulaire();
		//This.vm=;
		
		
		//Entete
		page.addTitle("Nouvelle réservation");
		
		//Contenu de la page
		page.addLabel("LabInstruction", "Saisir la date et l'heure selon le format suivant : jj/MM/yyyy hh:mm");
		page.addTextField("Date et heure de début  ", "debut");
		page.addTextField("Date et heure de fin  ", "fin");
		//TODO quand recuperer debut et fin, tester si conversion en Date ok 
		
		

		page.addMarge(1);
		page.addTextField("Saisir votre adresse mail  ", "mail");
		//TODO controler validite adresse mail	
		
		
		//Pied de page
		page.addButtonFoot("Annuler", "annuler", null);
		page.addButtonFoot("Valider", "valider", null);
	}
}
