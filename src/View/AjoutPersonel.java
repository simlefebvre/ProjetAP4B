package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AjoutPersonel extends Fenetre {
	
	//TODO à transformer en template
	
	private JPanel pan;
	private JPanel contenair;
	
	private JTextField Tnom;
	private JTextField Tprnm;
	private JTextField Tmail;
	private JTextField Tmdp;
	
	private JCheckBox CBadmin;
	
	private JLabel Lnom;
	private JLabel Lprnm;
	private JLabel Lmail;
	private JLabel Lmdp;
	
	private JPanel Pnom;
	private JPanel Pprnm;
	private JPanel Pmail;
	private JPanel Pmdp;
	private JPanel Padmin;
	
	private JButton Badd;
	
	public AjoutPersonel() {
		contenair = new JPanel();
		contenair.setLayout(new GridBagLayout());
		
		pan = new JPanel();
		
		Pnom = new JPanel();
		Pprnm = new JPanel();		
		Pmdp = new JPanel();
		Pmail = new JPanel();
		Padmin = new JPanel();
		
		Lnom = new JLabel("nom : ");
		Lprnm = new JLabel("prénom : ");
		Lmdp = new JLabel("mot de passe : ");
		Lmail = new JLabel("mail : ");
		
		Tnom = new JTextField();
		Tprnm = new JTextField();
		Tmdp = new JTextField();
		Tmail = new JTextField();
		
		Tnom.setMinimumSize(new Dimension(10000,10));
		
		CBadmin = new JCheckBox("Admin ? ");
		
		Pnom.setLayout(new BoxLayout(Pnom, BoxLayout.LINE_AXIS));
		Pprnm.setLayout(new BoxLayout(Pprnm, BoxLayout.LINE_AXIS));
		Pmdp.setLayout(new BoxLayout(Pmdp, BoxLayout.LINE_AXIS));
		Pmail.setLayout(new BoxLayout(Pmail, BoxLayout.LINE_AXIS));
		
		/*Pnom.setSize(10000,Pnom.getHeight());
		Pmdp.setSize(10000,Pnom.getHeight());
		Pprnm.setSize(10000,Pnom.getHeight());
		Pmail.setSize(10000,Pnom.getHeight());
		*/
		Pnom.add(Lnom);
		Pnom.add(Tnom);
		
		Pprnm.add(Lprnm);
		Pprnm.add(Tprnm);
		
		Pmail.add(Lmail);
		Pmail.add(Tmail);
		
		Pmdp.add(Lmdp);
		Pmdp.add(Tmdp);
		
		Padmin.add(CBadmin);
		
		Font font = new Font("Arial",Font.BOLD,40);
	    //Creation du JLabel
	    JLabel titre = new JLabel("Ajout d'un utilisateur");
	    titre.setFont(font);
	    JLabel txtMarge = new JLabel(" ");
	    txtMarge.setFont(font);
	    JPanel menu = new JPanel();
	    menu.setLayout(new BoxLayout(menu, BoxLayout.LINE_AXIS));
	    menu.add(titre);
		
		pan.setLayout(new BoxLayout(pan, BoxLayout.PAGE_AXIS));
		pan.setSize(100, 100);
		
		pan.add(menu);
		pan.add(new Marge(40));
		pan.add(Pnom);
		pan.add(new Marge());
		pan.add(Pprnm);
		pan.add(new Marge());
		pan.add(Pmdp);
		pan.add(new Marge());
		pan.add(Pmail);
		pan.add(new Marge());
		pan.add(Padmin);
		
		contenair.add(pan);
		fenetre.setContentPane(contenair);
		
		fenetre.validate();
	}
	
}
