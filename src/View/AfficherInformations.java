package View;

import Controller.listeMaterielController;
import Model.DataBase.BaseDeDonee;
import Model.Materiel.Materiel;
import Model.Materiel.Ordinateur;
import Model.Materiel.Tablette;

public class AfficherInformations {
	//Attributs
	private Formulaire page;
	private ViewManager vm;
	private listeMaterielController lmc;
	
	//Constructeur
	public AfficherInformations(ViewManager vm, int idMat) {
		this.vm = vm;
		this.lmc = new listeMaterielController(vm);
		page = new Formulaire();
		
		Materiel mat = BaseDeDonee.getInstance().getMateriel(idMat);
				
		//Contenu commun
		page.addLabel("id", "Identifiant : "+mat.getID());
		page.addLabel("marque", "Marque : "+mat.getMarque());
		page.addLabel("etat", "Etat : "+mat.getEtat());
		page.addLabel("salle", "Salle : "+mat.getSalle());
		
		//Pied de page
		page.addButtonFoot("Retour", "retour", null);
		
		//Contenu propre au matériel
		//Entete
		//TODO à changer en fonction classe materiel
		
		if(mat instanceof Ordinateur) {
			page.addTitle("Ordinateur");	
			//TODO modifier fonction ajoutCheckBox avec choix si coché ou non et si modifiable ou non. Pareil pour textField	
			//fixe;
			//souris;
			page.addLabel("capacite", "Capacite : "+((Ordinateur)mat).getCapacite());
			

		}else if(mat instanceof Tablette) {
			page.addTitle("Tablette");
			//clavier
		}else {
			page.addTitle("Videoprojecteur");
			//telecommande
		}
		
		//TODO ajout bouton modifier qui rend les textes et checkbox modifiables ==> que pour l'admin
		
	}
}
