package Model.Materiel;

import java.util.Date;
import java.util.LinkedList;

import Model.Agenda.Reservation;
import Model.DataBase.ConnexionSQL;
import Model.Utilisateur.Utilisateur;

/**
 * Un matériel représente un objet pouvant être réservé par un utilisateur.
 */
public class Materiel {
	// Attributs
	protected int identifiant;
	protected String marque;
	protected String etat;
	protected String salle;

	
	
	// Constructeur
	public Materiel(String marque, String etat, String salle) {
		this.identifiant = genererID();
		this.marque = marque;
		this.etat = etat;
		this.salle = salle;
	}
	
	public Materiel(String marque, String etat, String salle,int identifiant) {
		this.identifiant = identifiant;
		this.marque = marque;
		this.etat = etat;
		this.salle = salle;
	}

	public Materiel() {
		this.identifiant = genererID();
		this.marque = null;
		this.etat = null;
		this.salle = null;
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
		
	/**
	 * Méthode retournant la liste des Reservations dans la base de données
	 * @return a liste des Reservations
	 */
	public LinkedList<Reservation> getReservations() {
		return ConnexionSQL.getReservationMat(getID());
	}
	
	/**
	 * Méthode permettant l'ajout d'une réservation
	 */
	public void addReservation(Reservation r) {
		ConnexionSQL.newReservation(r);
	}
	
	
	
	/**
	 * Méthode permettant de comparer deux matériels
	 * @return o le deuxième matériel à comparer
	 */
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
		if(ConnexionSQL.getMateriels().size()==0) {
			return 0;
		}
		return ConnexionSQL.getMateriels().getLast().getID() + 1;
	}
	
	
	public void supprimerAgenda(Utilisateur usr) {
		String mail = usr.getMail();
		for(Reservation r : ConnexionSQL.getReservationUsr(mail)) {
			ConnexionSQL.delReservation(r.getID(), mail);
		}
	}
	
	
	
	/**
	 * Teste si le matériel à réserver est disponible sur le créneau saisi ou non
	 * @param debutTest	Date et heure début du créneau souhaité
	 * @param finTest	Date et heure fin du créneau souhaité
	 * @return	true si metériel disponible, false sinon
	 */
	public boolean disponible (Date debutTest, Date finTest) {
		int ID = this.getID();
		LinkedList<Reservation> occupation = ConnexionSQL.getReservationMat(ID);
		if(occupation.size() == 0) {
			return true;
		}
		for(Reservation r :  occupation) {
			//Si une nouvelle date (debut ou fin) inclue dans les dates d'une réservation
			if ((debutTest.compareTo(r.getDebut())<0 && finTest.compareTo(r.getDebut())<=0)) {
				//debutTest et finTest pas avant r.getDebut()
				return true;
			}else if ((debutTest.compareTo(r.getFin())>=0 && finTest.compareTo(r.getFin())>0)) {
				//debutTest et finTest pas apres r.getFin()
				return true;
			}
		}
		return false;
	}

}
