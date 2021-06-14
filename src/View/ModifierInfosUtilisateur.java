package View;

import java.util.LinkedList;

import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controller.ModifierInfosUtilisateurController;
import Model.DataBase.BaseDeDonee;
import Model.Utilisateur.Administrateur;
import Model.Utilisateur.Utilisateur;

public class ModifierInfosUtilisateur {
	// Attributs
	private PopUp page;
	private ViewManager vm;
	private ModifierInfosUtilisateurController miuc;

	public ModifierInfosUtilisateur(ViewManager vm, Utilisateur util) {
		this.vm = vm;
		this.miuc = new ModifierInfosUtilisateurController(vm, util);
		page = new PopUp();

		//Utilisateur util = BaseDeDonee.getInstance().getUtilisateur(mail);
		
		//Entete
		page.addTitle("Modifier profil");
		
		//Contenu
		page.addLabel("infoObligatoire", "Vous devez remplir ces cases pour appliquer la modification");
		page.addTextField("Nom : ","nom", util.getNom(), null, false);
		page.addTextField("Prenom : ","prenom", util.getPrenom(), null, false);
		page.addTextField("Adresse Mail : ","mail", util.getMail(), null, false);
		/*
		if(util instanceof Administrateur) {
			page.addCheckBox("Administrateur : ", "CheckAdmin", true, false, null);
		}else {
			page.addCheckBox("Administrateur : ", "CheckAdmin", false, true, null);
		}
		*/
		page.addPasswordField("Saisir ancien mot de passe : ", "mdpAncien");
		page.addMarge(5);
		page.addLabel("infoMDP", "Facultatif :");
		page.addPasswordField("Saisir nouveau mot de passe : ", "mdpNouveau");
		page.addPasswordField("Confirmer nouveau mot de passe : ", "mdpConfirmer");
				
		// Pied de page
		page.addButtonFoot("Retour", "retour", miuc);
		page.addButtonFoot("Valider", "valider", miuc);
	}
	
	public void close() {
		page.close();
	}
	
	public LinkedList<JTextField> getText(){
		return page.getTextes();
	}
	
	public LinkedList<JCheckBox> getCB(){
		return page.getChoches();
	}
	
	public LinkedList<JPasswordField> getmdp(){
		return page.getmdp();
	}
	
}