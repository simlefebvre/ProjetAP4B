package Materiel;

import Agenda.Agenda;

public class Materiel {
	//Attributs
	private int identifiant;
	private String etat;
	private String salle;
	private Agenda reservations;
	
	//Constructeur
	public Materiel(int id, String etat, String salle, Agenda reservations) {
		this.identifiant=id;
		this.etat=etat;
		this.salle=salle;
		//Est ce qu'on crée l'agenda ici et du coup on passe pas reservations en parametre ??
	}
	
	//Méthodes de récupération et de modification des attributs
	public int getID() {
		return this.identifiant;
		//coucou
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

	//Est ce qu'il en faut pour l'agenda ??
}

