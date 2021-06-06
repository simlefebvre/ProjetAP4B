package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import View.ViewManager;

public class listeMaterielController implements MouseListener {
	
	private ViewManager vm;
	
	public listeMaterielController(ViewManager vm) {
		this.vm = vm;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() instanceof JButton) {
			JButton but = (JButton) e.getSource();
			
			if(but.getName().equalsIgnoreCase("retour")) {
				this.vm.pAffMat.close();
				this.vm.showMenuProf();
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
