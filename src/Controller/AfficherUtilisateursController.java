package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Model.DataBase.ConnexionSQL;
import Model.Utilisateur.Utilisateur;
import View.ViewManager;
/**
 * Controller qui gère la page d'affichage du profil utilisateur
 */
public class AfficherUtilisateursController implements MouseListener{
	
	private ViewManager vm;
	
	public AfficherUtilisateursController(ViewManager vm) {
		this.vm=vm;
	}
	
	
	/**
	 * événement qui s'occupe des boutons de modification, de suppression et d'ajout d'un utilisateur
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() instanceof JButton) {
			JButton b = (JButton) e.getSource();
			String nomBouton = b.getName();
			
			if (nomBouton.contains("modif")) {
				//Récupérer id utilisateur
				String mail = nomBouton.substring(6);
				//Chercher utilisateur en fonction son id
				Utilisateur util = ConnexionSQL.getUtilisateur(mail);
				if(util != null) {
					//Modifier utilisateur
					this.vm.showModifierInfosUtilisateur(util, "afficherUtil");	
				}
					
			} else if (nomBouton.contains("suppr")) {
				//Récupérer id utilisateur
				String mail = nomBouton.substring(6);
				//Controler que l'utilisateur ne se supprime pas tout seul
				if(mail.equalsIgnoreCase(MainClass.connecte.getMail())) {
					JOptionPane.showMessageDialog(null, "Erreur vous ne pouvez pas supprimer votre profil", "Erreur suppression profil", JOptionPane.ERROR_MESSAGE);
				}else {
					//Supprimer utilisateur					
					int choix =JOptionPane.showOptionDialog(null, "Etes-vous sûr de vouloir supprimer cet utilisateur ?", "Suppression d'un utilisateur",JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
					if(choix == JOptionPane.YES_OPTION) {
						ConnexionSQL.delUtil(mail);
						//MAJ page AfficherUtilisateurs
						vm.pAffUtilisateurs.refresh();
					}
				}
				
				
			}else if (b.getName().equals("retour")) {
				this.vm.pAffUtilisateurs.close();
				this.vm.showMenuProf();
			}else if (b.getName().equals("ajouter")) {
				this.vm.showAjoutUtil();
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
