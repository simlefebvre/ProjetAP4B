package Model.Agenda;

import java.util.Date;
import java.util.LinkedList;

import Model.Utilisateur.Utilisateur;

/**
 * Un agenda représente l'ensemble des réservations d'un matériel.
 * 
 */
public class Agenda {
	// Attributs
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
	 * @param deb   la date de début de la reservation
	 * @param fin   la date de fin de la reservation
	 * @param user  l'utilisateur qui fait la reservation
	 */
	public void modifierReservation(int index, Date deb, Date fin, Utilisateur user) {
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

}
