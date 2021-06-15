package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import View.ViewManager;

public class menuPersonnelControler implements MouseListener {

	private ViewManager vm;

	public menuPersonnelControler(ViewManager vm) {
		this.vm = vm;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() instanceof JButton) {
			JButton b = (JButton) e.getSource();
			if (b.getName().equalsIgnoreCase("mat")) {
				vm.pMenu.close();
				vm.showMaterielDispo();
			} else if (b.getName().equals("reservation")) {
				vm.pMenu.close();
				vm.showAfficherReservation();
			} else if (b.getName().equalsIgnoreCase("profil")) {
				vm.pMenu.close();
				vm.showProfil();
			}else if(b.getName().equalsIgnoreCase("utilisateurs")) {
				vm.pMenu.close();
				vm.showAfficherUtilisateurs();
			} else if (b.getName().equalsIgnoreCase("deconnexion")) {
				MainClass.connecte = null;
				vm.pMenu.close();
				vm.showConnexion();
			} else if (b.getName().equalsIgnoreCase("quitter")) {
				int choix =JOptionPane.showOptionDialog(null, "Etes-vous sûr de vouloir quitter ?", "Quitter",JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
				if(choix == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

}
