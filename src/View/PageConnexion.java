package View;

import javax.swing.JFrame;

/**
 * Fenetre de connexion, sert de page d'accueil
 *
 */
public class PageConnexion extends JFrame {
	private JFrame fenetre;
	
	
	
	public PageConnexion() {
		fenetre = new JFrame();
		
	    fenetre.setTitle("Gestion du parc informatique");
	    fenetre.setSize(1920,1080);
	    //Positionner au centre
	    fenetre.setLocationRelativeTo(null);
	    //Termine le processus lorsqu'on clique sur la croix rouge
	    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
	    fenetre.setVisible(true);
	}
	
	
	
	public static void main(String arg[]) {
		new PageConnexion();
	}
}
