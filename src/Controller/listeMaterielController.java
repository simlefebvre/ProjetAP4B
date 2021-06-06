package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import View.ViewManager;

public class listeMaterielController implements MouseListener {

	private ViewManager vm;

	public listeMaterielController(ViewManager vm) {
		this.vm = vm;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("test");
		if(e.getSource() instanceof JButton) {
			JButton but = (JButton) e.getSource();
			String name = but.getName();
			if(name.equalsIgnoreCase("retour")) {
				this.vm.pAffMat.close();
				this.vm.showMenuProf();
			}else if(name.contains("suppr")){
				char num[] = {'','',''};
				name.getChars(4, name.length(), num, 0);
				
				int index = Integer.parseInt(new String(num));
				
				int choix = JOptionPane.showOptionDialog(null, "Etes vous sur de vouloir supprimer le materiel n°"+ index + " ?" , "Supression" , JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE , null , null, null);
				
				if(choix == JOptionPane.YES_OPTION) {
					//TODO continuer ici
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
