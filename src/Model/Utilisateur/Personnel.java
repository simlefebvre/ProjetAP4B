package Model.Utilisateur;

/**
 * Un personnel est un utilisateur aux droits limit�s
 *
 */
public class Personnel extends Utilisateur{

	public Personnel(String prenomSaisi, String nomSaisi, String mailSaisi, String motpasse) {
		super(prenomSaisi, nomSaisi, mailSaisi, motpasse);
	}

}
