package Materiel;

import Agenda.Agenda;

public class Materiel {
	//Attributs
	private int identifiant;
	private String etat;
	private String salle;
	private Agenda reservations;
	
	//Constructeur
	public Materiel(int id, String etat, String salle) {
		this.identifiant=id;
		this.etat=etat;
		this.salle=salle;
		this.reservations = new Agenda();
	}
	
	//Méthodes de récupération et de modification des attributs
	public int getID() {
		return this.identifiant;
	}

	public void setID(int id) {
		identifiant = id;
	}
	
	public String getEtat() {
		return this.etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}
	
	public String getSalle() {
		return this.salle;
	}

	public void setSalle(String salle) {
		this.salle = salle;
	}

	//TODO Est ce qu'il en faut pour l'agenda ??
}

