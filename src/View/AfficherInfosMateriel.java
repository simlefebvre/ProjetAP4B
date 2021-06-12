package View;

import Controller.AffInfoMatController;
import Controller.MainClass;
import Model.DataBase.BaseDeDonee;
import Model.Materiel.Materiel;
import Model.Materiel.Ordinateur;
import Model.Materiel.Tablette;
import Model.Materiel.VideoProjecteur;
import Model.Utilisateur.Administrateur;


public class AfficherInfosMateriel {
	// Attributs
	private PopUp page;
	private ViewManager vm;
	private AffInfoMatController lmc;
	private Materiel mat;
	

	// Constructeur
	public AfficherInfosMateriel(ViewManager vm, int idMat) {
		this.vm = vm;
		this.lmc = new AffInfoMatController(vm);
		page = new PopUp(500,700);

		mat = BaseDeDonee.getInstance().getMateriel(idMat);

		// Contenu commun
		page.addTextField("Identifiant : ", "id", ""+mat.getID(), null, true);
		page.addTextField("Marque : ", "marque", mat.getMarque(), null, true);
		page.addTextField("Etat : ", "etat", mat.getEtat(), null, true);
		page.addTextField("Salle : ", "salle", mat.getSalle(), null, true);

		// Pied de page
		page.addButtonFoot("Retour", "retour", lmc);
		if (MainClass.connecte instanceof Administrateur) {
			page.addButtonFoot("Modifier", "Modifier", lmc);
			// TODO bouton modifier qui rend les textes et checkbox modifiables
			page.addButtonFoot("Supprimer","Supprimer",  lmc);
		}

		
		// Contenu propre au matériel
		// Entete
		if (mat instanceof Ordinateur) {
			page.addTitle("Ordinateur");
			page.addCheckBox("L'ordinateur est fixe ", "fixe", ((Ordinateur) mat).getFixe(), true, null);
			page.addCheckBox("L'ordinateur possède une souris", "souris", ((Ordinateur) mat).getSouris(), true, null);
			page.addTextField("Capacite : ", "capacite", "", null, true);

		} else if (mat instanceof Tablette) {
			page.addTitle("Tablette");
			page.addCheckBox("La tablette possède un clavier", "clavier", ((Tablette) mat).getClavier(), true, null);
		} else {
			page.addTitle("Videoprojecteur");
			page.addCheckBox("Le videoprojecteur possède une télécommande ", "telecommande", ((VideoProjecteur) mat).getTelecommande(), true, null);
		}

		
		page.addMarge(30);
		//Affichage des réservations du matériel
		new AfficherReservationsMateriel(page, idMat,vm);
		page.addMarge(30);
	}

	public void close() {
		page.close();
	}
	
	public Materiel getMat() {
		return mat;
	}
}
