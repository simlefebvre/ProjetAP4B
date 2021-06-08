package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Model.DataBase.BaseDeDonee;
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
			}else if(name.contains("suppr")){
				
				String num = name.substring(6);

				int identifiant = Integer.parseInt(num);
				
				int choix = JOptionPane.showOptionDialog(null, "Etes vous sur de vouloir supprimer le materiel n°"+ identifiant + " ?" , "Supression" , JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE , null , null, null);
				
				if(choix == JOptionPane.YES_OPTION) {
					BaseDeDonee.getInstance().removeMateriel(BaseDeDonee.getInstance().getMateriel(identifiant));
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
