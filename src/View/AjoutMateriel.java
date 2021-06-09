package View;

import Model.Materiel.Materiel;
import Model.Materiel.Ordinateur;
import Model.Materiel.Tablette;

/**
 * Page permettant l'ajout d'un mat�riel
 */
public class AjoutMateriel {
	private Formulaire page;

	// Constructeur
	public AjoutMateriel(Materiel mat) {
		page = new Formulaire();
		
		//Partie commune		
		//Contenu de la page
		page.addTextField("Saisir la marque ", "marque");
		page.addTextField("Saisir l'�tat ", "etat");
		page.addTextField("Saisir la salle ", "salle");
		
		// Pied de page
		page.addButtonFoot("Annuler", "annuler", null);
		page.addButtonFoot("Valider", "valider", null);
		
		
		
		//Partie propre	
		if (mat instanceof Ordinateur) {
			page.addTitle("Ajouter un ordinateur");
			page.addCheckBox("L'ordinateur est fixe ", "fixe", false, false, null);
			page.addCheckBox("L'ordinateur poss�de une souris", "souris", false, false, null);
			page.addTextField("Capacite : ", "capacite", "", null, false);
		} else if (mat instanceof Tablette) {
			page.addTitle("Ajouter une tablette");
			page.addCheckBox("La tablette poss�de un clavier", "clavier", false, false, null);
		} else {
			page.addTitle("Ajouter un videoprojecteur");
			page.addCheckBox("Le videoprojecteur poss�de une t�l�commande ", "telecommande", false, false, null);
		}
	}

	public void close() {
		page.close();
	}

}
