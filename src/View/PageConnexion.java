package View;

import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Controller.connexionController;

/**
 * Fenetre de connexion, sert de page d'accueil
 *
 */

public class PageConnexion  {
	//Attributs
	private Formulaire page;	
	private ViewManager vm;
	private connexionController cc;
	
	//Constructeur
	public PageConnexion(ViewManager vm) {
		page = new Formulaire();
		cc = new connexionController(vm);
		
		page.addTextField("Identifiant / e-mail : ");
		page.addPasswordField("mot de passe : ");
		page.addTitle("Connexion");
		page.addButtonFoot("Connexion", cc);
		page.addButtonFoot("Mot de passe oublié", cc);
	}
	
	//Méthodes set et get
	public String getIdentifiant() {
		return Tid.getText();
	}


	public String getMdp() {
		return new String(Tmdp.getPassword());
	}
	
	
	//Autres méthodes
	public void close() {
		page.close();
	}
	

	public void clearField() {
		Tid.setText("");
		Tmdp.setText("");
	}
	
}
