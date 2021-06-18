package Model.Materiel;

/**
 * Une tablette est un mat�riel. <br>
 * Elle peut poss�der un clavier.
 */

public class Tablette extends Materiel {
	// Attribut
	private boolean clavier;

	// Constructeur
	public Tablette(String marque, String etat, String salle, boolean clavier) {
		super(marque, etat, salle);
		this.clavier = clavier;
	}

	public Tablette(String marque, String etat, String salle, boolean clavier,int index) {
		super(marque, etat, salle,index);
		this.clavier = clavier;
	}
	
	public Tablette() {
		super();
		this.clavier = false;
	}

	// M�thodes de r�cup�ration et de modification des attributs
	public boolean getClavier() {
		return this.clavier;
	}

	public void setClavier(boolean newClavier) {
		this.clavier = newClavier;
	}
}
