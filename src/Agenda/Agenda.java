package Agenda;

import java.util.Date;
import java.util.LinkedList;

import Utilisateur.Utilisateur;

public class Agenda {
	//Attributs
	private LinkedList<Reservation> occupation;
	
	//Constructeur
	public Agenda(){
		occupation = new LinkedList<Reservation>();
	}

	/**
	 * Fonction permettant l'ajout d'une reservation
	 * @param r la reservation que l'on ajoute
	 * @return true si la reservation c'est fait false sinon
	 */
	
	public boolean ajouterReservation(Reservation r) {
		return this.occupation.add(r);
	}
	
	/**
	 * Fonction permettant la supression d'une reservation
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
	 * @param deb la date de d�but de la reservation
	 * @param fin la date de fin de la reservation
	 * @param user l'utilisateur qui fait la reservation
	 */
	public void modifierReservation(int index, Date deb, Date fin, Utilisateur user) {	
		Reservation r = this.occupation.get(index);
		r.setDebut(deb);
		r.setFin(fin);
		r.setPar(user);
	}
	
	/**
	 * recupere � partir d'une reservation son index dans la liste
	 * @param r la reservation dont on cherche l'index (ou une reservation poss�dant les m�mes paramatre
	 * @return l'index de  la reservation
	 */
	public int getIndex(Reservation r){
		if(r.equals(r)) {
			
			//TODO verification
		}
	}
	

	
}
