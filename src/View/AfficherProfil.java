package View;

public class AfficherProfil {
	//Attributs	
	protected Formulaire page;

	//Constructeur
	public AfficherProfil() {
		page = new Formulaire();
		//Entete
		page.addTitle("Menu principal");
	}
		
	public void close() {
		page.close();
	}
}
