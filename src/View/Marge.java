package View;

import java.awt.Dimension;

import javax.swing.JPanel;

public class Marge extends JPanel{
	
	public Marge() {
	}
	
	public Marge(int height) {
		setSize(new Dimension(getWidth(),height));
	}

}
