package View;

import Controller.MainClass;
import Controller.menuPersonnelControler;
import Model.Utilisateur.Administrateur;

/**
 * Menu principal, propre au type d'utilisateur (Administrateur ou Personnel)
 */
public class PageMenuPersonnel {
	// Attributs
	protected Formulaire page;
	private menuPersonnelControler mpc;

	// Constructeur
	public PageMenuPersonnel(ViewManager vm) {
		mpc = new menuPersonnelControler(vm);
		page = new Formulaire(false);
		
		// Entete de la page
		page.addTitle("Menu principal");
		
		// Contenu de la page
		page.addLabel("infoConnecte", "Connect� en tant que " + MainClass.connecte.getPrenom() + " " + MainClass.connecte.getNom());
		page.addButton("mat", "Afficher le mat�riel", mpc);
		page.addButton("reservation", "Afficher mes r�servations", mpc);
		page.addButton("profil", "Afficher mon profil", mpc);

		if (MainClass.connecte instanceof Administrateur) {
			page.addButton("utilisateurs", "Afficher la liste des utilisateurs", mpc);
		}
		
		// Pied de page
		page.addButtonFoot("D�connexion", "deconnexion", mpc);
		page.addButtonFoot("Quitter", "quitter", mpc);
	}

	
	
	/**
	 * M�thode permettant de fermer la page
	 */
	public void close() {
		page.close();
	}
}