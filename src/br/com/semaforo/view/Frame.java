package br.com.semaforo.view;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Frame extends JDialog {
	private static final long serialVersionUID = 3951847139925963714L;
	
	public Frame() {
		initComponents();
		blockFrame();
	}
	
	private void initComponents() {
		getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setUndecorated(true);
		setLayout(null);
		setModal(true);
	}
	
	private void blockFrame() {
        addComponentListener(new ComponentAdapter() {
        	public void componentMoved(ComponentEvent e) {
        		setEnabled(false);
        		setEnabled(true);
        	}
    	});
	}
	
}