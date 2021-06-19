package View;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Classe permettant de rajouter un JPanel servant de marge
 */
public class Marge extends JPanel {
	/**
	 * Créer une marge avec une taille par défaut
	 */
	public Marge() {
	}

	/**
	 * Créer une marge de taille choisie
	 * @param TaillePolice taille de la marge
	 */
	public Marge(int TaillePolice) {
		Font font = new Font("Arial", Font.BOLD, TaillePolice);
		JLabel txtMarge = new JLabel(" ");
		txtMarge.setFont(font);
		add(txtMarge);
	}

}