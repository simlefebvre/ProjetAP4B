package Model.Agenda;

import java.util.Date;
import java.util.LinkedList;

import Model.Utilisateur.Utilisateur;

/**
 * Un agenda représente l'ensemble des réservations d'un matériel.
 * 
 */
public class Agenda {
	// Attribut
	private LinkedList<Reservation> occupation;

	
	// Constructeur
	public Agenda() {
		occupation = new LinkedList<Reservation>();
	}

	
	
	/**
	 * Fonction permettant l'ajout d'une reservation
	 * 
	 * @param r la reservation que l'on ajoute
	 * @return true si la reservation c'est fait false sinon
	 */
	public boolean ajouterReservation(Reservation r) {
		return this.occupation.add(r);
	}

	
	
	/**
	 * Fonction permettant la supression d'une reservation
	 * 
	 * @param r la reservation que l'on supprime
	 * @return true si la reservation c'est fait false sinon
	 */
	public boolean supprimerReservation(Reservation r) {
		return this.occupation.remove(r);
	}

	
	
	/**
	 * fonction permettant la modification d'une reservation
	 * 
	 * @param index l'index de la reservation que l'on modifie
	 * @param deb   chaine de caracteres contenant la date de début de la reservation
	 * @param fin   chaine de caracteres contenant la date de fin de la reservation
	 * @param user  l'utilisateur qui fait la reservation
	 */
	public void modifierReservation(int index, String deb, String fin, Utilisateur user) {
		Reservation r = this.occupation.get(index);
		r.setDebut(deb);
		r.setFin(fin);
		r.setPar(user);
	}

	/**
	 * recupere à partir d'une reservation son index dans la liste
	 * 
	 * @param r la reservation dont on cherche l'index (ou une reservation possédant
	 *          les mêmes paramatre
	 * @return l'index de la reservation <br>
	 *         -1 si non trouvé
	 */
	public int getIndex(Reservation r) {
		int i = 0;
		for (Reservation ri : occupation) {
			if (r.equals(ri)) {
				return i;
			}
		}
		return -1;
	}

	
	public int getTaille() {
		return occupation.size();
	}
	
	
	public LinkedList<Reservation> getListe(){
		return occupation;
	}

	
	
	/**
	 * Teste si le matériel à réserver est disponible sur le créneau saisi ou non
	 * @param debutTest	Date et heure début du créneau souhaité
	 * @param finTest	Date et heure fin du créneau souhaité
	 * @return	true si metériel disponible, false sinon
	 */
	public boolean disponible (Date debutTest, Date finTest) {
		for(Reservation r :  occupation) {
			//Si une nouvelle date (debut ou fin) inclue dans les dates d'une réservation
			if ((debutTest.compareTo(r.getDebut())<0 && finTest.compareTo(r.getDebut())<=0)) {
				//debutTest et finTest, les 2 pas r.getDebut()
				return true;
			}else if ((debutTest.compareTo(r.getFin())>=0 && finTest.compareTo(r.getFin())>0)) {
				//debutTest et finTest, les 2 pas r.getFin()
				return true;
			}
		}
		return false;
	}
}
