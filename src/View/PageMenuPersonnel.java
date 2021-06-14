package View;

import javax.swing.JPanel;

import Controller.MainClass;
import Controller.menuPersonnelControler;
import Model.Utilisateur.Administrateur;

/**
 * Menu principal pour le personnel
 */
public class PageMenuPersonnel {
	// Attributs
	protected Formulaire page;
	private menuPersonnelControler mpc;
	private ViewManager vm;

	// Constructeur
	public PageMenuPersonnel(ViewManager vm) {
		this.vm = vm;
		mpc = new menuPersonnelControler(vm);
		page = new Formulaire(false);
		// Entete
		page.addTitle("Menu principal");
		// Contenu de la page
		page.addButton("mat", "Afficher le matériel", mpc);
		page.addButton("reservation", "Afficher mes réservations", mpc);
		page.addButton("profil", "Afficher mon profil", mpc);

		if (MainClass.connecte instanceof Administrateur) {
			page.addButton("utilisateurs", "Afficher la liste des utilisateurs", mpc);
		}
		
		// Pied de page
		page.addButtonFoot("Déconnexion", "deconnexion", mpc);
	}

	public void close() {
		page.close();
	}
}