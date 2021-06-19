package View;


/**
 * Classpermettant la cr�ation de PopUp
 */
public class PopUp extends Formulaire {
	
	//Constructeur
	/**
	 * Constructeur cr�ant une PopUp de taille par d�faut
	 */
	public PopUp() {
		super();
		fenetre.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	/**
	 * Constructeur cr�ant une PopUp de taille saise
	 * @param x	Largeur de la PopUp en pixel
	 * @param y	Hauteur de la PopUp en pixel
	 */
	public PopUp(int x, int y) {
		super(x,y);
		fenetre.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	

}
