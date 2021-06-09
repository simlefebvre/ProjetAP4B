package View;

import java.util.LinkedList;

import Controller.MainClass;
import Model.Materiel.Materiel;


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
	public AjoutReservation pAjoutReserv;
	public AfficherUtilisateurs pUtilisateurs;
	public AfficherInfosMateriel pAffInfosMat;
	public ModifierInfosUtilisateur pModifInfoUtil;
	
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
		pProfil = new AfficherInfosUtilisateur(this, MainClass.connecte.getMail());
	}

	public void showAfficherReservation() {
		pAffReserv = new AfficherReservationsMateriel(this, MainClass.connecte);
	}
	
	public void showAfficherUtilisateurs() {
		pUtilisateurs = new AfficherUtilisateurs(this);
	}
	
	public void showReservation(LinkedList<Materiel> mat) {
		this.pAjoutReserv = new AjoutReservation(mat, this);
	}
	
	public void showInfoMat(int id) {
		this.pAffInfosMat = new AfficherInfosMateriel(this, id);
	}
	
	public void showModifierInfosUtilisateur() {
		this.pModifInfoUtil = new ModifierInfosUtilisateur(this, MainClass.connecte.getMail());
	}
}
