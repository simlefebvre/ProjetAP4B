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
		JPanel pan;
		pan = page.addButton("matDispo","Afficher le matériel disponible",null);
		page.addButton("reserve", "Afficher le matériel réservé", null);
		page.addButton("profil", "Afficher mon profil", null);
		//TODO Ajouter page profil
		//Pied de page
		page.addButtonFoot("Déconnexion", "deconnexion", null); 
	}
	
	
	public void close() {
		page.close();
	}
	
}