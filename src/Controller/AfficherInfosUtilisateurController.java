package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import Model.Utilisateur.Utilisateur;
import View.ViewManager;

public class AfficherInfosUtilisateurController implements MouseListener{
	private ViewManager vm;
	private Utilisateur util;

	public AfficherInfosUtilisateurController(ViewManager vm, Utilisateur usr) {
		this.vm = vm;
		this.util = usr;
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() instanceof JButton) {
			JButton b = (JButton) e.getSource();
			if (b.getName().equalsIgnoreCase("modifier")) {
				this.vm.showModifierInfosUtilisateur(this.util);
			} else if (b.getName().equals("retour")) {
				this.vm.pProfil.close();
				this.vm.showMenuProf();
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
