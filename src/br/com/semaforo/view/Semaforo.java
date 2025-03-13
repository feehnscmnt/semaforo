package br.com.semaforo.view;

import br.com.semaforo.process.Processo;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Color;

public class Semaforo extends Frame {
	private static final long serialVersionUID = -4269292219557250290L;
	
	public Semaforo() {
		getRootPane().setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.YELLOW));
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		Integer x = (screen.width - 343) / 2;
		Integer y = (screen.height - 765) / 2;
		setBounds(x, y, 343, 765);
		
		JPanel pnlLights = new JPanel();
		pnlLights.setLayout(null);
		pnlLights.setBounds(0, 0, 352, 755);
		pnlLights.setBackground(new Color(0, 0, 0));
		
		JPanel pnlVermelho = new Lights("imgRedLightOff.png");
		pnlVermelho.setBounds(60, 40, 220, 220);
		pnlVermelho.setName("pnlVermelho");
		
		JPanel pnlAmarelo = new Lights("imgYellowLightOff.png");
		pnlAmarelo.setBounds(60, 270, 220, 220);
		pnlAmarelo.setName("pnlAmarelo");
		
		JPanel pnlVerde = new Lights("imgGreenLightOff.png");
		pnlVerde.setBounds(60, 500, 220, 220);
		pnlVerde.setName("pnlVerde");
		
		pnlLights.add(pnlVermelho);
		pnlLights.add(pnlVerde);
		pnlLights.add(pnlAmarelo);
		
		add(pnlLights);
		
		new Processo(pnlLights).start();
	}
	
}