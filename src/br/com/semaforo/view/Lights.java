package br.com.semaforo.view;

import br.com.semaforo.util.*;
import javax.swing.*;
import java.awt.*;

public class Lights extends JPanel {
	private static final long serialVersionUID = 6621756500992792030L;
	private String imgBackground;
	private JLabel lblImage;
	
	public Lights(String imgBackground) {
		this.imgBackground = imgBackground;
		initComponents();
	}
	
	private void initComponents() {
		lblImage = new JLabel();
		setLayout(new BorderLayout());
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage(Utils.getResourceImage(imgBackground));
		Image imageAux = image.getScaledInstance(220, 220, 1);
		ImageIcon imageIcon = new ImageIcon(imageAux);
		lblImage.setIcon(imageIcon);
		add(lblImage);
	}
	
}