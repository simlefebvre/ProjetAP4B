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
		page = new PageConnexion(this);
	}
	public void showMenuProf() {
		pMenu = new PageMenuPersonnel(this);
	}
	
	public void showMaterielDispo() {
		pAffMat = new AfficherMateriels();
	}
	
	public void showProfil() {
		pProfil = new AfficherProfil();
	}
	
	public void showAfficherReservation() {
		pAffReserv = new AfficherReservations();
	}
	//TODO Faire page AfficherUtilisateurs
}
