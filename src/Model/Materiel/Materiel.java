package Model.Materiel;

import Model.Agenda.Agenda;

/**
 * Un matériel représente un objet pouvant être réservé par un utilisateur.
 */
public class Materiel {
	//Attributs
	protected int identifiant;
	protected String marque;
	//TODO faire set et get de marque + re constructeur
	protected String etat;
	protected String salle;
	protected Agenda reservations;
	
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
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Materiel) {
			Materiel b = (Materiel) o;
			if(b.getID() == getID()) {
				return true;
			}else {
				return false;
			}
			
		}else {
			return false;
		}
	}
	
}

