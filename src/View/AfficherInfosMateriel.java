package View;

import Controller.MainClass;
import Controller.listeMaterielController;
import Model.DataBase.BaseDeDonee;
import Model.Materiel.Materiel;
import Model.Materiel.Ordinateur;
import Model.Materiel.Tablette;
import Model.Utilisateur.Administrateur;


public class AfficherInfosMateriel {
	// Attributs
	private Formulaire page;
	private ViewManager vm;
	private listeMaterielController lmc;

	// Constructeur
	public AfficherInfosMateriel(ViewManager vm, int idMat) {
		this.vm = vm;
		this.lmc = new listeMaterielController(vm);
		page = new Formulaire();

		Materiel mat = BaseDeDonee.getInstance().getMateriel(idMat);

		// Contenu commun
		page.addTextField("Identifiant : ", "id", ""+mat.getID(), null, true);
		page.addTextField("Marque : ", "marque", mat.getMarque(), null, true);
		page.addTextField("Etat : ", "etat", mat.getEtat(), null, true);
		page.addTextField("Salle : ", "salle", mat.getSalle(), null, true);

		// Pied de page
		page.addButtonFoot("Retour", "retour", lmc);
		if (MainClass.connecte instanceof Administrateur) {
			page.addButtonFoot("Modifier", "modifier", lmc);
			// TODO bouton modifier qui rend les textes et checkbox modifiables
			if (MainClass.connecte instanceof Administrateur) {
				page.addButton("modifier_" + mat.getID(), "Modifier", lmc, null);
				page.addButton("suppr_" + mat.getID(), "Supprimer", lmc, null);
			}
		}

		
		// Contenu propre au matériel
		// Entete
		if (mat instanceof Ordinateur) {
			page.addTitle("Ordinateur");
			// TODO modifier fonction ajoutCheckBox avec choix si coché ou non et si modifiable ou non.
			// fixe;
			// souris;
			page.addTextField("Capacite : ", "capacite", ""+((Ordinateur) mat).getCapacite(), null, true);

		} else if (mat instanceof Tablette) {
			page.addTitle("Tablette");
			// clavier
		} else {
			page.addTitle("Videoprojecteur");
			// telecommande
		}

		
		page.addMarge(30);
		//Afficher des réservations du matériel
		AfficherReservationsMateriel.AfficherReservations(page, mat.getID());
		page.addMarge(30);
	}
}
