package View;

import javax.swing.JPanel;

import Model.DataBase.BaseDeDonee;
import Model.Materiel.Materiel;

/**
 * Page qui affiche le contenu de la liste de matériels de la base de données
 */
public class AfficherMateriels{
	//Attribut
	Formulaire page;
	//Constructeur
	public AfficherMateriels(){
		page = new Formulaire();
		//Entete
		page.addTitle("Liste des matériels");

		//Contenu de la page
		JPanel instance;
		for(Materiel mat : BaseDeDonee.getInstance().getMateriels()) {
			//TODO creer une nouvelle ligne avec infos materiel
			//Puis ajouter boutons modifier, supprimer et réserver, en fonction de l'utilisateur
			
			instance = page.addTextField("Hello");
			page.addTextField("ici c'est pas trop petit ??", instance);
		}
		
		//Pied de page
		page.addButtonFoot("Retour", null);
	}
	
	
	public void close() {
		page.close();
	}
}
