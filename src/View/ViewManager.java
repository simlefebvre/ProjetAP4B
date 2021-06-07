package View;

//TODO Ajouter doc
/**
 *
 */
public class ViewManager {

	public PageConnexion page;
	public PageMenuPersonnel pMenu;
	public AfficherMateriels pAffMat;
	public AfficherReservationsMateriel pAffReserv;
	public AfficherInfosUtilisateur pProfil;

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
		String mail="admin";
		pProfil = new AfficherInfosUtilisateur(this, mail);
	}

	public void showAfficherReservation() {
		int idMat = 8934;
		pAffReserv = new AfficherReservationsMateriel(this, idMat);
	}
	// TODO Lier page AfficherUtilisateurs
}
