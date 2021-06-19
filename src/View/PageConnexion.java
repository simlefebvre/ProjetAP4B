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
		page.addButtonFoot("Mot de passe oubli�", "mdpoub", cc);
		page.addButtonFoot("Quitter", "quitter", cc);
	}

	
	
	// M�thodes set et get
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

	
	
	// Autres m�thodes
	/**
	 * M�thode permettant de fermer la page
	 */
	public void close() {
		page.close();
	}

	
	/**
	 * M�thode permettant de vider le contenu des champs de la page
	 */
	public void clearField() {
		page.clearField();
	}

}
