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
		page.addButton("mat","Afficher le mat�riel",mpc);
		page.addButton("reservation", "Afficher les r�servations", mpc);
		//TODO Ajouter page materiel reserv�
		page.addButton("profil", "Afficher mon profil", mpc);
		//TODO Ajouter page profil
		//Pied de page
		page.addButtonFoot("D�connexion", "deconnexion", mpc);
	}
	
	public void close() {
		page.close();
	}
}