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

	
	
	//Constructeur
	/**
	 * Constructeur de la classe ModifierInfosUtilisateur
	 * @param vm		le ViewManager
	 * @param util		l'utilisateur dont les informations sont affich�es
	 * @param ouvertPar	indique la page ayant appel� ce constructeur
	 */
	public ModifierInfosUtilisateur(ViewManager vm, Utilisateur util, String ouvertPar) {
		this.vm = vm;
		this.miuc = new ModifierInfosUtilisateurController(vm, util, ouvertPar);
		page = new PopUp();

		//Entete
		page.addTitle("Modifier profil");
		
		//Contenu
		page.addLabel("infoObligatoire", "Vous devez remplir ces cases pour appliquer la modification");
		page.addTextField("Nom : ","nom", util.getNom(), null, false);
		page.addTextField("Prenom : ","prenom", util.getPrenom(), null, false);
		
		//Modifier les droits d'administrateur de l'utilisateur
		//Uniquement si l'utilisateur connect� est administrateur
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
	
	
	
	/**
	 * M�thode permettant de r�cup�rer la liste des JTextField pr�sents sur la page
	 * @return la liste des JTextField pr�sents sur la page
	 */
	public LinkedList<JTextField> getText(){
		return page.getTextes();
	}
	
	/**
	 * M�thode permettant de r�cup�rer la liste des JCheckBox pr�sents sur la page
	 * @return la liste des JCheckBox pr�sents sur la page
	 */
	public LinkedList<JCheckBox> getCB(){
		return page.getChoches();
	}
	
	/**
	 * M�thode permettant de r�cup�rer la liste des JPasswordField pr�sents sur la page
	 * @return la liste des JPasswordField pr�sents sur la page
	 */
	public LinkedList<JPasswordField> getmdp(){
		return page.getmdp();
	}
	
	
	
	/**
	 * M�thode permettant de fermer la page
	 */
	public void close() {
		page.close();
	}
}