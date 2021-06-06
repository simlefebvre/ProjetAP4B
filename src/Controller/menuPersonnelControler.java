package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import View.ViewManager;

public class menuPersonnelControler implements MouseListener {

	private ViewManager vm;
	public menuPersonnelControler(ViewManager vm) {
		this.vm = vm;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() instanceof JButton) {
			JButton b = (JButton) e.getSource();
			if(b.getName().equalsIgnoreCase("mat")) {
				vm.pMenu.close();
				vm.showMaterielDispo();
			}else if(b.getName().equals("reservation")) {
				vm.pMenu.close();
				vm.showAfficherReservation();
			}else if(b.getName().equalsIgnoreCase("profil")) {
				vm.pMenu.close();
				vm.showProfil();
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
