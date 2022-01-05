package br.com.semaforo.process;

import br.com.semaforo.util.*;
import javax.swing.*;
import java.awt.*;

public class Processo extends Thread {
	private Component[] panels;
	private JPanel pnlLights;
	
	public Processo(JPanel pnlLights) {
		this.pnlLights = pnlLights;
	}
	
	public void run() {
		panels = pnlLights.getComponents();
		try {
			while (true) {
				for (Component panel : panels) {
					if (panel instanceof JPanel) {
						Component[] labels = ((JPanel) panel).getComponents();
						for (Component label : labels) {
							if (label instanceof JLabel) {
								if (panel.getName().equals("pnlVermelho")) {
									updateLights("imgRedLightOn.png", label);
									Thread.sleep(5000);
									updateLights("imgRedLightOff.png", label);
								} else if (panel.getName().equals("pnlAmarelo")) {
									updateLights("imgYellowLightOn.png", label);
									Thread.sleep(2000);
									updateLights("imgYellowLightOff.png", label);
								} else if (panel.getName().equals("pnlVerde")) {
									updateLights("imgGreenLightOn.png", label);
									Thread.sleep(5000);
									updateLights("imgGreenLightOff.png", label);
								}
							}
						}
					}
				}
			}
		} catch(InterruptedException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	private void updateLights(String fileImage, Component label) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage(Utils.getResourceImage(fileImage));
		Image imageAux = image.getScaledInstance(220, 220, 1);
		ImageIcon imageIcon = new ImageIcon(imageAux);
		((JLabel) label).setIcon(imageIcon);
	}
	
}