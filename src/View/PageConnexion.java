package View;

import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Controller.connexionController;

/**
 * Fenetre de connexion, sert de page d'accueil
 *
 */

public class PageConnexion extends Fenetre {
	
	JPanel pan = new JPanel();
	JPanel Pid = new JPanel();
	JPanel Pmdp = new JPanel();
	JPanel Pbt = new JPanel();
	
	JLabel Lid = new JLabel("Identifiant : ");
	JLabel Lmdp = new JLabel("Mot de passe : ");
	JTextField Tid;
	JPasswordField Tmdp = new JPasswordField();
	JButton Bcon = new JButton("Connexion");
	JButton BmdpOublier = new JButton("Mot de Passe Oublié");
	
	private ViewManager vm;
	
	public PageConnexion(ViewManager vm) {
		
		Tid = new JTextField();
		
		this.vm = vm;
		
		fenetre.setExtendedState(NORMAL);
		fenetre.setLocationRelativeTo(null);
		
		JPanel contenair = new JPanel();
		contenair.setLayout(new GridBagLayout());
		
		connexionController cc = new connexionController(vm);

		Bcon.addMouseListener(cc);
		BmdpOublier.addMouseListener(cc);
		
		Tid.setMaximumSize(new Dimension(100, 20));
		Tmdp.setMaximumSize(new Dimension(100, 20));
		Pid.setLayout(new BoxLayout(Pid, BoxLayout.LINE_AXIS));
		Pid.add(Lid);
		Pid.add(Tid);

		Pmdp.setLayout(new BoxLayout(Pmdp, BoxLayout.LINE_AXIS));
		Pmdp.add(Lmdp);
		Pmdp.add(Tmdp);
		
		Pbt.setLayout(new BoxLayout(Pbt, BoxLayout.LINE_AXIS));
		Pbt.add(Bcon);
		Pbt.add(BmdpOublier);
		
		
		pan.setLayout(new BoxLayout(pan, BoxLayout.PAGE_AXIS));
		pan.setSize(100,100);

		JPanel marge = new JPanel();
		
		pan.add(Pid);
		pan.add(marge);
		pan.add(Pmdp);
		pan.add(marge);
		pan.add(Pbt);
		
		contenair.add(pan);
		fenetre.setContentPane(contenair);
		fenetre.validate();
	}
	
	
	public String getIdentifiant() {
		return Tid.getText();
	}


	public String getMdp() {
		return new String(Tmdp.getPassword());
	}
	public void close() {
		fenetre.dispose();
	}


	public void clearField() {
		Tid.setText("");
		Tmdp.setText("");
	}
	
}
