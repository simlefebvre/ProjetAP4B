package Model.Materiel;

/**
 * Un ordinateur est un mat�riel. 
 * <br>Il peut �tre fixe, peut poss�der une souris et est caract�ris� par sa capacit�.
 */


public class Ordinateur extends Materiel{
	//Attributs
	private boolean fixe;
	private boolean souris;
	private int capacite;
	
	//Constructeur
	public Ordinateur(int id, String marque, String etat, String salle, boolean fixe, boolean souris, int capacite) {
		super(id, marque, etat, salle);
		this.fixe=fixe;
		this.souris = souris;
		this.capacite=capacite;
	}
	
	//M�thodes de r�cup�ration et de modification des attributs
	public boolean getFixe() {
		return this.fixe;
	}
	
	public boolean getSouris() {
		return this.souris;
	}
	
	public void setSouris(boolean newSouris) {
		this.souris=newSouris;
	}
	
	public int getCapacite() {
		return this.capacite;
	}
	
	public void setCapacite(int newCapacite) {
		this.capacite=newCapacite;
	}
	
}
