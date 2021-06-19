package View;

import java.util.LinkedList;

import javax.swing.JTextField;

import Controller.MainClass;
import Controller.reservationController;
import Model.Materiel.Materiel;

/**
 * Classe permettant l'ajout d'une r�servation
 */
public class AjoutReservation {
	//Attribut
	private PopUp page;
	private ViewManager vm;
	private LinkedList<Materiel> ListeMat;
	private reservationController rc;
	
	
	
	//Constructeur
	public AjoutReservation(LinkedList<Materiel> ListeMat,ViewManager vm) {
		this.vm = vm;
		page = new PopUp();
		this.ListeMat = ListeMat;
		rc = new reservationController(vm);
		
		//Entete
		page.addTitle("Nouvelle r�servation");
		
		//Contenu de la page	
		page.addLabel("LabInstruction", "Saisir la date et l'heure selon le format suivant : jj/MM/yyyy hh:mm");
		page.addTextField("Date et heure de d�but  ", "debut");
		page.addTextField("Date et heure de fin  ", "fin");
		//
		
		page.addMarge(1);
		page.addTextField("Saisir votre adresse mail  ", "mail", MainClass.connecte.getMail(), null, true);
		
		//Pied de page
		page.addButtonFoot("Annuler", "annuler", rc);
		page.addButtonFoot("Valider", "valider", rc);
	}
	
	
	
	/**
	 * M�thodes retournant la liste des mat�riels auxquels la r�servation va �tre ajout�
	 * <br>(une r�servation peut �tre ajout�e � plusieurs mat�riels)
	 * @return la liste des mat�riels auxquels la r�servation va �tre ajout�
	 */
	public LinkedList<Materiel> getmat(){
		return ListeMat;
	}
	
	
	
	/**
	 * M�thode permettant de r�cup�rer la liste des JTextField pr�sents sur la page
	 * @return la liste des JTextField
	 */
	public LinkedList<JTextField> getText(){
		return page.getTextes();
	}
	
	
	
	/**
	 * M�thode permettant de fermer la page
	 */
	public void close() {
		page.close();
	}
}