package View;

//TODO Ajouter doc
/**
 *
 */
public class ViewManager {

	public PageConnexion page;
	public PageMenuPersonnel pMenu;
	
	public ViewManager() {
		page = new PageConnexion(this);
	}
	public void showMenuProf() {
		pMenu = new PageMenuPersonnel();		
	}
}
