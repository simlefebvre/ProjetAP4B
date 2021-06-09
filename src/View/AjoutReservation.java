package View;

import java.util.LinkedList;

import Controller.MainClass;
import Model.Materiel.Materiel;

public class AjoutReservation {
	//Attribut
	private Formulaire page;
	private ViewManager vm;
	private LinkedList<Materiel> ListeMat;
	//Constructeur
	public AjoutReservation(LinkedList<Materiel> ListeMat,ViewManager vm) {
		this.vm = vm;
		page = new Formulaire();
		this.ListeMat = ListeMat;
		
		
		//Entete
		page.addTitle("Nouvelle réservation");
		
		//Contenu de la page	
		page.addLabel("LabInstruction", "Saisir la date et l'heure selon le format suivant : jj/MM/yyyy hh:mm");
		page.addTextField("Date et heure de début  ", "debut");
		page.addTextField("Date et heure de fin  ", "fin");
		//TODO Quand ajout reservation, tester si conversion en Date ok ==> il faut qu'elle soit différente de "01/01/1900 00:00" (en String)
		

		page.addMarge(1);
		page.addTextField("Saisir votre adresse mail  ", "mail", MainClass.connecte.getMail(), null, false);
		
		
		//Pied de page
		page.addButtonFoot("Annuler", "annuler", null);
		page.addButtonFoot("Valider", "valider", null);
	}
	
	public LinkedList<Materiel> getmat(){
		return ListeMat;
	}
}