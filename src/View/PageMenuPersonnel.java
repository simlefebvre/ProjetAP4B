package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Menu principal pour le personnel
 */

//TODO A refaire
public class PageMenuPersonnel extends Fenetre{	
	protected JPanel pan = new JPanel();
	protected JPanel materiel = new JPanel();
	protected JPanel reserve = new JPanel();
	protected JPanel profil = new JPanel();
	protected JPanel menu = new JPanel();
	protected JPanel grosseMarge = new JPanel();
	
	
	public PageMenuPersonnel() {
		//Modification fenetre
		fenetre.setExtendedState(NORMAL);
		fenetre.setLocationRelativeTo(null);
		
		
		//Creation du conteneur
		JPanel conteneur = new JPanel();
		conteneur.setLayout(new GridBagLayout());
		
		
		//Creation des boutons
		//TODO ca serait bien de donner la même taille au boutons si on y arrive
	    JButton BmatDispo = new JButton("Afficher le matériel disponible");
	    JButton Bres = new JButton("Afficher le matériel réservé");
	    JButton Bpro = new JButton("Afficher mon profil");
	    //TODO Ajouter page profil
	    
	    
	    //Creation police
	    Font font = new Font("Arial",Font.BOLD,40);
	    //Creation du JLabel
	    JLabel titre = new JLabel("Menu principal");
	    titre.setFont(font);
	    JLabel txtMarge = new JLabel(" ");
	    txtMarge.setFont(font);
	    
	    //Initialisation des JPanels
	    materiel.setLayout(new BoxLayout(materiel, BoxLayout.LINE_AXIS));
	    materiel.add(BmatDispo);
	    reserve.setLayout(new BoxLayout(reserve, BoxLayout.LINE_AXIS));
	    reserve.add(Bres);
	    profil.setLayout(new BoxLayout(profil, BoxLayout.LINE_AXIS));
	    profil.add(Bpro);
	    menu.setLayout(new BoxLayout(menu, BoxLayout.LINE_AXIS));
	    menu.add(titre);
	    pan.setLayout(new BoxLayout(pan, BoxLayout.PAGE_AXIS));
		pan.setSize(100,100);
		grosseMarge.setLayout(new BoxLayout(grosseMarge, BoxLayout.LINE_AXIS));
		grosseMarge.add(txtMarge);
		
		//Ajout d'elements au JPanel pan
		pan.add(menu);
		pan.add(grosseMarge);
		pan.add(materiel);
		//Ajout d'un espace
		pan.add(new JPanel());
		pan.add(reserve);
		//Ajout d'un espace
		pan.add(new JPanel());
		pan.add(profil);
		
		//Ajout du JPanel pan au conteneur
		conteneur.add(pan);
		
		//TODO Changer la couleur de fond
		
		//Ajout du conteneur a la fenetre
		fenetre.setContentPane(conteneur);
		//Mise a jour de la fenetre
		fenetre.validate();  
	}
}
