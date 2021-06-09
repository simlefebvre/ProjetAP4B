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
 * Objet permettant la création automatisée de formulaires
 */
public class Formulaire extends Fenetre {
	//Attributs
	private JPanel page;
	private JPanel contenu;
	private JPanel piedPage;
	private JPanel enTete;
	private JPanel conteneur;

	private LinkedList<JTextField> textes;
	private LinkedList<JCheckBox> coches;
	private LinkedList<ButtonGroup> groupes;
	private LinkedList<JPasswordField> mdps;

	
	
	
	//Constructeur
	public Formulaire() {
		initialisation(true);
	}
	
	//Constructeur
	public Formulaire(boolean taillePage) {
		super(taillePage);
		initialisation(!taillePage);
	}
	
	//Constructeur
	public Formulaire(int x, int y) {
		super(x,y);
		initialisation(true);

	}
	
	
	
	
	
	private void initialisation(boolean PleinEcran) {
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

		if(PleinEcran) {
			fenetre.setLocationRelativeTo(null);
		}

		fenetre.validate();
	}
	
	
	
	
	//---------------Ajout de nouveaux éléments---------------
	
	/**
	 * ajout d'un titre
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
	 * Ajout d'une nouvelle zone de texte dans le corps du formulaire.
	 * <br>Possibilité d'ajouter la zone de texte à la suite d'une autre entrée 
	 * @param nomZone 		texte du label
	 * @param identifiant	identifiant de la zone de texte
	 * @param texteDefaut	texte inscrit par défaut dans la zone de texte
	 * @param pan			le panel auquel on veut ajouter la zone
	 * @param verrouille	zone verouillée ou non
	 * @return le panel dans lequel la zone se trouve
	 */
	public JPanel addTextField(String nomZone, String identifiant, String texteDefaut, JPanel pan, boolean verrouille) {
		JTextField entree = new JTextField();
		entree.setName(identifiant);
		entree.setText(texteDefaut);
		entree.setEnabled(!verrouille);
			
		entree.setMinimumSize(new Dimension(100, 20));
		
		
		JLabel label = new JLabel(nomZone);
		textes.add(entree);

		
		if(pan == null) {
			pan = new JPanel();
			pan.setLayout(new BoxLayout(pan, BoxLayout.LINE_AXIS));
		}
		pan.add(label);
		pan.add(entree);
		contenu.add(pan);
		contenu.add(new Marge());
		fenetre.revalidate();

		return pan;
	}
	
	/**
	 * ajout d'une nouvelle zone de texte dans le corps du formulaire
	 * @param nomZone nom de la zone à ajouter
	 * @param identifiant identifiant permettant de reconnaitre le composant dans la liste
	 * @return le panel contenant le label et l'entré
	 */
	public JPanel addTextField(String nomZone, String identifiant) {	
		return addTextField(nomZone, identifiant, "", null, false);
	}

	/**
	 * ajout d'une nouvelle zone de texte dans le corps du formulaire à la suite d'une autre entrée permettant de faire des lignes de zones de texte
	 * @param nomZone nom de la zone à ajouter
	 * @param identifiant identifiant permettant de reconnaitre le composant dans la liste
	 * @param pan le panel auxquel on veux ajouter
	 */
	public void addTextField(String nomZone, String identifiant, JPanel pan) {
		addTextField(nomZone, identifiant, "", pan, false);
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
	 * Ajout d'un label
	 * @param nom		Nom du bouton
	 * @param affiche	Texte à affiher sur le bouton
	 * @return	le panel dans lequel se trouve le bouton
	 */
	public JPanel addLabel(String nom, String texte) {
		JLabel lab = new JLabel();
		lab.setName(nom);
		lab.setText(texte);

		JPanel pan = new JPanel();
		pan.setLayout(new BoxLayout(pan, BoxLayout.LINE_AXIS));
		pan.add(lab);

		contenu.add(pan);
		contenu.add(new Marge());
		fenetre.revalidate();

		return pan;
	}

	
	
	
	
	/**
	 * ajout d'un boutton dans le pied de page du formulaire
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
	 * Ajout d'un bouton à un pannel sur le formulaire
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
	 * Ajout d'un bouton sur le formulaire
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




	
	/**
	 * Ajout d'un bouton à cocher dans le corps du formulaire
	 * @param nom			nom de la case à cocher
	 * @param id			identifiant de la case à cocher
	 * @param coche			case cochée par défaut ou non
	 * @param verrouille	case verrouillée ou non
	 * @param pan			le panel auquel on veut ajouter la case
	 * @return	le panel contenant le label dans lequel la case a été ajoutée
	 */
	public JPanel addCheckBox(String nom, String id, boolean coche, boolean verrouille, JPanel pan) {
		JCheckBox entree = new JCheckBox();
		entree.setName(id);
		entree.setSelected(coche);
		entree.setEnabled(! verrouille);
		JLabel label = new JLabel(nom);
		coches.add(entree);

		if (pan == null) {
			pan = new JPanel();
			pan.setLayout(new BoxLayout(pan, BoxLayout.LINE_AXIS));
		}
		
		pan.add(label);
		pan.add(entree);
		contenu.add(pan);
		contenu.add(new Marge());
		fenetre.revalidate();

		return pan;
	}
	
	/**
	 * ajout d'un bouton à cocher dans le corps du formulaire
	 * @param nom nom de la case à cocher
	 * @param id  identifiant permettant de reconnaitre le composant dans la liste
	 * @return le panel contenant le label dans lequel la case a été ajoutée
	 */
	public JPanel addCheckBox(String nom, String id) {
		return addCheckBox(nom, id, false, false, null);
	}

	/**
	 * ajout d'un bouton à cocher dans le corps du formulaire
	 * @param nom nom de la case à cocher
	 * @param id  identifiant permettant de reconnaitre le composant dans la liste
	 * @param pan le panel auquel on veut ajouter la case
	 */
	public void addCheckBox(String nom, String id, JPanel pan) {
		addCheckBox(nom, id, false, false, pan);
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
	 * Ajouter une marge
	 * @param taille	Taille de la marge
	 */
	public void addMarge(int taille) {
		Marge mar = new Marge(taille);
		
		JPanel pan = new JPanel();
		pan.setLayout(new BoxLayout(pan, BoxLayout.LINE_AXIS));
		
		pan.add(mar);
		contenu.add(pan);
		fenetre.revalidate();
	}
	
	
	
	
	
	
	
	
	//---------------Recupérer les listes des éléments---------------
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
	
	
		
	
	
	
	
	
	
	
	//---------------Autres méthodes---------------
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
	
	
	/**
	 * Mettre à jour la fenetre
	 */
	public void refresh() {
		fenetre.revalidate();
	}
	
}
