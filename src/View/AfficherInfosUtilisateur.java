package View;

import java.util.LinkedList;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

import Controller.AfficherInfosUtilisateurController;
import Controller.MainClass;
import Model.DataBase.BaseDeDonee;
import Model.Utilisateur.Administrateur;
import Model.Utilisateur.Utilisateur;

public class AfficherInfosUtilisateur {
	// Attributs
	private Formulaire page;
	private ViewManager vm;
	private AfficherInfosUtilisateurController aiuc;

	public AfficherInfosUtilisateur(ViewManager vm) {
		Utilisateur util = MainClass.connecte;
		this.vm = vm;
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
	
	public void close() {
		page.close();
	}
	
	public LinkedList<JTextField> getTF(){
		return page.getTextes();
	}
	
	public LinkedList<JCheckBox> getCB(){
		return page.getChoches();
	}
}
