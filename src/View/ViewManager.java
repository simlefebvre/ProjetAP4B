package View;

import java.util.LinkedList;

import Controller.MainClass;
import Model.Materiel.Materiel;
import Model.Utilisateur.Utilisateur;


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
	public AfficherUtilisateurs pAffUtilisateurs;
	public AjoutReservation pAjoutReserv;
	public AfficherUtilisateurs pUtilisateurs;
	public AfficherInfosMateriel pAffInfosMat;
	public ModifierInfosUtilisateur pModifInfoUtil;
	public ChoixAjoutMateriel pChoixAjoutMat;
	public AjoutMateriel pAjoutMat;
	public ModifierInfoMateriel pModifMat;
	
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

	public void showAfficherUtilisateurs() {
		pAffUtilisateurs = new AfficherUtilisateurs(this);
	}

	public void showAfficherReservation() {
		pAffReserv = new AfficherReservationsMateriel(this, MainClass.connecte);
	}
	
	public void showReservation(LinkedList<Materiel> mat) {
		this.pAjoutReserv = new AjoutReservation(mat, this);
	}
	
	public void showInfoMat(int id) {
		this.pAffInfosMat = new AfficherInfosMateriel(this, id);
	}
	
	public void showModifierInfosUtilisateur(Utilisateur usr) {
		this.pModifInfoUtil = new ModifierInfosUtilisateur(this, usr);
	}

	public void showAjoutMateriel() {
		this.pChoixAjoutMat = new ChoixAjoutMateriel(this);
	}

	public void showNewMat(Materiel m) {
		pAjoutMat = new AjoutMateriel(this,m);
		
	}
	public void showModifMat(Materiel m) {
		pModifMat = new ModifierInfoMateriel(this, m);
	}
}
