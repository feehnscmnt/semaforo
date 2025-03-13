package br.com.semaforo.view;

import br.com.semaforo.util.Utils;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Toolkit;

public class Lights extends JPanel {
	private static final long serialVersionUID = 6621756500992792030L;
	private String imgBackground;
	
	public Lights(String imgBackground) {
		this.imgBackground = imgBackground;
		initComponents();
	}
	
	private void initComponents() {
		JLabel lblImage = new JLabel();
		setLayout(new BorderLayout());
		lblImage.setIcon(new ImageIcon(Toolkit.getDefaultToolkit()
			.getImage(Utils.getResourceImage(imgBackground)).getScaledInstance(220, 220, 1)));
		add(lblImage);
	}
	
}