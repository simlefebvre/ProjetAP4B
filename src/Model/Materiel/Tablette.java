package Model.Materiel;

/**
 * Une tablette est un mat�riel. <br>
 * Elle peut poss�der un clavier.
 */

public class Tablette extends Materiel {
	// Attribut
	private boolean clavier;

	// Constructeur
	public Tablette(int id, String marque, String etat, String salle, boolean clavier) {
		super(id, marque, etat, salle);
		this.clavier = clavier;
	}

	// M�thodes de r�cup�ration et de modification des attributs
	public boolean getClavier() {
		return this.clavier;
	}

	public void setClavier(boolean newClavier) {
		this.clavier = newClavier;
	}
}
