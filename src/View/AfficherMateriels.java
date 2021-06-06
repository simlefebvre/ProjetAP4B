package View;

import Model.DataBase.BaseDeDonee;
import Model.Materiel.Materiel;

/**
 * Page qui affiche le contenu de la liste de matériels de la base de données
 */
public class AfficherMateriels{
	//Attribut
	
	//Constructeur
	public AfficherMateriels(){
		Formulaire page = new Formulaire();
		
		for(Materiel mat : BaseDeDonee.getInstance().getMateriels()) {
			//TODO creer une nouvelle ligne avec infos materiel
			//Puis ajouter boutons modifier, supprimer et réservé, en fonction de l'utilisateur
			//System.out.println(mat.getID()+" "+mat.getEtat());
			page.addTextField("Hello");
			page.addTextField("ici c'est pas trop petit ??");
		}
		
		page.addTitle("Ceci est un titre");
		
		//TODO Pied de page : Ajouter boutons ajouter + retour
	}
}
