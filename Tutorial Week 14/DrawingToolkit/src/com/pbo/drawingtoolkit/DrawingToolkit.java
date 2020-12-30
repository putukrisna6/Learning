package com.pbo.drawingtoolkit;

import java.awt.Dimension;

import javax.swing.SwingUtilities;

public class DrawingToolkit {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				DrawingFrame canvasGUI = new DrawingFrame();
				canvasGUI.setSize(new Dimension(600, 600));
				canvasGUI.setVisible(true);
			}
		}); 
	}

}
