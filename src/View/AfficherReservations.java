package View;

public class AfficherReservations {
	//Attributs	
	protected Formulaire page;

	//Constructeur
	public AfficherReservations() {
		page = new Formulaire();
		//Entete
		page.addTitle("Menu principal");
	}
		
	public void close() {
		page.close();
	}
}
