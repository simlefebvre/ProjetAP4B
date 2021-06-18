package View;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Controller.AfficherUtilisateursController;
import Model.DataBase.BaseDeDonee;
import Model.DataBase.ConnexionSQL;
import Model.Utilisateur.Administrateur;
import Model.Utilisateur.Utilisateur;

public class AfficherUtilisateurs {
	//Attributs
	private Formulaire page;
	private ViewManager vm;
	private AfficherUtilisateursController auc;
	
	//Constructeur
	public AfficherUtilisateurs(ViewManager newvm) {
		this.vm = newvm;
		auc = new AfficherUtilisateursController(newvm);
		page = new Formulaire(true);
		
		// Entete
		page.addTitle("Liste des utilisateurs");

		// Contenu de la page
		JPanel instance;
		for (Utilisateur util : ConnexionSQL.getUtilisateurs()) {
			
			instance = page.addLabel("infoUtil", "Nom : " + util.getNom()+"          Prenom : " + util.getPrenom() + "          Adresse mail : " + util.getMail());
			
			if (util instanceof Administrateur) {
				page.addCheckBox("          Administrateur", "admin_", true, true, instance);
			} else {
				page.addCheckBox("          Administrateur", "admin_", false, true, instance);
			}
			
			page.addButton("modif_" + util.getMail(), "Modifier", auc, instance);
			page.addButton("suppr_" + util.getMail(), "Supprimer", auc, instance);
		}

		// Pied de page
		page.addButtonFoot("Retour", "retour", auc);
		page.addButtonFoot("Ajouter", "ajouter", auc);
	}
	
	public void close() {
		page.close();
	}
	
	public void refresh() {
		page.close();
		vm.showAfficherUtilisateurs();
		
	}
}
