package Controller;

import Model.DataBase.BaseDeDonee;
import Model.Utilisateur.Utilisateur;
//import View.PageMenuPersonnel;
import View.PageConnexion;
import View.ViewManager;

public class MainClass {
	
	public static void main(String[] args) {
		//PageConnexion con = new PageConnexion();
		//PageMenuPersonnel menuPerso = new PageMenuPersonnel();
		ViewManager vm = new ViewManager();
		BaseDeDonee.getInstance().addUtilisateur(new Utilisateur("admin", "admin", "admin", "admin"));
	}

}
