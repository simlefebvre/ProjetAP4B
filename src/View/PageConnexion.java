package View;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controller.connexionController;

/**
 * Fenetre de connexion, sert de page d'accueil
 */
public class PageConnexion {
	// Attributs
	private Formulaire page;
	private connexionController cc;

	// Constructeur
	public PageConnexion(ViewManager vm) {
		page = new Formulaire(false);
		cc = new connexionController(vm);

		page.addTextField("Identifiant / e-mail : ", "id");
		page.addPasswordField("mot de passe : ", "mdp");
		page.addTitle("Connexion");
		page.addButtonFoot("Connexion", "con", cc);
		page.addButtonFoot("Mot de passe oublié", "mdpoub", cc);
		page.addButtonFoot("Quitter", "quitter", cc);
	}

	
	
	// Méthodes set et get
	public String getIdentifiant() {
		for (JTextField tf : page.getTextes()) {
			if (tf.getName().equalsIgnoreCase("id")) {
				return tf.getText();
			}
		}
		return null;
	}

	public String getMdp() {
		for (JPasswordField tf : page.getmdp()) {
			if (tf.getName().equalsIgnoreCase("mdp")) {
				return new String(tf.getPassword());
			}
		}
		return null;
	}

	
	
	// Autres méthodes
	/**
	 * Méthode permettant de fermer la page
	 */
	public void close() {
		page.close();
	}

	
	/**
	 * Méthode permettant de vider le contenu des champs de la page
	 */
	public void clearField() {
		page.clearField();
	}

}
