package Utilisateur;

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
		if(mail==Identifiant && motDePasse==MDP) {
			return true;
		}
		return false;
	}
}
