package Model.Agenda;

import java.util.Date;

import Model.Utilisateur.Utilisateur;

public class Reservation{
	//Attributs
	private Date debut;
	private Date fin;
	private Utilisateur par;
	
	//TODO redefinir le equals de reservation
	//Constructeur
	public Reservation(Date debut, Date fin, Utilisateur par) {
		this.debut=debut;
		this.fin=fin;
		this.par=par;
	}
	
	
	//Méthodes de récupération et de modification des attributs
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
	
	
	//Autres méthodes
	
}
