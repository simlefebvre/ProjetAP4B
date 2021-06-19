package Model.Materiel;

import java.util.Date;
import java.util.LinkedList;

import Model.Agenda.Reservation;
import Model.DataBase.ConnexionSQL;
import Model.Utilisateur.Utilisateur;

/**
 * Un mat�riel repr�sente un objet pouvant �tre r�serv� par un utilisateur.
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
	
	public Materiel(String marque, String etat, String salle,int index) {
		this.identifiant = index;
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

	// M�thodes de r�cup�ration et de modification des attributs
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
		return ConnexionSQL.getReservationMat(getID());
	}
	
	
	public void addReservation(Reservation r) {
		ConnexionSQL.newReservation(r);
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
	 * G�n�re un identifiant unique pour le mat�riel
	 * @return l'identifiant g�n�r�
	 */
	public int genererID() {
		if(ConnexionSQL.getMateriels().size()==0) {
			return 0;
		}
		return ConnexionSQL.getMateriels().getLast().getID() + 1;
	}
	
	
	public void supprimerAgenda(Utilisateur usr) {
		for(Reservation r : ConnexionSQL.getReservationUsr(usr.getMail())) {
					ConnexionSQL.delReservation(r.getID());
				}
			}
	
	/**
	 * Teste si le mat�riel � r�server est disponible sur le cr�neau saisi ou non
	 * @param debutTest	Date et heure d�but du cr�neau souhait�
	 * @param finTest	Date et heure fin du cr�neau souhait�
	 * @return	true si met�riel disponible, false sinon
	 */
	public boolean disponible (Date debutTest, Date finTest) {
		int ID = this.getID();
		LinkedList<Reservation> occupation = ConnexionSQL.getReservationMat(ID);
		if(occupation.size() == 0) {
			return true;
		}
		for(Reservation r :  occupation) {
			//Si une nouvelle date (debut ou fin) inclue dans les dates d'une r�servation
			if ((debutTest.compareTo(r.getDebut())<0 && finTest.compareTo(r.getDebut())<=0)) {
				//debutTest et finTest, les 2 pas avant r.getDebut()
				return true;
			}else if ((debutTest.compareTo(r.getFin())>=0 && finTest.compareTo(r.getFin())>0)) {
				//debutTest et finTest, les 2 pas apres r.getFin()
				return true;
			}
		}
		return false;
	}

}
