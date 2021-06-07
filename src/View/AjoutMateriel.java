package View;

import Model.Materiel.Materiel;
import Model.Materiel.Ordinateur;
import Model.Materiel.Tablette;

/**
 * Page permettant l'ajout d'un matériel
 */
public class AjoutMateriel {
	private Formulaire page;

	// Constructeur
	public AjoutMateriel(Materiel mat) {
		page = new Formulaire();
		
		//Partie commune
		// Entete
		page.addTitle("Ajouter un matériel");
		
		//Contenu de la page
		page.addTextField("Saisir l'identifiant ", "id");
		page.addTextField("Saisir la marque ", "marque");
		page.addTextField("Saisir l'état ", "etat");
		page.addTextField("Saisir la salle ", "salle");
		
		// Pied de page
		page.addButtonFoot("Annuler", "annuler", null);
		page.addButtonFoot("Valider", "valider", null);
		
		
		
		//Partie propre	
		if (mat instanceof Ordinateur) {
			page.addTitle("Ordinateur");
			// TODO modifier fonction ajoutCheckBox avec choix si coché ou non et si modifiable ou non. Pareil pour textField
			page.addCheckBox("L'ordinateur est fixe ", "fixe");
			page.addCheckBox("L'ordinateur possède une souris", "souris");
			page.addTextField("Capacite : " + ((Ordinateur) mat).getCapacite(), "capacite");
		} else if (mat instanceof Tablette) {
			page.addTitle("Tablette");
			page.addCheckBox("La tablette possède un clavier", "clavier");
		} else {
			page.addTitle("Videoprojecteur");
			page.addCheckBox("Le videoprojecteur possède une télécommande ", "telecommande");
		}
	}

	public void close() {
		page.close();
	}

}
