package Model.DataBase;
/**
 * objet regroupant l'ensemble des données présentes dans l'application
 * <br> en utilisant le disign pattern du Singleton.
 */

import java.util.LinkedList;

import Model.Materiel.Materiel;
import Model.Utilisateur.Utilisateur;

public class BaseDeDonee {
	
	
	private static final BaseDeDonee unique = new BaseDeDonee();

	
	private LinkedList<Materiel> materiels;
	private LinkedList<Utilisateur> utilisateurs;
	
	
	private BaseDeDonee() {
		materiels = new LinkedList<>();
		utilisateurs = new LinkedList<>();
	}
	
	/**
	 * ajout d'une nouvelle entrée dans la base de donnée des matériels
	 * @param mat nouveaux materiel que l'on souhaite ajouter
	 */
	public void addMateriel(Materiel mat) {
		materiels.add(mat);
	}
	
	/**
	 * ajout d'une nouvelle entrée dans la base de donnée des utilisateurs
	 * @param usr nouvel utilisateur que l'on souhaite ajouter
	 */
	public void addUtilisateur(Utilisateur usr) {
		utilisateurs.add(usr);
	}	
	
	public LinkedList<Materiel> getMateriels(){
		return materiels;
	}
	
	public LinkedList<Utilisateur> getUtilisateurs(){
		return utilisateurs;
	}
	
	/**
	 * permet d'avoir accès à la base unique
	 * @return la base de données
	 */
	public final static BaseDeDonee getInstance() {
		return unique;
	}
	
	/**
	 * Retrouver l'index du materiel passé en paramettre
	 * @param mat materiel auxquel on veux trouver l'index dans la BDD
	 * @return l'index dans la base ; -1 si il n'as pas était trouvé
	 */
	public int getIndexMateriel(Materiel mat) {
		int index = 0;
		for(Materiel m : materiels) {
			if(m == mat) {
				return index;
			}
			index++;
		}
		return -1;
	}
	
	
	
	
	/**
	 * Retrouve le matériel dont l'identifiant est passé en paramètre
	 * @param idMat identifiant du matériel recherché
	 * @return le matériel recherché; null s'il n'est pas trouvé
	 */
	public Materiel getMateriel(int idMat) {
		for(Materiel m : materiels) {
			if(m.getID() == idMat) {
				return m;
			}
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Retrouver l'index de l'utilisateur passé en paramettre
	 * @param usr utilisateur auxquel on veux trouver l'index dans la BDD
	 * @return l'index dans la base ; -1 si il n'as pas était trouvé
	 */
	public int getIndexUtilisateur(Utilisateur usr) {
		int index = 0;
		for(Utilisateur u : utilisateurs) {
			if(u == usr) {
				return index;
			}
			index++;
		}
		return -1;
	}
	
	/**
	 * supression d'un materiel de la BDD
	 * @param mat materiel à supprimer
	 * @return true si la suppression et réussi, false sinon
	 */
	public boolean removeMateriel(Materiel mat) {
		return materiels.remove(mat);
	}
	
	/**
	 * suppression d'un utilisateur de la BDD
	 * @param usr utilisateur à supprimer
	 * @return true si la suppression et réussi, false sinon
	 */
	public boolean removeUtilisateur(Utilisateur usr) {
		return utilisateurs.remove(usr);
	}
	
	/**
	 * suppression d'un materiel de la BDD
	 * @param index index du materiel à supprimer
	 * @return materiel qui a était supprimer
	 */
	public Materiel removeMateriel(int index) {
		return materiels.remove(index);
	}
	
	/**
	 * suppression d'un utilisateur de la BDD
	 * @param index index de l'utilisateur à supprimer
	 * @return utilisateur qui a était supprimer
	 */
	public Utilisateur removeUtilisateur(int index) {
		return utilisateurs.remove(index);
	}
	
}
