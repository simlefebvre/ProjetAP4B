package View;

import javax.swing.JPanel;

import Controller.menuPersonnelControler;

/**
 * Menu principal pour le personnel
 */
public class PageMenuPersonnel{	
	//Attributs	
	protected Formulaire page;
	private menuPersonnelControler mpc;
	private ViewManager vm;

	//Constructeur
	public PageMenuPersonnel(ViewManager vm) {
		this.vm = vm;
		mpc = new menuPersonnelControler(vm);
		page = new Formulaire();
		//Entete
		page.addTitle("Menu principal");
		//Contenu de la page
		page.addButton("mat","Afficher le matériel",mpc);
		page.addButton("reservation", "Afficher les réservations", mpc);
		//TODO Ajouter page materiel reservé
		page.addButton("profil", "Afficher mon profil", mpc);
		//TODO Ajouter page profil
		//Pied de page
		page.addButtonFoot("Déconnexion", "deconnexion", mpc);
	}
	
	public void close() {
		page.close();
	}
}