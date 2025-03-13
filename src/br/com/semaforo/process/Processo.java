package br.com.semaforo.process;

import br.com.semaforo.util.Utils;
import javax.swing.ImageIcon;
import java.time.LocalTime;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Component;
import java.awt.Toolkit;

public class Processo extends Thread {
	private JPanel pnlLights;
	
	public Processo(JPanel pnlLights) {
		this.pnlLights = pnlLights;
	}
	
	@Override
	public void run() {
		
		Component[] panels = pnlLights.getComponents();
		
		while (true) {
			
			LocalTime horaAtual = LocalTime.now();
	        LocalTime inicio = LocalTime.of(5, 0);
	        LocalTime fim = LocalTime.MIDNIGHT;
			
			for (Component panel : panels) {
				
				if (panel instanceof JPanel jPanel) {
					
					Component[] labels = jPanel.getComponents();
					
					for (Component label : labels) {
						
						if (label instanceof JLabel) {
							
							if (horaAtual.isAfter(inicio) && horaAtual.isBefore(fim)) {
							
								if (panel.getName().equals("pnlVermelho")) {
									
									updateLights("imgRedLightOn.png", label);
									
									timer(7000L);
									
									updateLights("imgRedLightOff.png", label);
									
								} else if (panel.getName().equals("pnlAmarelo")) {
									
									updateLights("imgYellowLightOn.png", label);
									
									timer(4000L);
									
									updateLights("imgYellowLightOff.png", label);
									
								} else if (panel.getName().equals("pnlVerde")) {
									
									updateLights("imgGreenLightOn.png", label);
									
									timer(10000L);
									
									updateLights("imgGreenLightOff.png", label);
									
								}
								
							} else {
								
								if (panel.getName().equals("pnlAmarelo")) {
									
									updateLights("imgYellowLightOn.png", label);
									
									timer(1000L);
									
									updateLights("imgYellowLightOff.png", label);
									
									timer(1000L);
									
								}
								
							}
							
						}
						
					}
					
				}
				
			}
			
		}
		
	}
	
	private void updateLights(String fileImage, Component label) {
		
		((JLabel) label).setIcon(new ImageIcon(Toolkit.getDefaultToolkit()
			.getImage(Utils.getResourceImage(fileImage)).getScaledInstance(220, 220, 1)));
		
	}
	
	private void timer(Long millis) {
		
		try {
			
			Thread.sleep(millis);
			
		} catch (InterruptedException e) {
			
			System.out.println(String.format("Houve erro ao executar o timer do semáforo. Exception: %s", e.getMessage()));
			Thread.currentThread().interrupt();
			
		}
		
	}
	
}