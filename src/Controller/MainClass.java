package Controller;

import Model.DataBase.ConnexionSQL;
import Model.Utilisateur.Utilisateur;
import View.ViewManager;

/**
 * Classe main du projet gérant unniqument le lancement du projet et la connexion à la base de donée
 */
public class MainClass {
	public static Utilisateur connecte;
	public ViewManager vm;

	public static void main(String[] args) {
		ConnexionSQL.connect(); //connection à la base de donées
		ViewManager vm = new ViewManager(); //affichage de la première page
		
	}
}
