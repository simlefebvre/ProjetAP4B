package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.util.Date;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Model.Agenda.Reservation;
import Model.DataBase.ConnexionSQL;
import Model.Materiel.Materiel;
import View.ViewManager;
/**
 * Controller qui g�re l'ajout de reservations
 */
public class reservationController implements MouseListener {
	
	private ViewManager vm;
	public reservationController(ViewManager vm) {
		this.vm = vm;
	}

	/**
	 * Evenement appel� lors de l'appuie sur le bouton de validation ou d'anulation. Si le choix est de valider, la fonction v�rifiera que tout les materiels sont libre durant la p�riode demand� et g�nerera les r�servations
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
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
					if(!mat.disponible(deb, fin)) {
						JOptionPane.showMessageDialog(null, "Le materiel n�"+mat.getID()+" n'est pas disponnible pour les dates demand�es","Erreur Disponibilit�",JOptionPane.ERROR_MESSAGE);
					}else {
						Reservation r = new Reservation(deb, fin, MainClass.connecte, mat);
						ConnexionSQL.newReservation(r);
						
						JOptionPane.showMessageDialog(null, "Le materiel n�"+mat.getID()+" a bien �t� r�serv�","R�serv� !",JOptionPane.INFORMATION_MESSAGE);
						vm.pAjoutReserv.close();
					}
				}
				//D�cocher les JCheckBox
				for(JCheckBox cb : this.vm.pAffMat.getBox()) {
					if(cb.isSelected()) {
						cb.setSelected(false);
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
