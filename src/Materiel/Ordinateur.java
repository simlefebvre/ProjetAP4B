package Materiel;

public class Ordinateur extends Materiel{
	//Attributs
	private boolean fixe;
	private int capacite;
	
	//Constructeur
	public Ordinateur(boolean fixe, int capacite) {
		super();//On va dire que j'ai modifie �a
		this.fixe=fixe;
		this.capacite=capacite;
		//en fait non
	}
	
	//M�thodes de r�cup�ration et de modification des attributs
	public boolean getFixe() {
		return this.fixe;
	}
	
	public int getCapacite() {
		return this.capacite;
	}
	
	public void setCapacite(int newCapacite) {
		this.capacite=newCapacite;
	}
	
}
