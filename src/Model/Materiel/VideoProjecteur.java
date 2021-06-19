package Model.Materiel;

/**
 * Un vidéoprojecteur est un matériel. <br>
 * Il peut posséder une télécommande.
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


	
	// Méthodes de récupération et de modification des attributs
	public boolean getTelecommande() {
		return this.telecommande;
	}

	public void setTelecommande(boolean newTelecommande) {
		this.telecommande = newTelecommande;
	}
}
