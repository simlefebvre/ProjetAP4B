package View;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 * Fenetre utilisée par toutes nos pages
 *
 */

public class Fenetre extends JFrame{
	protected JFrame fenetre;
	
	public Fenetre() {
		fenetre = new JFrame();
		
	    fenetre.setTitle("Gestion du parc informatique");
	    
	    //Ouvrir en taille maximale
	    fenetre.setExtendedState(MAXIMIZED_BOTH);
	    //Positionner au centre
	    fenetre.setLocationRelativeTo(null);
	    //Définir taille minimale
	    fenetre.setMinimumSize(new Dimension(500, 500));
	    
	    //Termine le processus lorsqu'on clique sur la croix rouge
	    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    fenetre.setVisible(true);
	}
}
