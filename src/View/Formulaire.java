package View;

import java.awt.GridBagLayout;
import java.awt.event.MouseListener;
import java.util.LinkedList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Formulaire extends Fenetre {
	
	private JPanel page;
	private JPanel contenu;
	private JPanel piedPage;
	private JPanel enTete;
	private JPanel conteneur;
	
	private LinkedList<JTextField> textes;
	
	public Formulaire() {
		
		page = new JPanel();
		contenu = new JPanel();
		piedPage = new JPanel();
		enTete = new JPanel();
		conteneur = new JPanel();
		
		textes = new LinkedList<>();
		
		conteneur.setLayout(new GridBagLayout());
		fenetre.setContentPane(conteneur);
		
		page.setLayout(new BoxLayout(page, BoxLayout.PAGE_AXIS));
		contenu.setLayout(new BoxLayout(contenu, BoxLayout.PAGE_AXIS));
		piedPage.setLayout(new BoxLayout(piedPage, BoxLayout.LINE_AXIS));
		enTete.setLayout(new BoxLayout(enTete, BoxLayout.LINE_AXIS));
	
		page.add(enTete);
		page.add(contenu);
		page.add(piedPage);
		
		conteneur.add(page);
		
		fenetre.validate();
	}
	
	public void addTextField(String nomZone) {
		JTextField entre = new JTextField();
		JLabel label = new JLabel(nomZone);
		textes.add(entre);
		
		JPanel pan = new JPanel();
		pan.add(label);
		pan.add(entre);
		contenu.add(pan);
		contenu.add(new Marge());
		fenetre.revalidate();
	}
	
	public void addButtonFoot(String nom, MouseListener ml) {
		JButton bout = new JButton(nom);
		bout.addMouseListener(ml);
		piedPage.add(bout);
	}
	

}
