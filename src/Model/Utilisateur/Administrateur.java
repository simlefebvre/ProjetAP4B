package Model.Utilisateur;

/**
 * Un administrateur est un utilisateur ayant tous les droits
 *
 */
public class Administrateur extends Utilisateur{

	public Administrateur(String prenomSaisi, String nomSaisi, String mailSaisi, String motpasse) {
		super(prenomSaisi, nomSaisi, mailSaisi, motpasse);
	}
	
}
