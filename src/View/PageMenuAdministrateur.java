package View;
/**
 * Menu principal pour l'administrateur
 */
public class PageMenuAdministrateur extends PageMenuPersonnel{	
	//Constructeur
	public PageMenuAdministrateur() {
		//Contenu de la page
		page.addButton("utilisateurs", "Afficher la liste des utilisateurs", null);
	}	
}