package Controller;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Model.Agenda.Reservation;
import Model.DataBase.BaseDeDonee;
import View.ViewManager;

public class AffReservationController implements MouseListener {

	private ViewManager vm;
	public AffReservationController(ViewManager vm){
		this.vm = vm;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		JButton but = (JButton) e.getSource();
		String name = but.getName();
		if(but.getName().equalsIgnoreCase("retour")) {
			vm.pAffReserv.close();
			vm.showMenuProf();
		}else if(but.getName().equalsIgnoreCase("ajouter")) {
			vm.pAffReserv.close();
			vm.showMaterielDispo();
		}else if(but.getName().contains("suppr")) {
			String num = name.substring(39);
			String identifiantDate = name.substring(6, 38);
			
			int identifiant = Integer.parseInt(num);
			int choix = JOptionPane.showOptionDialog(null, "Etes vous sur de vouloir supprimer la reservation n°"+ identifiant + " ?" , "Supression" , JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE , null , null, null);
			
			if(choix == JOptionPane.YES_OPTION) {
				BaseDeDonee.getInstance().getMateriel(identifiant).getAgenda().supprimerReservation(new Reservation(identifiantDate));
				this.vm.pAffMat.refresh();
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
