package View;

import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AjoutPersonel extends Fenetre {
	
	private JPanel pan;
	private JPanel contenair;
	
	private JTextField Tnom;
	private JTextField Tprenom;
	private JTextField Tmail;
	private JTextField Tmdp;
	
	private JLabel Lnom;
	private JLabel Lprenom;
	private JLabel Lmail;
	private JLabel Lmdp;
	
	private JPanel Pnom;
	private JPanel Pprnm;
	private JPanel Pmail;
	private JPanel Pmdp;
	
	public AjoutPersonel() {
		contenair = new JPanel();
		contenair.setLayout(new GridBagLayout());
		
		
		
		contenair.add(pan);
		fenetre.setContentPane(contenair);
	}
	
}
