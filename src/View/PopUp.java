package View;


/**
 * Classpermettant la création de PopUp
 */
public class PopUp extends Formulaire {
	
	//Constructeur
	/**
	 * Constructeur créant une PopUp de taille par défaut
	 */
	public PopUp() {
		super();
		fenetre.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	/**
	 * Constructeur créant une PopUp de taille saise
	 * @param x	Largeur de la PopUp en pixel
	 * @param y	Hauteur de la PopUp en pixel
	 */
	public PopUp(int x, int y) {
		super(x,y);
		fenetre.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	

}
