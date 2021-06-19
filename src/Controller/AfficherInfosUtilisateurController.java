package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import Model.Utilisateur.Utilisateur;
import View.ViewManager;
/**
 * Controller permettant la gestion de la page d'information de l'utilisateur
 */
public class AfficherInfosUtilisateurController implements MouseListener{
	private ViewManager vm;
	private Utilisateur util;

	public AfficherInfosUtilisateurController(ViewManager vm, Utilisateur usr) {
		this.vm = vm;
		this.util = usr;
	}
	
	/**
	 * Evénement qui s'occupe des bouttons de modification de l'utilisateur et de retour
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() instanceof JButton) {
			JButton b = (JButton) e.getSource();
			if (b.getName().equalsIgnoreCase("modifier")) {
				this.vm.showModifierInfosUtilisateur(this.util, "profil");//affichage de la page de profil de l'utilisateur
			} else if (b.getName().equals("retour")) {//affichage du menu
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
