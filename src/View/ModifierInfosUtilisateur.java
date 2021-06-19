package View;

import java.util.LinkedList;

import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controller.MainClass;
import Controller.ModifierInfosUtilisateurController;
import Model.Utilisateur.Administrateur;
import Model.Utilisateur.Utilisateur;

public class ModifierInfosUtilisateur {
	// Attributs
	private PopUp page;
	private ViewManager vm;
	private ModifierInfosUtilisateurController miuc;

	public ModifierInfosUtilisateur(ViewManager vm, Utilisateur util, String ouvertPar) {
		this.vm = vm;
		this.miuc = new ModifierInfosUtilisateurController(vm, util, ouvertPar);
		page = new PopUp();

		//Utilisateur util = BaseDeDonee.getInstance().getUtilisateur(mail);
		
		//Entete
		page.addTitle("Modifier profil");
		
		//Contenu
		page.addLabel("infoObligatoire", "Vous devez remplir ces cases pour appliquer la modification");
		page.addTextField("Nom : ","nom", util.getNom(), null, false);
		page.addTextField("Prenom : ","prenom", util.getPrenom(), null, false);
		
		//Modifier les droits d'administrateur de l'utilisateur
		//Uniquement si l'utilisateur connecté est administrateur
		if(MainClass.connecte instanceof Administrateur) {
			page.addCheckBox("Administrateur : ", "CheckAdmin", util instanceof Administrateur, false, null);
		}else {
			page.addCheckBox("Administrateur : ", "CheckAdmin", util instanceof Administrateur, true, null);
		}
		
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