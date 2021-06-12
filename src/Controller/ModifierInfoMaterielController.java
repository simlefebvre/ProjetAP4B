package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Model.Materiel.Materiel;
import Model.Materiel.Ordinateur;
import Model.Materiel.Tablette;
import Model.Materiel.VideoProjecteur;
import View.ViewManager;

public class ModifierInfoMaterielController implements MouseListener {

	private ViewManager vm;
	public ModifierInfoMaterielController(ViewManager vm) {
		this.vm = vm;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		JButton but = (JButton) e.getSource();
		String name = but.getName();
		
		if(name.equalsIgnoreCase("Valider")) {
			for(JTextField tf : vm.pModifMat.getText()) {
				if(tf.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Il faut remplir tous les champs", "Erreur champs mal rempli", JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
			Materiel mat = vm.pModifMat.getMat();
			if(mat instanceof Ordinateur) {
				Ordinateur ordi = (Ordinateur) mat;
				for(JTextField tf : vm.pModifMat.getText()) {
					String tfname =tf.getName();
					if(tfname.equalsIgnoreCase("marque")) {
						ordi.setMarque(tf.getText());
					}else if(tfname.equalsIgnoreCase("etat")) {
						ordi.setEtat(tf.getText());
					}else if(tfname.equalsIgnoreCase("salle")) {
						ordi.setSalle(tf.getText());
					}else if(tfname.equalsIgnoreCase("capacite")) {
						ordi.setCapacite(Integer.parseInt(tf.getText()));
					}
				}
				for(JCheckBox cb : vm.pModifMat.getCoche()) {
					String cbname =cb.getName();
					if(cbname.equalsIgnoreCase("fixe")) {
						ordi.setFixe(cb.isSelected());
					}else if(cbname.equalsIgnoreCase("souris")) {
						ordi.setSouris(cb.isSelected());
					}
				}
			}else if(mat instanceof Tablette) {
				Tablette tab = (Tablette) mat;
				for(JTextField tf : vm.pModifMat.getText()) {
					String tfname =tf.getName();
					if(tfname.equalsIgnoreCase("marque")) {
						tab.setMarque(tf.getText());
					}else if(tfname.equalsIgnoreCase("etat")) {
						tab.setEtat(tf.getText());
					}else if(tfname.equalsIgnoreCase("salle")) {
						tab.setSalle(tf.getText());
					}
				}
				for(JCheckBox cb : vm.pModifMat.getCoche()) {
					String cbname =cb.getName();
					if(cbname.equalsIgnoreCase("clavier")) {
						tab.setClavier(cb.isSelected());
					}
				}
			}else if(mat instanceof VideoProjecteur) {
				VideoProjecteur vp = (VideoProjecteur) mat;
				for(JTextField tf : vm.pModifMat.getText()) {
					String tfname =tf.getName();
					if(tfname.equalsIgnoreCase("marque")) {
						vp.setMarque(tf.getText());
					}else if(tfname.equalsIgnoreCase("etat")) {
						vp.setEtat(tf.getText());
					}else if(tfname.equalsIgnoreCase("salle")) {
						vp.setSalle(tf.getText());
					}
				}
				for(JCheckBox cb : vm.pModifMat.getCoche()) {
					String cbname =cb.getName();
					if(cbname.equalsIgnoreCase("telecommande")) {
						vp.setTelecommande(cb.isSelected());
					}
				}
			}
			
			JOptionPane.showMessageDialog(null, "Modification Sauvegarder");
			vm.pModifMat.close();
			
		}else if(name.equalsIgnoreCase("annuler")) {
			vm.pModifMat.close();
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
