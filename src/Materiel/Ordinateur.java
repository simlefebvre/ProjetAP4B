package Materiel;

import Agenda.Agenda;

public class Ordinateur extends Materiel{
	//Attributs
	private boolean fixe;
	private int capacite;
	
	//Constructeur
	public Ordinateur(int id, String etat, String salle, Agenda reservations, boolean fixe, int capacite) {
		super(id, etat, salle, reservations);
		this.fixe=fixe;
		this.capacite=capacite;
	}
	
	//Méthodes de récupération et de modification des attributs
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
