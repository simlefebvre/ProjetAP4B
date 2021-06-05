package View;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Marge extends JPanel{
	
	public Marge() {
	}
	
	public Marge(int TaillePolice) {
		Font font = new Font("Arial",Font.BOLD,TaillePolice);
		JLabel txtMarge = new JLabel(" ");
	    txtMarge.setFont(font);
	    add(txtMarge);
	}

}
