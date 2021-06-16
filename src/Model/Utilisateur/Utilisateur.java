package Model.Utilisateur;

import Model.DataBase.BaseDeDonee;

/**
 * Un utilisateur est une personne qui utilise l'application
 * 
 */
public class Utilisateur {
	// Attributs
	private String prenom;
	private String nom;
	private String mail;
	private String motDePasse;

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
	public boolean connexion(String Identifiant, String MDP) {
		if (mail.equalsIgnoreCase(Identifiant) && motDePasse.equals(MDP)) {
			return true;
		}
		return false;
	}

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
		for(Utilisateur user : BaseDeDonee.getInstance().getUtilisateurs()) {
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
