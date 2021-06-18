package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Model.Agenda.Reservation;
import Model.DataBase.BaseDeDonee;
import Model.DataBase.ConnexionSQL;
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
		}else if(name.equalsIgnoreCase("Modifier")) {
			this.vm.showModifMat(vm.pAffInfosMat.getMat());
			
		}else if(name.equalsIgnoreCase("Supprimer")) {
			int choix =JOptionPane.showOptionDialog(null, "Etes-vous sûr de vouloir supprimer ce composant ?", "Suppression d'un composant",JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
			if(choix == JOptionPane.YES_OPTION) {
				ConnexionSQL.delMateriel(vm.pAffInfosMat.getMat().getID());
				vm.pAffInfosMat.close();
				//Maj AfficherMateriels
				vm.pAffMat.close();
				vm.showMaterielDispo();
			}
		}else if(name.contains("suppr_")) {
			String num = name.substring(39);
			String identifiantDate = name.substring(6, 38);
			
			int identifiant = Integer.parseInt(num);
			int choix =JOptionPane.showOptionDialog(null, "Etes-vous sûr de vouloir supprimer cette réservation ?", "Suppression d'une réservation",JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
			
			if(choix == JOptionPane.YES_OPTION) {
				//BaseDeDonee.getInstance().getMateriel(identifiant).getAgenda().supprimerReservation(new Reservation(identifiantDate));
				ConnexionSQL.delReservation(identifiantDate);
				//MAJ page info mat
				vm.pAffInfosMat.close();
				vm.showInfoMat(identifiant);
				
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
