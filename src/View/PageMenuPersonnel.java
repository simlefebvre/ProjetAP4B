package View;

import java.awt.Color;

import javax.swing.JPanel;

/**
 * Menu principal pour le personnel
 */

public class PageMenuPersonnel extends Fenetre{
	private JPanel pan;
	
	public PageMenuPersonnel() {
		pan = new JPanel();
		//D�finition de sa couleur de fond
	    pan.setBackground(Color.ORANGE); 
	    
	    //On pr�vient notre JFrame que notre JPanel sera son content pane
	    fenetre.setContentPane(pan);
	}
}
