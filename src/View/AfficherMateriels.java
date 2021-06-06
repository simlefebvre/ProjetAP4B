package View;

import javax.swing.JPanel;

import Model.DataBase.BaseDeDonee;
import Model.Materiel.Materiel;

/**
 * Page qui affiche le contenu de la liste de mat�riels de la base de donn�es
 */
public class AfficherMateriels{
	//Attribut
	private Formulaire page;
	private ViewManager vm;
	//Constructeur
	public AfficherMateriels(ViewManager vm){
		this.vm = vm;
		page = new Formulaire();
		
		//Entete
		page.addTitle("Liste des mat�riels");

		//Contenu de la page
		JPanel instance;
		for(Materiel mat : BaseDeDonee.getInstance().getMateriels()) {
			//TODO creer une nouvelle ligne avec infos materiel
			//Puis ajouter boutons modifier, supprimer et r�server, en fonction de l'utilisateur
			
			instance = page.addTextField("id : "+mat.getID(), "nom");
			page.addButton("reserver", "Reserver", null, instance);
			page.addButton("modifier", "Modifier", null, instance);
			page.addButton("supprimer", "Supprimer", null, instance);
		}
		
		//Pied de page
		page.addButtonFoot("Retour", "retour", null);
	}
	
	
	public void close() {
		page.close();
	}
}
