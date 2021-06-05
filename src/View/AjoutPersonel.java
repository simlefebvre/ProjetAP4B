package View;

import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AjoutPersonel extends Fenetre {
	
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
		
		CBadmin = new JCheckBox("Admin ? ");
		
		Pnom.setLayout(new BoxLayout(Pnom, BoxLayout.LINE_AXIS));
		Pprnm.setLayout(new BoxLayout(Pprnm, BoxLayout.LINE_AXIS));
		Pmdp.setLayout(new BoxLayout(Pmdp, BoxLayout.LINE_AXIS));
		Pmail.setLayout(new BoxLayout(Pmail, BoxLayout.LINE_AXIS));
		
		Pnom.add(Lnom);
		Pnom.add(Tnom);
		
		Pprnm.add(Lprnm);
		Pprnm.add(Tprnm);
		
		Pmail.add(Lmail);
		Pmail.add(Tmail);
		
		Pmdp.add(Lmail);
		Pmdp.add(Tmdp);
		
		Padmin.add(CBadmin);
		
		pan.setLayout(new BoxLayout(pan, BoxLayout.PAGE_AXIS));
		
		pan.add(Pnom);
		pan.add(Pprnm);
		pan.add(Pmdp);
		pan.add(Pmail);
		pan.add(Padmin);
		
		contenair.add(pan);
		fenetre.setContentPane(contenair);
		
		fenetre.revalidate();
	}
	
}
