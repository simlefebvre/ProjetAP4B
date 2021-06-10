package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;

import javax.swing.JButton;

import Model.DataBase.BaseDeDonee;
import Model.Materiel.Materiel;
import View.ViewManager;

public class AffInfoMatController implements MouseListener {

	
	private ViewManager vm;
	public AffInfoMatController(ViewManager vm) {
		this.vm=vm;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		JButton but = (JButton) e.getSource();
		String name = but.getName();
		
		if(name.equals("retour")) {
			vm.pAffInfosMat.close();
		}else if(name.equals("Ajouter")) {
			vm.pAffInfosMat.close();
			LinkedList<Materiel> mat = new LinkedList<>();
			mat.add(vm.pAffInfosMat.getMat());
			vm.showReservation(mat);
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
