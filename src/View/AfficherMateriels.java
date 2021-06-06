package View;

import javax.swing.JPanel;

import Controller.listeMaterielController;
import Model.DataBase.BaseDeDonee;
import Model.Materiel.Materiel;

/**
 * Page qui affiche le contenu de la liste de mat�riels de la base de donn�es
 */
public class AfficherMateriels{
	//Attribut
	private Formulaire page;
	private ViewManager vm;
	private listeMaterielController lmc;
	//Constructeur
	public AfficherMateriels(ViewManager vm){
		this.vm = vm;
		this.lmc = new listeMaterielController(vm);
		page = new Formulaire();
		
		//Entete
		page.addTitle("Liste des mat�riels");

		//Contenu de la page
		JPanel instance;
		for(Materiel mat : BaseDeDonee.getInstance().getMateriels()) {
			//TODO creer une nouvelle ligne avec infos materiel
			//Puis ajouter boutons modifier, supprimer et r�server, en fonction de l'utilisateur
			

			instance = page.addLabel("infosMat", "Ordinateur          id : "+mat.getID()+"          Etat : " + mat.getEtat() +"          Salle : " + mat.getSalle() +"          ");
			page.addButton("reserver", "Reserver", lmc, instance);
			
			/*que pour admin !!!
			 * instanceof
			page.addButton("modifier", "Modifier", lmc, instance);
			page.addButton("supprimer", "Supprimer", lmc, instance);
			*/
			//int id, String marque, String etat, String salle
			
			//TODO faire bouton +d'infos sur chaque mat�riel avec l'agenda...
		}
		
		//Pied de page
		page.addButtonFoot("Retour", "retour", null);
	}
	
	
	public void close() {
		page.close();
	}
}
