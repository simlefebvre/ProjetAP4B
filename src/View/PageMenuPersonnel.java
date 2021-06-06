package View;

import javax.swing.JPanel;

/**
 * Menu principal pour le personnel
 */
public class PageMenuPersonnel{	
	//Attributs	
	protected Formulaire page;

	//Constructeur
	public PageMenuPersonnel() {
		page = new Formulaire();
		//Entete
		page.addTitle("Menu principal");
		//Contenu de la page
		page.addButton("mat","Afficher le matériel",null);
		page.addButton("reservation", "Afficher les réservations", null);
		//TODO Ajouter page materiel reservé
		page.addButton("profil", "Afficher mon profil", null);
		//TODO Ajouter page profil
		//Pied de page
		page.addButtonFoot("Déconnexion", "deconnexion", null);
	}
	
	public void close() {
		page.close();
	}
}