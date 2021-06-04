package Model.Materiel;

import Model.Agenda.Agenda;


/**
 * Un ordinateur est un mat�riel. 
 * <br>Il peut �tre fixe et est caract�ris� par sa capacit�.
 *
 */


public class Ordinateur extends Materiel{
	//Attributs
	private boolean fixe;
	private int capacite;
	
	//Constructeur
	public Ordinateur(int id, String etat, String salle, Agenda reservations, boolean fixe, int capacite) {
		super(id, etat, salle);
		this.fixe=fixe;
		this.capacite=capacite;
	}
	
	//M�thodes de r�cup�ration et de modification des attributs
	public boolean getFixe() {
		return this.fixe;
	}
	
	public int getCapacite() {
		return this.capacite;
	}
	
	public void setCapacite(int newCapacite) {
		this.capacite=newCapacite;
	}
	
}
