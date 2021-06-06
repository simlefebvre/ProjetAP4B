package View;

public class AfficherReservations {
	//Attributs	
	protected Formulaire page;
	private ViewManager vm;

	//Constructeur
	public AfficherReservations(ViewManager vm) {
		this.vm = vm;
		page = new Formulaire();
		
		//Entete
		page.addTitle("Mes réservations");
	}
		
	public void close() {
		page.close();
	}
}
