	package Controller;

import Model.DataBase.ConnexionSQL;
import Model.Utilisateur.Utilisateur;
//import Model.DataBase.BaseDeDonee;
//import Model.Utilisateur.Administrateur;
//import Model.Utilisateur.Utilisateur;
import View.ViewManager;

//import View.ViewManager;
//import Model.DataBase.BaseDeDonee;
//import Model.Materiel.Ordinateur;
//import View.AjoutMateriel;
//import View.AjoutUtilisateur;
//import View.AjoutPersonel;
//import View.AjoutMateriel;
//import View.AjouterVideoprojecteur;

/**
 * Classe main du projet
 */
public class MainClass {
	public static Utilisateur connecte;
	public ViewManager vm;

	public static void main(String[] args) {
		ConnexionSQL.connect();
		
		// PageConnexion con = new PageConnexion();
		// PageMenuPersonnel menuPerso = new PageMenuPersonnel();
		ViewManager vm = new ViewManager();
		
		
		
		/*
		Administrateur admin = new Administrateur("admin", "admin", "admin", "admin");
		//ConnexionSQL.newUtil(admin);
		BaseDeDonee.getInstance().addUtilisateur(admin);
		Personnel usr = new Personnel("user", "user", "user", "user");
		//ConnexionSQL.newUtil(usr);
		BaseDeDonee.getInstance().addUtilisateur(usr);
		// AjoutPersonel ap = new AjoutPersonel();
		// AjoutUtilisateur ajoutUti = new AjoutUtilisateur();
		// AjoutMateriel mat = new AjoutMateriel();
		//AfficherUtilisateurs au = new AfficherUtilisateurs();

		Ordinateur ordi = new Ordinateur("Asus", "Bon �tat", "B401", true, true, 1024);
		Reservation r = new Reservation(Reservation.strToDate("12/02/2020 12:00"), Reservation.strToDate("14/03/2021 15:00"), admin, ordi);
		ordi.addReservation(r);
		BaseDeDonee.getInstance().addMateriel(ordi);
		Tablette tab = new Tablette("Lenovo", "Tr�s bon", "B401", true);
		r = new Reservation(Reservation.strToDate("12/02/2000 12:00"), Reservation.strToDate("14/03/2001 15:00"), admin, tab);
		//ConnexionSQL.newMateriel(tab);
		BaseDeDonee.getInstance().addMateriel(tab);
		BaseDeDonee.getInstance().addMateriel(new VideoProjecteur("Sharp", "Bon", "A803", true));
		//ConnexionSQL.modifMat(1, "Bon", "Lenovo", "B44", true);
		//AfficherMateriels affMat = new AfficherMateriels(vm);
		//ConnexionSQL.delMateriel(0);
		tab.addReservation(r);
		
		//ConnexionSQL.modifUtil("user", "usr", "usr", "usr", false);
		//ConnexionSQL.delUtil("admin");
		//ChoixAjoutMateriel pChoixMat = new ChoixAjoutMateriel();
		

		// PageMenuPersonnel mp = new PageMenuPersonnel();

		//AfficherInfosMateriel aim = new AfficherInfosMateriel(vm, 8935);
		
		

		//AfficherInfosUtilisateur aui = new AfficherInfosUtilisateur(vm, "admin");
		 */
	}
}
