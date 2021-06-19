package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import Model.Materiel.Ordinateur;
import Model.Materiel.Tablette;
import Model.Materiel.VideoProjecteur;
import View.ViewManager;
/**
 * Controller permettant la gestion de la page du choix du type d'appareil
 */
public class ChoixAjoutMatController implements MouseListener{
	
	private ViewManager vm;
	public ChoixAjoutMatController(ViewManager vm) {
		this.vm = vm;
	}

	/**
	 * Evénement appelé lors d'un appuie sur le bouton valider ou annuler.<br> 
	 * Créer un nouveau materiel vide du bon type si l'appuie et sur validé et qu'un type de materiel et choisi.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		JButton but = (JButton) e.getSource();
		
		if(but.getName().equalsIgnoreCase("annuler")) {
			vm.pChoixAjoutMat.close();
		}else if(but.getName().equalsIgnoreCase("valider")) {
			String type = null;
			LinkedList<JRadioButton> bg = vm.pChoixAjoutMat.getButton();
			for(JRadioButton bt : bg) {
				if(bt.isSelected()) {
					type = bt.getText();
					if(type.endsWith("ordinateur")) {
						Ordinateur o = new Ordinateur();	
						vm.pChoixAjoutMat.close();
						vm.showNewMat(o);
					}else if(type.endsWith("tablette")) {
						Tablette t = new Tablette();
						vm.pChoixAjoutMat.close();
						vm.showNewMat(t);
					}else if(type.endsWith("videoprojecteur")) {
						VideoProjecteur vp = new VideoProjecteur();
						vm.pChoixAjoutMat.close();
						vm.showNewMat(vp);
					}else {
						JOptionPane.showMessageDialog(null, "Il faut entrer un choix !","Erreur choix",JOptionPane.ERROR_MESSAGE);
					}
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
