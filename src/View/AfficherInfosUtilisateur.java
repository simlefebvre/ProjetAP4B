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
		//TODO Mettre les valeurs dans les champs des TextField
		page.addTextField("Nom : " + util.getNom(),"nom");
		page.addTextField("Prenom : " + util.getPrenom(),"nom");
		page.addTextField("Adresse Mail : " + util.getMail(),"nom");
		page.addCheckBox("Administrateur : ", "CheckAdmin");
		page.addButton("mdp_" + mail, "Modifier le Mot De Passe", null);
		
		//TODO Ajouter champ modif mdp
		
		//TODO Afficher les réservations
		// Pied de page
		page.addButtonFoot("Retour", "retour", null);
		if (MainClass.connecte instanceof Administrateur) {
			page.addButtonFoot("Modifier", "modifier", null);
			// TODO ajout bouton modifier qui rend les textes et checkbox modifiables
		}	
	}
}
