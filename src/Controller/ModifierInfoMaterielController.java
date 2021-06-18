package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Model.DataBase.ConnexionSQL;
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
					JOptionPane.showMessageDialog(null, "Il faut remplir tous les champs", "Erreur champs mal remplis", JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
			
			Materiel mat = vm.pModifMat.getMat();
			if(mat instanceof Ordinateur) {
				String marque = "", etat = "", salle = "";
				int capacite = 0;
				boolean fixe = false, souris = false;
				
				for(JTextField tf : vm.pModifMat.getText()) {
					String tfname =tf.getName();
					if(tfname.equalsIgnoreCase("marque")) {
						marque=tf.getText();
					}else if(tfname.equalsIgnoreCase("etat")) {
						etat=tf.getText();
					}else if(tfname.equalsIgnoreCase("salle")) {
						salle=tf.getText();
					}else if(tfname.equalsIgnoreCase("capacite")) {
						capacite = Integer.parseInt(tf.getText());
					}
				}
				for(JCheckBox cb : vm.pModifMat.getCoche()) {
					String cbname =cb.getName();
					if(cbname.equalsIgnoreCase("fixe")) {
						fixe = cb.isSelected();
					}else if(cbname.equalsIgnoreCase("souris")) {
						souris = cb.isSelected();
					}
				}
				ConnexionSQL.modifMat(mat.getID(), etat, marque, salle, capacite, fixe, souris);
			}else if(mat instanceof Tablette) {
				String marque = "", etat = "", salle = "";
				boolean clavier = false;
				
				Tablette tab = (Tablette) mat;
				for(JTextField tf : vm.pModifMat.getText()) {
					String tfname =tf.getName();
					if(tfname.equalsIgnoreCase("marque")) {
						marque=tf.getText();
					}else if(tfname.equalsIgnoreCase("etat")) {
						etat=tf.getText();
					}else if(tfname.equalsIgnoreCase("salle")) {
						salle=tf.getText();
					}
				}
				for(JCheckBox cb : vm.pModifMat.getCoche()) {
					String cbname =cb.getName();
					if(cbname.equalsIgnoreCase("clavier")) {
						tab.setClavier(cb.isSelected());
					}
				}
				ConnexionSQL.modifMat(mat.getID(), etat, marque, salle, clavier);
			}else if(mat instanceof VideoProjecteur) {
				String marque = "", etat = "", salle = "";
				boolean telecommande = false;
				
				for(JTextField tf : vm.pModifMat.getText()) {
					String tfname =tf.getName();
					if(tfname.equalsIgnoreCase("marque")) {
						marque=tf.getText();
					}else if(tfname.equalsIgnoreCase("etat")) {
						etat=tf.getText();
					}else if(tfname.equalsIgnoreCase("salle")) {
						salle=tf.getText();
					}
				}
				for(JCheckBox cb : vm.pModifMat.getCoche()) {
					String cbname =cb.getName();
					if(cbname.equalsIgnoreCase("telecommande")) {
						telecommande=cb.isSelected();
					}
				}
				ConnexionSQL.modifMat(mat.getID(), etat, marque, salle, telecommande);
			}
			
			JOptionPane.showMessageDialog(null, "Modifications Sauvegardées");
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
