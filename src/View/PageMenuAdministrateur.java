package View;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Menu principal pour l'administrateur
 */

public class PageMenuAdministrateur extends PageMenuPersonnel{	
	public JPanel Putilisateurs = new JPanel();
	
	public PageMenuAdministrateur() {
		
		//Creation boutons
		JButton BmatIndispo = new JButton("Afficher le matériel indisponible");
		JButton Butilisateurs = new JButton("Afficher la liste des utilisateurs");
		
		materiel.add(BmatIndispo);
		
		Putilisateurs.setLayout(new BoxLayout(Putilisateurs, BoxLayout.LINE_AXIS));
		Putilisateurs.add(Butilisateurs);
		
		pan.add(new JPanel());
		pan.add(Putilisateurs);
	}
}
