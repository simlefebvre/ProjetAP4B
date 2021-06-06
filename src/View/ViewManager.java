package View;

//TODO Ajouter doc
/**
 *
 */
public class ViewManager {

	public PageConnexion page;
	public PageMenuPersonnel pMenu;
	public AfficherMateriels pAffMat;
	public AfficherReservations pAffReserv;
	public AfficherProfil pProfil;
	
	public ViewManager() {
		showConnexion();
	}
	
	public void showConnexion() {
		page = new PageConnexion(this);
	}
	public void showMenuProf() {
		pMenu = new PageMenuPersonnel(this);
	}
	
	public void showMaterielDispo() {
		pAffMat = new AfficherMateriels(this);
	}
	
	public void showProfil() {
		pProfil = new AfficherProfil(this);
	}
	
	public void showAfficherReservation() {
		pAffReserv = new AfficherReservations(this);
	}
	//TODO Faire page AfficherUtilisateurs
}
