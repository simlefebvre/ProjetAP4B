package View;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.MouseListener;
import java.util.LinkedList;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
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
	private LinkedList<ButtonGroup> groupes;
	private LinkedList<JPasswordField> mdps;

	// TODO faire du multi ligne
	public Formulaire() {

		page = new JPanel();
		contenu = new JPanel();
		piedPage = new JPanel();
		enTete = new JPanel();
		conteneur = new JPanel();

		textes = new LinkedList<>();
		coches = new LinkedList<>();
		groupes = new LinkedList<>();
		mdps = new LinkedList<>();

		conteneur.setLayout(new GridBagLayout());
		fenetre.setContentPane(conteneur);

		page.setLayout(new BoxLayout(page, BoxLayout.PAGE_AXIS));
		contenu.setLayout(new BoxLayout(contenu, BoxLayout.PAGE_AXIS));
		piedPage.setLayout(new BoxLayout(piedPage, BoxLayout.LINE_AXIS));
		enTete.setLayout(new BoxLayout(enTete, BoxLayout.LINE_AXIS));

		page.add(enTete);
		page.add(new Marge(10));
		page.add(contenu);
		page.add(new Marge(10));
		page.add(piedPage);

		conteneur.add(page);

		fenetre.setLocationRelativeTo(null);

		fenetre.validate();
	}

	/**
	 * ajout d'une nouvelle zonne de texte dans le corps du formulaire
	 * 
	 * @param nomZone nom de la zone à ajouter
	 * @param nom     identifiant permettant de reconnaitre le composant dans la
	 *                liste
	 * @return le panel contenant le label et l'entré
	 */
	public JPanel addTextField(String nomZone, String nom) {
		JTextField entre = new JTextField();
		entre.setName(nom);
		JLabel label = new JLabel(nomZone);
		textes.add(entre);

		entre.setMinimumSize(new Dimension(100, 20));

		JPanel pan = new JPanel();
		pan.setLayout(new BoxLayout(pan, BoxLayout.LINE_AXIS));
		pan.add(label);
		pan.add(entre);
		contenu.add(pan);
		contenu.add(new Marge());
		fenetre.revalidate();

		return pan;
	}

	/**
	 * ajout d'une nouvelle zonne de texte dans le corps du formulaire à la suite
	 * d'une autre entré <br>
	 * permettant de faire des lignes de formulaire
	 * 
	 * @param nomZone nom de la zone à ajouter
	 * @param nom     identifiant permettant de reconnaitre le composant dans la
	 *                liste
	 * @param pan     le panel auxquel on veux ajouter
	 */
	public void addTextField(String nomZone, String nom, JPanel pan) {
		JTextField entre = new JTextField();
		entre.setName(nom);
		JLabel label = new JLabel(nomZone);
		textes.add(entre);

		entre.setMinimumSize(new Dimension(100, 20));

		pan.add(label);
		pan.add(entre);
		contenu.add(pan);
		contenu.add(new Marge());
		fenetre.revalidate();
	}

	/**
	 * ajout d'un boutton dans le pied de page du formulaire
	 * 
	 * @param nom nom du boutton
	 * @param id  identifiant permettant de reconnaitre le composant dans la liste
	 * @param ml  listener du boutton
	 */
	public void addButtonFoot(String nom, String id, MouseListener ml) {
		JButton bout = new JButton(nom);
		bout.addMouseListener(ml);
		bout.setName(id);
		piedPage.add(bout);
		fenetre.revalidate();
	}

	/**
	 * ajout d'un titre
	 * 
	 * @param titre titre de la page
	 */
	public void addTitle(String titre) {
		Font font = new Font("Arial", Font.BOLD, 40);
		// Creation du JLabel
		JLabel Ltitre = new JLabel(titre);
		Ltitre.setFont(font);

		enTete.add(Ltitre);

		fenetre.revalidate();
	}

	/**
	 * ajout d'un bouton à cocher dans le corps du formulaire
	 * 
	 * @param nom nom de la case à cocher
	 * @param id  identifiant permettant de reconnaitre le composant dans la liste
	 * @return le panel contenant le label et l'entré
	 */
	public JPanel addCheckBox(String nom, String id) {
		JCheckBox entre = new JCheckBox();
		entre.setName(id);
		JLabel label = new JLabel(nom);
		coches.add(entre);

		JPanel pan = new JPanel();
		pan.add(label);
		pan.add(entre);
		contenu.add(pan);
		contenu.add(new Marge());
		fenetre.revalidate();

		return pan;
	}

	/**
	 * ajout d'un bouton à cocher dans le corps du formulaire
	 * 
	 * @param nom nom de la case à cocher
	 * @param id  identifiant permettant de reconnaitre le composant dans la liste
	 * @param pan e panel auxquel on veux ajouter
	 */
	public void addCheckBox(String nom, String id, JPanel pan) {
		JCheckBox entre = new JCheckBox();
		entre.setName(id);
		JLabel label = new JLabel(nom);
		coches.add(entre);

		pan.add(label);
		pan.add(entre);
		contenu.add(pan);
		contenu.add(new Marge());
		fenetre.revalidate();
	}

	/**
	 * @return la liste des TextField du formulaire
	 */
	public LinkedList<JTextField> getTextes() {
		return textes;
	}

	/**
	 * @return la liste des case à cocher du formulaire
	 */
	public LinkedList<JCheckBox> getChoches() {
		return coches;
	}

	/**
	 * 
	 * @return la liste des groupes de radioButton
	 */
	public LinkedList<ButtonGroup> getGroupes() {
		return groupes;
	}

	/**
	 * @return la liste des case à cocher du formulaire
	 */
	public LinkedList<JPasswordField> getmdp() {
		return mdps;
	}

	/**
	 * ajout d'un groupe de radioButton dans le corps de la page
	 * 
	 * @param nombre  nombre de boutton qu'il faut dans le groupe
	 * @param nom     nom de la question global
	 * @param boutton liste chainé contenant l'ensemble des noms des bouttons
	 */
	public void addRadioButtonGroup(int nombre, String nom, LinkedList<String> boutton) {
		JPanel Pgroupe = new JPanel();
		Pgroupe.setLayout(new BoxLayout(Pgroupe, BoxLayout.PAGE_AXIS));

		ButtonGroup groupes = new ButtonGroup();
		for (int i = 0; i < nombre; i++) {
			JRadioButton bouton = new JRadioButton(boutton.get(i));
			groupes.add(bouton);
			Pgroupe.add(bouton);
		}

		JLabel label = new JLabel(nom);

		JPanel pan = new JPanel();
		pan.setLayout(new BoxLayout(pan, BoxLayout.PAGE_AXIS));

		pan.add(label);
		pan.add(new Marge());
		pan.add(Pgroupe);

		JPanel Pglobal = new JPanel();
		Pglobal.setLayout(new GridBagLayout());

		Pglobal.add(pan);

		contenu.add(Pglobal);

	}

	/**
	 * ajout d'une section à mot de passe
	 * 
	 * @param nom nom de la section
	 * @param id  identifiant permettant de reconnaitre le composant dans la liste
	 */
	public void addPasswordField(String nom, String id) {
		JPasswordField entre = new JPasswordField();
		entre.setName(id);
		JLabel label = new JLabel(nom);
		mdps.add(entre);

		entre.setMinimumSize(new Dimension(100, 20));

		JPanel pan = new JPanel();
		pan.setLayout(new BoxLayout(pan, BoxLayout.LINE_AXIS));
		pan.add(label);
		pan.add(entre);
		contenu.add(pan);
		contenu.add(new Marge());
		fenetre.revalidate();
	}

	/**
	 * Ajout d'un simple label
	 * 
	 * @param s   texte du label
	 * @param pan panel auxquel l'ajouter
	 */
	public void addLabel(String s, JPanel pan) {
		JLabel lab = new JLabel(s);
		pan.add(lab);
	}

	/**
	 * ajout d'un bouton à un pannel sur le formulaire
	 * 
	 * @param nom      nom du bouton
	 * @param affiche  texte à afficher sur le boutton
	 * @param listener Mouse listener du boutton
	 * @param pan      Pannel auquel l'ajouter
	 */
	public void addButton(String nom, String affiche, MouseListener listener, JPanel pan) {
		JButton but = new JButton();
		but.setName(nom);
		but.setText(affiche);
		but.addMouseListener(listener);

		pan.add(but);

		contenu.add(pan);
		contenu.add(new Marge());
		fenetre.revalidate();
	}

	/**
	 * ajout d'un bouton sur le formulaire
	 * 
	 * @param nom      nom du bouton
	 * @param affiche  texte à afficher sur le boutton
	 * @param listener Mouse listener du boutton
	 */
	public JPanel addButton(String nom, String affiche, MouseListener listener) {
		JButton but = new JButton();
		but.setName(nom);
		but.setText(affiche);
		but.addMouseListener(listener);

		JPanel pan = new JPanel();
		pan.setLayout(new BoxLayout(pan, BoxLayout.LINE_AXIS));
		pan.add(but);

		contenu.add(pan);
		contenu.add(new Marge());
		fenetre.revalidate();

		return pan;
	}

	public JPanel addLabel(String nom, String affiche) {
		JLabel lab = new JLabel();
		lab.setName(nom);
		lab.setText(affiche);

		JPanel pan = new JPanel();
		pan.setLayout(new BoxLayout(pan, BoxLayout.LINE_AXIS));
		pan.add(lab);

		contenu.add(pan);
		contenu.add(new Marge());
		fenetre.revalidate();

		return pan;
	}

	/**
	 * efface tous les champs de texte du formulaire
	 */
	public void clearField() {
		for (JTextField tf : textes) {
			tf.setText("");
		}

		for (JPasswordField pf : mdps) {
			pf.setText("");
		}
	}
	
	
	
	public void addMarge(int taille) {
		Marge mar = new Marge(taille);
		
		JPanel pan = new JPanel();
		pan.setLayout(new BoxLayout(pan, BoxLayout.LINE_AXIS));
		
		pan.add(mar);
		contenu.add(pan);
		fenetre.revalidate();
	}
}
