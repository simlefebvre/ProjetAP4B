package Model.Materiel;

/**
 * Un ordinateur est un matériel. <br>
 * Il peut être fixe, peut posséder une souris et est caractérisé par sa
 * capacité.
 */

public class Ordinateur extends Materiel {
	// Attributs
	private boolean fixe;
	private boolean souris;
	private int capacite;

	// Constructeur
	public Ordinateur(String marque, String etat, String salle, boolean fixe, boolean souris, int capacite) {
		super(marque, etat, salle);
		this.fixe = fixe;
		this.souris = souris;
		this.capacite = capacite;
	}

	public Ordinateur() {
		super();
		this.fixe = false;
		this.souris = false;
		this.capacite = 0;
	}

	// Méthodes de récupération et de modification des attributs
	public boolean getFixe() {
		return this.fixe;
	}

	public boolean getSouris() {
		return this.souris;
	}

	public void setSouris(boolean newSouris) {
		this.souris = newSouris;
	}

	public int getCapacite() {
		return this.capacite;
	}

	public void setCapacite(int newCapacite) {
		this.capacite = newCapacite;
	}
	
	public void setFixe(boolean newFixe) {
		this.fixe = newFixe;
	}
}
