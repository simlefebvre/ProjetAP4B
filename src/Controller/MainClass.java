package Controller;

import Model.DataBase.ConnexionSQL;
import Model.Utilisateur.Utilisateur;
import View.ViewManager;

/**
 * Classe main du projet g�rant unniqument le lancement du projet et la connexion � la base de don�e
 */
public class MainClass {
	public static Utilisateur connecte;

	public static void main(String[] args) {
		ConnexionSQL.connect(); //connection � la base de don�es
		new ViewManager(); //affichage de la premi�re page
	}
}
