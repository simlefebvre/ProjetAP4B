package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Model.DataBase.BaseDeDonee;
import Model.Materiel.Materiel;
import Model.Materiel.Ordinateur;
import Model.Materiel.Tablette;
import Model.Materiel.VideoProjecteur;
import View.ViewManager;

public class AjoutMatController implements MouseListener {

	
	private ViewManager vm;
	public AjoutMatController(ViewManager vm) {
		this.vm = vm;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		JButton but = (JButton) e.getSource();
		String name = but.getName();
		if(name.contentEquals("annuler")) {
			vm.pAjoutMat.close();
		}else if(name.equalsIgnoreCase("valider")) {
			Materiel mat = vm.pAjoutMat.getMat();
			
			for(JTextField text : vm.pAjoutMat.getText()) {
				String nameT = text.getName();
				String content = text.getText();
				if(nameT.equalsIgnoreCase("marque")) {
					mat.setMarque(content);
				}else if(nameT.equalsIgnoreCase("etat")) {
					mat.setEtat(content);
				}else if(nameT.equalsIgnoreCase("salle")) {
					mat.setSalle(content);
				}
				
			}
			
			if(mat instanceof Ordinateur) {
				Ordinateur o = (Ordinateur) mat;
				for(JCheckBox cb : vm.pAjoutMat.getCoches()) {
					if(cb.getName().equalsIgnoreCase("souris")) {
						o.setSouris(cb.isSelected());
					}else if(cb.getName().equalsIgnoreCase("fixe")) {
						o.setFixe(cb.isSelected());
					}
				}
				for(JTextField text : vm.pAjoutMat.getText()) {
					String nameT = text.getName();
					String content = text.getText();
					if(nameT.equalsIgnoreCase("capacite")) {
						try {
							int capacite = Integer.parseInt(content);
							o.setCapacite(capacite);
						}catch(Exception ex) {
							JOptionPane.showMessageDialog(null,"Veuillez entrer un entier dans la capacite", "Erreur capacite", JOptionPane.ERROR_MESSAGE);
							return;
						}
					}
					
				}
			}else if(mat instanceof Tablette) {
				Tablette t = (Tablette) mat;
				for(JCheckBox cb : vm.pAjoutMat.getCoches()) {
					if(cb.getName().equalsIgnoreCase("clavier")) {
						t.setClavier(cb.isSelected());
					}
				}
			}else if(mat instanceof VideoProjecteur) {
				VideoProjecteur vp = (VideoProjecteur) mat;
				for(JCheckBox cb : vm.pAjoutMat.getCoches()) {
					if(cb.getName().equalsIgnoreCase("telecommande")) {
						vp.setTelecommande(cb.isSelected());
					}
				}
			}
			
			BaseDeDonee.getInstance().addMateriel(mat);
			vm.pAjoutMat.close();
			
			//Maj AfficherMateriels
			vm.pAffMat.close();
			vm.showMaterielDispo();
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
