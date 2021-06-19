package View;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 * Fenetre utilis�e par toutes nos pages
 */
public class Fenetre extends JFrame {
	//Attribut
	protected JFrame fenetre;

	/**
	 * Constructeur par d�faut
	 */
	public Fenetre() {
		fenetre = new JFrame();

		fenetre.setTitle("Gestion du parc informatique");

		// Positionner au centre
		fenetre.setLocationRelativeTo(null);
		// D�finir taille minimale
		fenetre.setMinimumSize(new Dimension(500, 500));
		
		// Termine le processus lorsqu'on clique sur la croix rouge
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		fenetre.setVisible(true);
	}
	
	/**
	 * Constructeur permettant de cr�er une fenetre de taille voulue
	 * @param x Largeur de la fenetre en pixel
	 * @param y Hauteur de la fenetre en pixel
	 */
	public Fenetre(int x,int y) {
		fenetre = new JFrame();

		fenetre.setTitle("Gestion du parc informatique");

		// Positionner au centre
		fenetre.setLocationRelativeTo(null);
		// D�finir taille minimale
		fenetre.setMinimumSize(new Dimension(x, y));
		
		// Termine le processus lorsqu'on clique sur la croix rouge
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		fenetre.setVisible(true);
	}
	
	/**
	 * Constructeur permettant de cr�er une fenetre en plein �cran
	 * @param grandEcran bool�en permettant de choisir si la fenetre est cr��e ou non en plein �cran
	 */
	public Fenetre(boolean grandEcran) {
		fenetre = new JFrame();

		//fenetre.setTitle("Gestion du parc informatique");
		
		if(grandEcran==true) {
			fenetre.setExtendedState(MAXIMIZED_BOTH);
		}

		// Positionner au centre
		fenetre.setLocationRelativeTo(null);
		
		// D�finir taille minimale
		fenetre.setMinimumSize(new Dimension(500, 500));
		
		// Termine le processus lorsqu'on clique sur la croix rouge
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		fenetre.setVisible(true);
	}

	
	
	/**
	 * M�thode permettant de fermer la fenetre
	 */
	public void close() {
		fenetre.dispose();
	}
}
