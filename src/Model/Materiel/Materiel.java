package Model.Materiel;

import java.util.LinkedList;

import Model.Agenda.Agenda;
import Model.Agenda.Reservation;
import Model.DataBase.BaseDeDonee;

/**
 * Un matériel représente un objet pouvant être réservé par un utilisateur.
 */
public class Materiel {
	// Attributs
	protected int identifiant;
	protected String marque;
	protected String etat;
	protected String salle;
	protected Agenda reservations;

	// Constructeur
	public Materiel(String marque, String etat, String salle) {
		this.identifiant = genererID();
		this.marque = marque;
		this.etat = etat;
		this.salle = salle;
		this.reservations = new Agenda();
	}

	public Materiel() {
		this.identifiant = genererID();
		this.marque = null;
		this.etat = null;
		this.salle = null;
		this.reservations = new Agenda();
	}

	// Méthodes de récupération et de modification des attributs
	public int getID() {
		return this.identifiant;
	}

	public void setID(int id) {
		this.identifiant = id;
	}

	public String getMarque() {
		return this.marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
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
	
	public LinkedList<Reservation> getReservations() {
		return reservations.getListe();
	}
	
	public Agenda getAgenda() {
		return reservations;
	}
	
	public void addReservation(Reservation r) {
		reservations.ajouterReservation(r);
	}
	
	
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Materiel) {
			Materiel b = (Materiel) o;
			if (b.getID() == getID()) {
				return true;
			} else {
				return false;
			}

		} else {
			return false;
		}
	}

	
	
	/**
	 * Génère un identifiant unique pour le matériel
	 * @return l'identifiant généré
	 */
	public int genererID() {
		if(BaseDeDonee.getInstance().getMateriels().size()==0) {
			return 0;
		}
		return BaseDeDonee.getInstance().getMateriels().getLast().getID() + 1;
	}
}
