package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Model.DataBase.BaseDeDonee;
import Model.Utilisateur.Utilisateur;
import View.PageConnexion;
import View.ViewManager;

public class connexionController implements MouseListener {

	private ViewManager vm;

	public connexionController(ViewManager vm) {
		this.vm = vm;
	}

	// TODO orientation administrateur

	@Override
	public void mouseClicked(MouseEvent e) {
		JButton bouton = (JButton) e.getSource();

		if (bouton.getText().equalsIgnoreCase("connexion")) {
			String identifiant = vm.page.getIdentifiant();
			String mdp = vm.page.getMdp();

			boolean test = false;
			for (Utilisateur usr : BaseDeDonee.getInstance().getUtilisateurs()) {
				if (usr.connexion(identifiant, mdp)) {
					MainClass.connecte = usr;
					vm.page.close();
					vm.showMenuProf();
					test = true;
					break;
				}
			}
			if (!test) {
				JOptionPane.showMessageDialog(null, "Mot de passe incorect");
				vm.page.clearField();
			}
		} else if (bouton.getText().equalsIgnoreCase("Mot de passe oublié")) {
			JOptionPane.showMessageDialog(null, "Voyez avec votre administrateur réseau");
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
