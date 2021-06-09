package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.util.Date;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Model.Agenda.Reservation;
import Model.Materiel.Materiel;
import View.ViewManager;

public class reservationController implements MouseListener {
	
	private ViewManager vm;
	public reservationController(ViewManager vm) {
		this.vm = vm;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		//Reservation.formatDate.format();
		
		Date erreur=null;
		try {
			erreur = Reservation.formatDate.parse("01/01/1900 00:00");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		if(e.getSource() instanceof JButton) {
			JButton but = (JButton) e.getSource();
			
			String name = but.getName();
			Date deb = null;
			Date fin = null;
			if(name.equalsIgnoreCase("valider")) {
				LinkedList<JTextField> texte =  vm.pAjoutReserv.getText();
				for(JTextField text : texte) {
					if(text.getName().equalsIgnoreCase("debut")) {
						deb = Reservation.strToDate(text.getText());
					}else if(text.getName().equalsIgnoreCase("fin")){
						fin = Reservation.strToDate(text.getText());
					}
				}
				
				if(deb.equals(erreur) || fin.equals(erreur)) {
					JOptionPane.showMessageDialog(null,"Vous avez mal entrer les dates","Erreur date",JOptionPane.ERROR_MESSAGE);
					return;
				}
				for(Materiel mat : vm.pAjoutReserv.getmat()) {
					if(!mat.getAgenda().disponible(deb, fin)) {
						JOptionPane.showMessageDialog(null, "Le materiel n°"+mat.getID()+" n'est pas disponnible pour les dates demandées","Erreur Disponibilité",JOptionPane.ERROR_MESSAGE);
					}else {
						mat.getAgenda().ajouterReservation(new Reservation(deb, fin, MainClass.connecte));
						JOptionPane.showMessageDialog(null, "Le materiel n°"+mat.getID()+" a bien été réservé","Réservé !",JOptionPane.INFORMATION_MESSAGE);
						vm.pAjoutReserv.close();
					}
				}
				
				
				
			}else if(name.equalsIgnoreCase("annuler")) {
				vm.pAjoutReserv.close();
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
