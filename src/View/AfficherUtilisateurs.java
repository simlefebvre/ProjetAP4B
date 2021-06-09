package View;

import java.awt.Frame;

import javax.swing.JPanel;

import Model.DataBase.BaseDeDonee;
import Model.Utilisateur.Administrateur;
import Model.Utilisateur.Utilisateur;

public class AfficherUtilisateurs {
	//Attributs
	private Formulaire page;
	private ViewManager vm;
	
	//Constructeur
	public AfficherUtilisateurs(ViewManager newvm) {
		this.vm = newvm;
		page = new Formulaire();
		
		//TODO Ouvrir en grand
		//page.setExtendedState(Frame.MAXIMIZED_BOTH);
		
		// Entete
		page.addTitle("Liste des utilisateurs");

		// Contenu de la page
		JPanel instance;
		for (Utilisateur util : BaseDeDonee.getInstance().getUtilisateurs()) {
			
			instance = page.addLabel("infoUtil", "Nom : " + util.getNom()+"          Prenom : " + util.getPrenom() + "          Adresse mail : " + util.getMail());
			
			if (util instanceof Administrateur) {
				page.addCheckBox("          Administrateur", "admin_", true, true, instance);
			} else {
				page.addCheckBox("          Administrateur", "admin_", false, true, instance);
			}
			
			page.addButton("suppr_" + util.getMail(), "Supprimer", null, instance);
			//TODO Quand suppression, supprimer ses réservations
		}

		// Pied de page
		page.addButtonFoot("Retour", "retour", null);
		page.addButtonFoot("Ajouter", "ajouter", null);
	}
	
}
