package View;

import java.util.LinkedList;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

import Controller.AfficherInfosUtilisateurController;
import Controller.MainClass;
import Model.Utilisateur.Administrateur;
import Model.Utilisateur.Utilisateur;

/**
 * Classe permettant d'afficher les informations d'un utilisateur
 */
public class AfficherInfosUtilisateur {
	// Attributs
	private Formulaire page;
	private AfficherInfosUtilisateurController aiuc;

	
	
	//Constructeur
	public AfficherInfosUtilisateur(ViewManager vm) {
		Utilisateur util = MainClass.connecte;
		this.aiuc = new AfficherInfosUtilisateurController(vm, util);
		page = new Formulaire();

		//Entete
		page.addTitle("Profil");
		
		//Contenu
		page.addTextField("Nom : ","nom", util.getNom(), null, true);
		page.addTextField("Prenom : ","prenom", util.getPrenom(), null, true);
		page.addTextField("Adresse Mail : ","mail", util.getMail(), null, true);
		if(util instanceof Administrateur) {
			page.addCheckBox("Administrateur : ", "CheckAdmin", true, true, null);
		}else {
			page.addCheckBox("Administrateur : ", "CheckAdmin", false, true, null);
		}
			
		// Pied de page
		page.addButtonFoot("Retour", "retour", aiuc);
		page.addButtonFoot("Modifier", "modifier", aiuc);
	}
	
	
	
	/**
	 * M�thode permettant de r�cup�rer la liste des JTextField pr�sents sur la page
	 * @return la liste des JTextField
	 */
	public LinkedList<JTextField> getTF(){
		return page.getTextes();
	}
	
	/**
	 * M�thode permettant de r�cup�rer la liste des JCheckBox pr�sents sur la page
	 * @return la liste des JCheckBox
	 */
	public LinkedList<JCheckBox> getCB(){
		return page.getChoches();
	}
	
	
	
	/**
	 * M�thode permettant de fermer la page
	 */
	public void close() {
		page.close();
	}
}
