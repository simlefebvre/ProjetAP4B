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
	private String identifiant;
	private Date debut;
	private Date fin;
	private Utilisateur par;
	
	public static SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	

	// Constructeur
	public Reservation (Date debutResa, Date finResa, Utilisateur par) {		
		if(debutResa.compareTo(finResa) <= 0) {
			//debutConv avant fin
			this.debut = debutResa;
			this.fin = finResa;
		}else {
			//fin avant debutConv
			this.debut = finResa;
			this.fin = debutResa;
		}
		
		this.identifiant = genererID(this.debut, this.fin);
		this.par = par;
	}
	
	
	
	// Méthodes de récupération et de modification des attributs
	public String getID() {
		return this.identifiant;
	}
	
	public void setID(String id) {
		this.identifiant = id;
	}
	
	/*
	public String getDebut() {
		return formatDate.format(this.debut);
	}
	*/
	public Date getDebut() {
		return this.debut;
	}

	public void setDebut(String newdebut) {
		this.debut = strToDate(newdebut);
	}

	/*
	public String getFin() {
		return formatDate.format(this.fin);
	}
	*/
	public Date getFin() {
		return this.fin;
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
	public static Date strToDate(String date) {
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
	
	
	
	/**
	 * Génère un identifiant de réservation à partir des dates de début et de fin
	 * @param debut date de début de la réservation
	 * @param fin	date de fin de la réservation
	 * @return		l'identifiant généré
	 */
	public String genererID(Date debut, Date fin) {
		String debutStr = formatDate.format(debut);
		String finStr = formatDate.format(fin);
		return debutStr+finStr;
	}	
}
