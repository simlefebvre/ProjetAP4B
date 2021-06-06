package View;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.MouseListener;
import java.util.LinkedList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * Objet permettant la création automatisé de formulaire
 */
public class Formulaire extends Fenetre {
	
	private JPanel page;
	private JPanel contenu;
	private JPanel piedPage;
	private JPanel enTete;
	private JPanel conteneur;
	
	private LinkedList<JTextField> textes;
	private LinkedList<JCheckBox> coches;
	//TODO faire du multi ligne
	public Formulaire() {
		
		page = new JPanel();
		contenu = new JPanel();
		piedPage = new JPanel();
		enTete = new JPanel();
		conteneur = new JPanel();
		
		textes = new LinkedList<>();
		coches = new LinkedList<>();
		
		conteneur.setLayout(new GridBagLayout());
		fenetre.setContentPane(conteneur);
		
		page.setLayout(new BoxLayout(page, BoxLayout.PAGE_AXIS));
		contenu.setLayout(new BoxLayout(contenu, BoxLayout.PAGE_AXIS));
		piedPage.setLayout(new BoxLayout(piedPage, BoxLayout.LINE_AXIS));
		enTete.setLayout(new BoxLayout(enTete, BoxLayout.LINE_AXIS));
	
		page.add(enTete);
		page.add(new Marge(10));
		page.add(contenu);
		page.add(piedPage);
		
		conteneur.add(page);
		
		fenetre.validate();
	}
	/**
	 * ajout d'une nouvelle zonne de texte dans le corps du formulaire
	 * @param nomZone nom de la zone à ajouter
	 */
	public void addTextField(String nomZone) {
		JTextField entre = new JTextField();
		JLabel label = new JLabel(nomZone);
		textes.add(entre);
		
		entre.setMinimumSize(new Dimension(100,20));
		
		JPanel pan = new JPanel();
		pan.setLayout(new BoxLayout(pan, BoxLayout.LINE_AXIS));
		pan.add(label);
		pan.add(entre);
		contenu.add(pan);
		contenu.add(new Marge());
		fenetre.revalidate();
	}
	/**
	 * ajout d'un boutton dans le pied de page du formulaire
	 * @param nom nom du boutton
	 * @param ml listener du boutton
	 */
	public void addButtonFoot(String nom, MouseListener ml) {
		JButton bout = new JButton(nom);
		bout.addMouseListener(ml);
		piedPage.add(bout);
		fenetre.revalidate();
	}
	/**
	 * ajout d'un titre
	 * @param titre titre de la page
	 */
	public void addTitle(String titre) {
		Font font = new Font("Arial",Font.BOLD,40);
	    //Creation du JLabel
	    JLabel Ltitre = new JLabel(titre);
	    Ltitre.setFont(font);
	    
	    enTete.add(Ltitre);
	    
	    fenetre.revalidate();
	}
	/**
	 * ajout d'un bouton à cocher dans le corps du formulaire
	 * @param nom nom de la case à cocher
	 */
	public void addCheckBox(String nom) {
		JCheckBox entre = new JCheckBox();
		JLabel label = new JLabel(nom);
		coches.add(entre);
		
		JPanel pan = new JPanel();
		pan.add(label);
		pan.add(entre);
		contenu.add(pan);
		contenu.add(new Marge());
		fenetre.revalidate();
	}
}
