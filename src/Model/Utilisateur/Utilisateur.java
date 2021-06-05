package Model.Utilisateur;

/**
 * Un utilisateur est une personne qui utilise l'application
 * 
 */
public class Utilisateur {
	//Attributs
	private String prenom;
	private String nom;
	private String mail;
	private String motDePasse;
	
	//Constructeur
	public Utilisateur(String prenomSaisi, String nomSaisi, String mailSaisi, String motpasse){
		prenom=prenomSaisi;
		nom=nomSaisi;
		mail=mailSaisi;
		motDePasse=motpasse;
	}
	
	//Méthodes de récupération et de modification des attributs
	public String getPrenom() {
		return prenom;
	}
	
	public String getNom() {
		return nom;
	}
	
	public String getMail() {
		return mail;
	}
	
	public void setMail(String adresseMail) {
		mail=adresseMail;
	}
	
	public void setMDP(String MDP) {
		motDePasse=MDP;
	}
	
	
	//Autres méthodes
	public boolean connexion(String Identifiant, String MDP) {
		if(mail.equalsIgnoreCase(Identifiant) && motDePasse.equalsIgnoreCase(MDP)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean equals(Object o) {
		if(o instanceof Utilisateur) {
			Utilisateur b = (Utilisateur) o;
			if(b.getPrenom() == getPrenom() && b.getNom() == getNom() && b.getMail() == getMail()) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
}
