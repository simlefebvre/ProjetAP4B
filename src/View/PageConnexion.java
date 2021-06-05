package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * Fenetre de connexion, sert de page d'accueil
 *
 */

public class PageConnexion extends Fenetre {
	
	public PageConnexion() {
		
		fenetre.setExtendedState(NORMAL);
		fenetre.setLocationRelativeTo(null);
		
		JPanel contenair = new JPanel();
		contenair.setLayout(new GridBagLayout());
		
		
		JPanel pan = new JPanel();
		JPanel Pid = new JPanel();
		JPanel Pmdp = new JPanel();
		JPanel Pbt = new JPanel();

		//fenetre.getContentPane().add(pan,BorderLayout.CENTER);
		//fenetre.setContentPane(pan);
		
		/*GridLayout gl = new GridLayout();
		gl.setColumns(2);
		gl.setColumns(3);
		gl.setHgap(5);
		gl.setVgap(5);
		*/	
		
		//pan.setLayout(new GridLayout(3, 2, 10, 10));
		//pan.setLayout(new BoxLayout(pan, BoxLayout.LINE_AXIS));
		//pan.setBackground(Color.GREEN);
		//setLayout(gl);
		
		JLabel Lid = new JLabel("Identifiant : ");
		JLabel Lmdp = new JLabel("Mot de passe : ");
		JTextArea Tid = new JTextArea();
		JTextArea Tmdp = new JTextArea();
		JButton Bcon = new JButton("Connexion");
		JButton BmdpOublier = new JButton("Mot de Passe Oublié");
		
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
		

		//marge.setMinimumSize(new Dimension(1000, 1000));
		//fenetre.add(marge,BorderLayout.NORTH);
		//fenetre.add(marge,BorderLayout.SOUTH);
		contenair.add(pan);
		fenetre.setContentPane(contenair);
		fenetre.validate();
	}
	
	
}
