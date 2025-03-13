package br.com.semaforo.view;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import java.awt.Color;

public class Frame extends JDialog {
	private static final long serialVersionUID = 3951847139925963714L;
	
	public Frame() {
		
		getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setUndecorated(true);
		setLayout(null);
		setModal(true);
		
		
		addComponentListener(new ComponentAdapter() {
        	@Override
        	public void componentMoved(ComponentEvent e) {
        		setEnabled(false);
        		setEnabled(true);
        	}
    	});
		
	}
	
}