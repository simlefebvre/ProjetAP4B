package Model.Materiel;

/**
 * Un vid�oprojecteur est un mat�riel. <br>
 * Il peut poss�der une t�l�commande.
 *
 */
public class VideoProjecteur extends Materiel {
	// Attribut
	private boolean telecommande;

	// Constructeurs
	public VideoProjecteur(String marque, String etat, String salle, boolean telecommande) {
		super(marque, etat, salle);
		this.telecommande = telecommande;
	}

	public VideoProjecteur(String marque, String etat, String salle, boolean telecommande,int identifiant) {
		super(marque, etat, salle, identifiant);
		this.telecommande = telecommande;
	}
	public VideoProjecteur() {
		super();
		this.telecommande = false;
	}


	
	// M�thodes de r�cup�ration et de modification des attributs
	public boolean getTelecommande() {
		return this.telecommande;
	}

	public void setTelecommande(boolean newTelecommande) {
		this.telecommande = newTelecommande;
	}
}
