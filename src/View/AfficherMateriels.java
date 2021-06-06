package View;

import javax.swing.JPanel;

import Controller.MainClass;
import Controller.listeMaterielController;
import Model.DataBase.BaseDeDonee;
import Model.Materiel.Materiel;
import Model.Materiel.Ordinateur;
import Model.Materiel.Tablette;
import Model.Utilisateur.Administrateur;

/**
 * Page qui affiche le contenu de la liste de matériels de la base de données
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
		
		
		//TODO Ouvrir en plein écran
		
		
		//Entete
		page.addTitle("Liste des matériels");

		//Contenu de la page
		JPanel instance;
		for(Materiel mat : BaseDeDonee.getInstance().getMateriels()) {		
			if(mat instanceof Ordinateur) {
				instance = page.addLabel("infosMat", "Ordinateur            id : "+mat.getID()+"          Etat : " + mat.getEtat() +"          Salle : " + mat.getSalle() +"          ");
			}else if(mat instanceof Tablette) {
				instance = page.addLabel("infosMat", "Tablette               id : "+mat.getID()+"          Etat : " + mat.getEtat() +"          Salle : " + mat.getSalle() +"          ");
			}else {
				instance = page.addLabel("infosMat", "Videoprojecteur       id : "+mat.getID()+"          Etat : " + mat.getEtat() +"          Salle : " + mat.getSalle() +"          ");
			}
			
			
			page.addButton("reserver", "Reserver", lmc, instance);
			page.addButton("infos", "Plus d'informations", lmc, instance);
			
			if(MainClass.connecte instanceof Administrateur) {
				page.addButton("modifier", "Modifier", lmc, instance);
				page.addButton("supprimer", "Supprimer", lmc, instance);
			}
			
			//TODO faire bouton +d'infos sur chaque matériel avec l'agenda...
		}
		
		//Pied de page
		page.addButtonFoot("Retour", "retour", lmc);
	}
	
	
	public void close() {
		page.close();
	}
}
