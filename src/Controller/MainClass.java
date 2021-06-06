package Controller;

import Model.DataBase.BaseDeDonee;
import Model.Materiel.Ordinateur;
import View.AfficherMateriels;

public class MainClass {
	
	public static void main(String[] args) {
		//PageConnexion con = new PageConnexion();
		//PageMenuPersonnel menuPerso = new PageMenuPersonnel();
		//ViewManager vm = new ViewManager();
		//BaseDeDonee.getInstance().addUtilisateur(new Administrateur("admin", "admin", "admin", "admin"));
		//AjoutPersonel ap = new AjoutPersonel();
		
		//AjoutMateriel mat = new AjoutMateriel();
		
		//BaseDeDonee.getInstance().addMateriel(new Ordinateur(8934, "Bon état", "B401", true, true, 1024));
		BaseDeDonee.getInstance().addMateriel(new Ordinateur(8935, "Très bon", "B401", true, true, 1024));
		AfficherMateriels affMat = new AfficherMateriels();
	}

}
