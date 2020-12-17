package com.moving;

import java.awt.EventQueue;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MovingSpriteEx extends JFrame{
	protected static final int WIDTH = 400;
	protected static final int HEIGHT = 300;
	
	private void initUI() {
		add(new Board());
		
		setTitle("Moving Sprite");
		setSize(WIDTH, HEIGHT);
		
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public MovingSpriteEx() {
		initUI();
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			MovingSpriteEx ex = new MovingSpriteEx();
			ex.setVisible(true);
		});
	}

}
