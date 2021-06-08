package Model.Agenda;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Model.Utilisateur.Utilisateur;

/**
 * Représente un crénaux de reservation.<br>
 * Il est composé :
 * <ul>
 * <li>d'une date de début,</li>
 * <li>d'une date de fin,</li>
 * <li>d'un utilisateur qui a effectué la reservation.</li>
 * </ul>
 */
public class Reservation {

	// Attributs
	private Date debut;
	private Date fin;
	private Utilisateur par;
	private SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	

	// Constructeur
	public Reservation(String newdebut, String newfin, Utilisateur par) {
		Date debutResa = strToDate(newdebut);
		Date finResa = strToDate(newfin);
		
		if(debutResa.compareTo(finResa) <= 0) {
			//debutConv avant fin
			this.debut = debutResa;
			this.fin = finResa;
		}else {
			//fin avant debutConv
			this.debut = finResa;
			this.fin = debutResa;
		}
		
		this.par = par;
	}
	
	
	
	// Méthodes de récupération et de modification des attributs
	public String getDebut() {
		return formatDate.format(this.debut);
	}

	public void setDebut(String newdebut) {
		this.debut = strToDate(newdebut);
	}

	public String getFin() {
		return formatDate.format(this.fin);
	}
	
	public void setFin(String newfin) {
		this.fin = strToDate(newfin);
	}
	

	public Utilisateur getPar() {
		return this.par;
	}

	public void setPar(Utilisateur par) {
		this.par = par;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Reservation) {
			Reservation b = (Reservation) o;
			if (b.getDebut() == getDebut() && b.getFin() == getFin() && b.getPar() == getPar()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	
	
	// Autres méthodes
	/**
	 * Convertie une chaine de caracteres en Date
	 * @param date chaine de caracteres contenant la date 
	 * @return la date convertie
	 */
	public Date strToDate(String date) {
		try {
			return formatDate.parse(date);
		} catch (ParseException e) {
            e.printStackTrace();
            try {
    			return formatDate.parse("01/01/1900 00:00");
    		} catch (ParseException f) {
                f.printStackTrace();
            }
        }
		return new Date();
	}
	
	
	
	//TODO Tester si matériel deja reservé
	
	
}
