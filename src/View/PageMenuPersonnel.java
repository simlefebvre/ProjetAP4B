package View;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Menu principal pour le personnel
 */

public class PageMenuPersonnel extends Fenetre{
	//private JPanel pan;
	//private JButton bouton;
	
	public PageMenuPersonnel() {
		//JPanel pan = new JPanel();
	    Box b1 = Box.createHorizontalBox();
	    JButton bouton = new JButton("Afficher le matériel disponible");
	    /*pan*/b1.add(bouton);
	    
	    Box b2 = Box.createHorizontalBox();
	    JButton bouton2 = new JButton("Afficher le matériel réservé");
	    /*pan*/b2.add(bouton2);
	    
	    
	    Box b3 = Box.createVerticalBox();
	    b3.add(b1);
	    b3.add(b2);
	    
	    
	    //On prévient notre JFrame que notre JPanel sera son content pane
	    fenetre.getContentPane(/*pan*/).add(b3,BorderLayout.EAST);
	    //fenetre.getContentPane();
	    
	    //TODO A faire finir par Simon!    
	}
}
