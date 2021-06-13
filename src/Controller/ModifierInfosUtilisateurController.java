package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Model.Utilisateur.Utilisateur;
import View.ViewManager;

public class ModifierInfosUtilisateurController implements MouseListener{
	private ViewManager vm;

	public ModifierInfosUtilisateurController(ViewManager vm) {
		this.vm = vm;
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() instanceof JButton) {
			JButton b = (JButton) e.getSource();
			if (b.getName().equalsIgnoreCase("valider")) {
				//TODO Aymeric en est là !
				//TODO Passer identifiant utilisateur grâce au bouton
				
				
				//Créer un admin ou personnel en fonction de si la case admin est cochée ou non
				Utilisateur usr = new Utilisateur("","","","");
				
				
				//Controler la validité des champs
				for(JTextField tf : vm.pModifMat.getText()) {
					if(tf.getText().isEmpty()) {
						String tfname =tf.getName();
						//Vérifier que tout est rempli (sauf nouveau mot de passe)
						if(!(tfname.equalsIgnoreCase("mdpNouveau") || tfname.equalsIgnoreCase("mdpConfirmer"))) {						
							JOptionPane.showMessageDialog(null, "Il faut remplir tous les champs", "Erreur champs mal remplis", JOptionPane.ERROR_MESSAGE);
							return;
						}
						
						//Verifier que le mot de passe saisi est correct
						if(tfname.equals("mdpAncien")) {
							if(usr.controleMDP(tfname)) {
								JOptionPane.showMessageDialog(null, "Mauvais mot de passe", "Erreur mot de passe", JOptionPane.ERROR_MESSAGE);
								return;
							}
						}
					}
				}
				
				//Ajouter les valeurs des champs à l'utilisateur
				
				for(JTextField tf : vm.pModifMat.getText()) {
					String tfname =tf.getName();
					if(tfname.equalsIgnoreCase("NomChamp")) {
						//Ajouter champ
					}
					
					
					
					//controler que nouveau mdp ok, si vide then ne pas changer
					
					
				}
				
				
				
			} else if (b.getName().equals("retour")) {
				this.vm.pModifInfoUtil.close();
				this.vm.showProfil();
			} 
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
}
