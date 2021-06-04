package View;

import javax.swing.JFrame;

/**
 * Fenetre utilisée par toutes nos pages
 *
 */

public class Fenetre extends JFrame{
	private JFrame fenetre;
		
	public Fenetre() {
		fenetre = new JFrame();
		
	    fenetre.setTitle("Gestion du parc informatique");
	    
	    //Positionner au centre
	    fenetre.setLocationRelativeTo(null);
	    //Termine le processus lorsqu'on clique sur la croix rouge
	    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
	    
	    //Ouvrir en taille maximale
	    fenetre.setExtendedState(MAXIMIZED_BOTH);
	    
	    fenetre.setVisible(true);
	}
}
