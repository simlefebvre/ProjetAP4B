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
		page.addButton("mat","Afficher le mat�riel",null);
		page.addButton("reservation", "Afficher les r�servations", null);
		//TODO Ajouter page materiel reserv�
		page.addButton("profil", "Afficher mon profil", null);
		//TODO Ajouter page profil
		//Pied de page
		page.addButtonFoot("D�connexion", "deconnexion", null);
	}
	
	public void close() {
		page.close();
	}
}