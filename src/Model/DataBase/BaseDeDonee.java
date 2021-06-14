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
	 * 
	 * @param mat nouveaux materiel que l'on souhaite ajouter
	 */
	public void addMateriel(Materiel mat) {
		materiels.add(mat);
	}

	/**
	 * ajout d'une nouvelle entrée dans la base de donnée des utilisateurs
	 * 
	 * @param usr nouvel utilisateur que l'on souhaite ajouter
	 */
	public void addUtilisateur(Utilisateur usr) {
		utilisateurs.add(usr);
	}

	public LinkedList<Materiel> getMateriels() {
		return materiels;
	}

	public LinkedList<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	/**
	 * permet d'avoir accès à la base unique
	 * 
	 * @return la base de données
	 */
	public final static BaseDeDonee getInstance() {
		return unique;
	}

	/**
	 * Retrouver l'index du materiel passé en paramettre
	 * 
	 * @param mat materiel auxquel on veux trouver l'index dans la BDD
	 * @return l'index dans la base ; -1 si il n'as pas était trouvé
	 */
	public int getIndexMateriel(Materiel mat) {
		int index = 0;
		for (Materiel m : materiels) {
			if (m == mat) {
				return index;
			}
			index++;
		}
		return -1;
	}

	/**
	 * Retrouve le matériel dont l'identifiant est passé en paramètre
	 * 
	 * @param idMat identifiant du matériel recherché
	 * @return le matériel recherché; null s'il n'est pas trouvé
	 */
	public Materiel getMateriel(int idMat) {
		for (Materiel m : materiels) {
			if (m.getID() == idMat) {
				return m;
			}
		}
		return null;
	}

	/**
	 * Retrouve le matériel dont l'index est passé en paramètre
	 * @param index index du matériel recherché
	 * @return le matériel recherché
	 */
	public Materiel getMaterielIndex(int index) {
		return materiels.get(index);
	}
	
	/**
	 * Retrouver l'index de l'utilisateur passé en paramettre
	 * 
	 * @param usr utilisateur auxquel on veux trouver l'index dans la BDD
	 * @return l'index dans la base ; -1 si il n'as pas était trouvé
	 */
	public int getIndexUtilisateur(Utilisateur usr) {
		int index = 0;
		for (Utilisateur u : utilisateurs) {
			if (u == usr) {
				return index;
			}
			index++;
		}
		return -1;
	}

	
	
	/**
	 * Retrouve l'utilisateur dont l'adresse mail est passée en paramètre
	 *
	 * @param mail adresse mail de l'utilisateur recherché
	 * @return l'utilisateur recherché; null s'il n'est pas trouvé
	 */
	public Utilisateur getUtilisateur(String mail) {
		for (Utilisateur u : utilisateurs) {
			if (u.getMail().equalsIgnoreCase(mail)) {
				return u;
			}
		}
		return null;
	}
	
	
	
	public Utilisateur getUtilisateurIndex(int index) {
		return utilisateurs.get(index);
	}
	
	
	/**
	 * suppression d'un materiel de la BDD
	 * 
	 * @param mat materiel à supprimer
	 * @return true si la suppression est réussie, false sinon
	 */
	public boolean removeMateriel(Materiel mat) {
		mat.supprimerAgenda(null);
		return materiels.remove(mat);
	}

	
	/**
	 * suppression d'un materiel de la BDD
	 * 
	 * @param index index du materiel à supprimer
	 * @return materiel qui a été supprimé
	 */
	public Boolean removeMateriel(int index) {
		Materiel mat = getMaterielIndex(index);
		return removeMateriel(mat);
	}

	
	/**
	 * suppression d'un utilisateur de la BDD
	 * 
	 * @param usr utilisateur à supprimer
	 * @return true si la suppression est réussie, false sinon
	 */
	public boolean removeUtilisateur(Utilisateur usr) {
		removeAgenda(usr);
		return utilisateurs.remove(usr);
	}
	
	
	/**
	 * suppression d'un utilisateur de la BDD
	 * 
	 * @param index index de l'utilisateur à supprimer
	 * @return utilisateur qui a été supprimé
	 */
	public Boolean removeUtilisateur(int index) {
		Utilisateur usr = getUtilisateurIndex(index);
		return removeUtilisateur(usr);
	}
	
	
	public void removeAgenda(Utilisateur usr) {
		for(Materiel mat : getMateriels()) {
			mat.supprimerAgenda(usr);
		}
	}

}
