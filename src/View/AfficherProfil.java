package View;

public class AfficherProfil {
	// Attributs
	protected Formulaire page;
	private ViewManager vm;

	// Constructeur
	public AfficherProfil(ViewManager vm) {
		this.vm = vm;
		page = new Formulaire();
		// Entete
		page.addTitle("Mon profil");
		
		
		//TODO Page a faire
		
		
	}

	public void close() {
		page.close();
	}
}
