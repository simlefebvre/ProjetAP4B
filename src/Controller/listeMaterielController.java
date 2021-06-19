package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JCheckBox;

import Model.DataBase.ConnexionSQL;
import Model.Materiel.Materiel;
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
			String name = but.getName();
			if(name.equalsIgnoreCase("retour")) {
				this.vm.pAffMat.close();
				this.vm.showMenuProf();
			}else if(name.contains("reserver")) {
				boolean coche = false;
				LinkedList<Materiel> mats = new LinkedList<>();
				for(JCheckBox cb : this.vm.pAffMat.getBox()) {
					if(cb.isSelected()) {
						coche = true;
						String num = cb.getName().substring(6);
						int identifiant = Integer.parseInt(num);
						mats.add(ConnexionSQL.getMateriel(identifiant));
					}
				}
				if(coche)
					this.vm.showReservation(mats);
				
			}else if(name.contains("info")) {
				String num = name.substring(5);				
				int identifiant = Integer.parseInt(num);
				vm.showInfoMat(identifiant);
			}else if(name.equalsIgnoreCase("ajout")) {
				vm.showAjoutMateriel();
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
