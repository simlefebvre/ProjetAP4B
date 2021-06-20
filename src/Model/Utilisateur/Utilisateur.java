package Model.Utilisateur;

import Model.DataBase.ConnexionSQL;

/**
 * Un utilisateur est une personne qui utilise l'application
 */
public class Utilisateur {
	// Attributs
	protected String prenom;
	protected String nom;
	protected String mail;
	protected String motDePasse;

	// Constructeur
	public Utilisateur(String prenomSaisi, String nomSaisi, String mailSaisi, String motpasse) {
		prenom = prenomSaisi;
		nom = nomSaisi;
		mail = mailSaisi;
		motDePasse = motpasse;
	}

	// Méthodes de récupération et de modification des attributs
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getMail() {
		return mail;
	}

	public void setMail(String adresseMail) {
		mail = adresseMail;
	}

	public void setMDP(String MDP) {
		motDePasse = MDP;
	}
	
	public String getMDP() {
		return motDePasse;
	}

	// Autres méthodes
	/**
	 * Méthode controlant si l'identifiant et le mot de passe saisis correspondent à ceux d'un utilisateur dans la base de données
	 * @param Identifiant	l'identifiant saisi
	 * @param MDP			le mot de passe saisi
	 * @return				true si la combinaison Identifiant et MDP est valide, false sinon
	 */
	public boolean connexion(String Identifiant, String MDP) {
		if (mail.equalsIgnoreCase(Identifiant) && motDePasse.equals(MDP)) {
			return true;
		}
		return false;
	}

	
	/**
	 * Méthode permettant de comparer deux utilisateurs
	 * @return true s'ils sont égaux, false sinon
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof Utilisateur) {
			Utilisateur b = (Utilisateur) o;
			if (b.getPrenom() == getPrenom() && b.getNom() == getNom() && b.getMail() == getMail()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	/**
	 * Vérifie si l'addresse mail saisie est présente dans la base de données ou non
	 * @param addresse l'addresse mail à contrôler
	 * @return	true si l'adresse mail
	 */
	public static boolean uniciteMail(String addresse) {
		for(Utilisateur user : ConnexionSQL.getUtilisateurs()) {
			if(addresse.equalsIgnoreCase(user.getMail())) {
				return false;
			}
		}
		return true;
	}
	
	
	/**
	 * Controle si le mot de passe saisi correspond au mot de passe de l'utilisateur ou non
	 * @param mdp le mot de passe à tester
	 * @return true si le mot de passe est correct, false sinon
	 */
	public boolean controleMDP (String mdp) {
		if(this.motDePasse.equals(mdp)) {
			return true;
		}
		return false;
	}
}
