package Model.DataBase;

/**
 * objet regroupant l'ensemble des donn�es pr�sentes dans l'application
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
	 * ajout d'une nouvelle entr�e dans la base de donn�e des mat�riels
	 * 
	 * @param mat nouveaux materiel que l'on souhaite ajouter
	 */
	public void addMateriel(Materiel mat) {
		ConnexionSQL.newMateriel(mat);
		materiels.add(mat);
	}

	/**
	 * ajout d'une nouvelle entr�e dans la base de donn�e des utilisateurs
	 * 
	 * @param usr nouvel utilisateur que l'on souhaite ajouter
	 */
	public void addUtilisateur(Utilisateur usr) {
		utilisateurs.add(usr);
		//ConnexionSQL.newUtil(usr);
	}

	public LinkedList<Materiel> getMateriels() {
		return materiels;
		//TODO A Passer en sql
	}

	public LinkedList<Utilisateur> getUtilisateurs() {
		return utilisateurs;
		//TODO A Passer en sql
	}

	/**
	 * permet d'avoir acc�s � la base unique
	 * 
	 * @return la base de donn�es
	 */
	public final static BaseDeDonee getInstance() {
		return unique;
		//TODO A Passer en sql ???
	}

	/**
	 * Retrouver l'index du materiel pass� en paramettre
	 * 
	 * @param mat materiel auxquel on veux trouver l'index dans la BDD
	 * @return l'index dans la base ; -1 si il n'as pas �tait trouv�
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
		//TODO Est ce qu'on garde en sql ??
	}

	/**
	 * Retrouve le mat�riel dont l'identifiant est pass� en param�tre
	 * 
	 * @param idMat identifiant du mat�riel recherch�
	 * @return le mat�riel recherch�; null s'il n'est pas trouv�
	 */
	public Materiel getMateriel(int idMat) {
		for (Materiel m : materiels) {
			if (m.getID() == idMat) {
				return m;
			}
		}
		return null;
		//TODO A Passer en sql
	}

	/**
	 * Retrouve le mat�riel dont l'index est pass� en param�tre
	 * @param index index du mat�riel recherch�
	 * @return le mat�riel recherch�
	 */
	public Materiel getMaterielIndex(int index) {
		return materiels.get(index);
		//TODO Est ce qu'on la garde en sql ??
	}
	
	/**
	 * Retrouver l'index de l'utilisateur pass� en paramettre
	 * 
	 * @param usr utilisateur auxquel on veux trouver l'index dans la BDD
	 * @return l'index dans la base ; -1 si il n'as pas �tait trouv�
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
		//TODO Est ce qu'on garde en sql ?
	}

	
	
	/**
	 * Retrouve l'utilisateur dont l'adresse mail est pass�e en param�tre
	 *
	 * @param mail adresse mail de l'utilisateur recherch�
	 * @return l'utilisateur recherch�; null s'il n'est pas trouv�
	 */
	public Utilisateur getUtilisateur(String mail) {
		for (Utilisateur u : utilisateurs) {
			if (u.getMail().equalsIgnoreCase(mail)) {
				return u;
			}
		}
		return null;
		//TODO A Passer en sql
	}
	
	
	
	public Utilisateur getUtilisateurIndex(int index) {
		return utilisateurs.get(index);
		//TODO Est ce qu'on garde en sql ?
	}
	
	
	/**
	 * suppression d'un materiel de la BDD
	 * 
	 * @param mat materiel � supprimer
	 * @return true si la suppression est r�ussie, false sinon
	 */
	public void removeMateriel(Materiel mat) {
		mat.supprimerAgenda(null);//TODO A Passer en sql
		ConnexionSQL.delMateriel(mat.getID());
		
	}

	
	/**
	 * suppression d'un materiel de la BDD
	 * 
	 * @param index index du materiel � supprimer
	 * @return materiel qui a �t� supprim�
	 */
	public void removeMateriel(int index) {
		Materiel mat = getMaterielIndex(index);
		removeMateriel(mat);
		//TODO Est ce qu'on garde en sql ??
	}

	
	/**
	 * suppression d'un utilisateur de la BDD
	 * 
	 * @param usr utilisateur � supprimer
	 * @return true si la suppression est r�ussie, false sinon
	 */
	public void removeUtilisateur(Utilisateur usr) {
		removeAgenda(usr);//TODO A Passer en sql
		ConnexionSQL.delUtil(usr.getMail());
	}
	
	
	
	
	/**
	 * suppression d'un utilisateur de la BDD
	 * 
	 * @param index index de l'utilisateur � supprimer
	 * @return utilisateur qui a �t� supprim�
	 */
	public void removeUtilisateur(int index) {
		Utilisateur usr = getUtilisateurIndex(index);
		removeUtilisateur(usr);
		//TODO Est ce qu'on devrait pas suppr les m�thodes qui prennent l'index en parametre ??
	}
	
	
	public void removeAgenda(Utilisateur usr) {
		for(Materiel mat : getMateriels()) {
			mat.supprimerAgenda(usr);
		}
		//TODO A Passer en sql
	}

}
