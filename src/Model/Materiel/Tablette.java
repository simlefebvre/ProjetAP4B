package Model.Materiel;

/**
 * Une tablette est un matériel. <br>
 * Elle peut posséder un clavier.
 */

public class Tablette extends Materiel {
	// Attribut
	private boolean clavier;

	
	
	// Constructeurs
	public Tablette(String marque, String etat, String salle, boolean clavier) {
		super(marque, etat, salle);
		this.clavier = clavier;
	}

	public Tablette(String marque, String etat, String salle, boolean clavier,int identifiant) {
		super(marque, etat, salle, identifiant);
		this.clavier = clavier;
	}
	
	public Tablette() {
		super();
		this.clavier = false;
	}

	
	
	// Méthodes de récupération et de modification des attributs
	public boolean getClavier() {
		return this.clavier;
	}

	public void setClavier(boolean newClavier) {
		this.clavier = newClavier;
	}
}
