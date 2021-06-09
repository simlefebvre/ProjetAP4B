package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

import Model.Utilisateur.Administrateur;
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
				//Passer identifiant utilisateur grâce au bouton
				//Controler que ancien mdp bien saisie
				//controler que nouveau mdp ok, si vide then ne pas changer
				
				//Vérifier que tout est rempli et sauvegarder

				
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
