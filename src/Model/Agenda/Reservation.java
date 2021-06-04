package Model.Agenda;

import java.util.Date;

import Model.Utilisateur.Utilisateur;
/**
 * Repr�sente un cr�naux de reservation.<br>
 * Il est composer de : 
 * <ul><li>d'une date de d�but</li> 
 * <li>une date de fin </li>
 * <li>d'un utilisateur qui as effectuer la reservation </li>
 */
public class Reservation{

	//Attributs
	private Date debut;
	private Date fin;
	private Utilisateur par;
	
	//Constructeur
	public Reservation(Date debut, Date fin, Utilisateur par) {
		this.debut=debut;
		this.fin=fin;
		this.par=par;
	}
	
	
	//M�thodes de r�cup�ration et de modification des attributs
	public Date getDebut() {
		return this.debut;
	}
	
	public void setDebut(Date debut) {
		this.debut=debut;
	}
	
	public Date getFin() {
		return this.fin;
	}
	
	public void setFin(Date fin) {
		this.fin=fin;
	}
	
	public Utilisateur getPar() {
		return this.par;
	}
	
	public void setPar(Utilisateur par) {
		this.par=par;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Reservation) {
			Reservation b = (Reservation) o;
			if(b.getDebut() == getDebut() && b.getFin() == getFin() && b.getPar() == getPar()) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	
	//Autres m�thodes
	
}
