package View;

import Controller.MainClass;
import Model.DataBase.BaseDeDonee;
import Model.Utilisateur.Administrateur;
import Model.Utilisateur.Utilisateur;

public class AfficherInfosUtilisateur {
	// Attributs
	private Formulaire page;
	private ViewManager vm;

	public AfficherInfosUtilisateur(ViewManager vm, String mail) {
		this.vm = vm;
		page = new Formulaire();

		Utilisateur util = BaseDeDonee.getInstance().getUtilisateur(mail);
		
		//Entete
		page.addTitle("Profil");
		
		//Contenu
		page.addTextField("Nom : ","nom", util.getNom(), null, true);
		page.addTextField("Prenom : ","prenom", util.getPrenom(), null, true);
		page.addTextField("Adresse Mail : ","mail", util.getMail(), null, true);
		page.addCheckBox("Administrateur : ", "CheckAdmin", true, true, null);
		page.addButton("mdp_" + mail, "Modifier le Mot De Passe", null);
		
		
		
		//TODO Ajouter champ modif mdp
		
		
		
		page.addMarge(30);
		//TODO Afficher les réservations
		new AfficherReservationsMateriel(page, util);
		page.addMarge(30);
		
		// Pied de page
		page.addButtonFoot("Retour", "retour", null);
		if (MainClass.connecte instanceof Administrateur) {
			page.addButtonFoot("Modifier", "modifier", null);
			// TODO bouton modifier qui rend les textes et checkbox modifiables mais ça va etre chiant pour les réservations si on change l'adresse mail de qqn
		}	
	}
}
