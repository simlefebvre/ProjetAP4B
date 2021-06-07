package View;

import Controller.MainClass;
import Controller.listeMaterielController;
import Model.DataBase.BaseDeDonee;
import Model.Materiel.Materiel;
import Model.Materiel.Ordinateur;
import Model.Materiel.Tablette;
import Model.Utilisateur.Administrateur;

public class AfficherInformations {
	// Attributs
	private Formulaire page;
	private ViewManager vm;
	private listeMaterielController lmc;

	// Constructeur
	public AfficherInformations(ViewManager vm, int idMat) {
		this.vm = vm;
		this.lmc = new listeMaterielController(vm);
		page = new Formulaire();

		Materiel mat = BaseDeDonee.getInstance().getMateriel(idMat);

		// Contenu commun
		page.addTextField("Identifiant : " + mat.getID(), "id");
		page.addTextField("Marque : " + mat.getMarque(), "marque");
		page.addTextField("Etat : " + mat.getEtat(), "etat");
		page.addTextField("Salle : " + mat.getSalle(), "salle");

		// Pied de page
		page.addButtonFoot("Retour", "retour", null);
		if (MainClass.connecte instanceof Administrateur) {
			page.addButtonFoot("Modifier", "modifier", null);
			// TODO ajout bouton modifier qui rend les textes et checkbox modifiables
		}

		// Contenu propre au matériel
		// Entete
		// TODO à changer en fonction classe materiel
		if (mat instanceof Ordinateur) {
			page.addTitle("Ordinateur");
			// TODO modifier fonction ajoutCheckBox avec choix si coché ou non et si modifiable ou non. Pareil pour textField
			// fixe;
			// souris;
			page.addTextField("Capacite : " + ((Ordinateur) mat).getCapacite(), "capacite");

		} else if (mat instanceof Tablette) {
			page.addTitle("Tablette");
			// clavier
		} else {
			page.addTitle("Videoprojecteur");
			// telecommande
		}

		// TODO Afficher réservations du matériel

		
		
		
	}
}
