package Controller;


import Model.DataBase.BaseDeDonee;
import Model.Materiel.Ordinateur;
import Model.Materiel.Tablette;
import Model.Utilisateur.Administrateur;
import Model.Utilisateur.Utilisateur;
import View.AfficherMateriels;
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
		//PageConnexion con = new PageConnexion();
		//PageMenuPersonnel menuPerso = new PageMenuPersonnel();
		ViewManager vm = new ViewManager();
		BaseDeDonee.getInstance().addUtilisateur(new Administrateur("admin", "admin", "admin", "admin"));
		BaseDeDonee.getInstance().addUtilisateur(new Utilisateur("user", "user", "user", "user"));
		//AjoutPersonel ap = new AjoutPersonel();
		//AjoutUtilisateur ajoutUti = new AjoutUtilisateur();
		//AjoutMateriel mat = new AjoutMateriel();
		
		BaseDeDonee.getInstance().addMateriel(new Ordinateur(8934, "Asus", "Bon �tat", "B401", true, true, 1024));
		BaseDeDonee.getInstance().addMateriel(new Tablette(8935, "Asus", "Tr�s bon", "B401", true));
		//AfficherMateriels affMat = new AfficherMateriels(vm);
		
		//AjoutMateriel pageMat = new AjoutMateriel();
		
		//AjouterOrdinateur pageOrdi = new AjouterOrdinateur();
		
		//AjouterTablette pageTablette = new AjouterTablette();
		
		//AjouterVideoprojecteur pageVideoproj = new AjouterVideoprojecteur();
		
		//PageMenuPersonnel mp = new PageMenuPersonnel();
		
		//PageMenuAdministrateur ma = new PageMenuAdministrateur();
	}
}
