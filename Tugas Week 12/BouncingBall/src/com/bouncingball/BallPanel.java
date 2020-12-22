package com.bouncingball;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Random;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BallPanel extends JPanel {
	private static final int REFRESH_RATE = 30;
	
	private Ball ball;
	private BallArea box;
	
	private int areaWidth;
	private int areaHeight;
	
	public BallPanel(int width, int height) {
		this.areaWidth = width;
		this.areaHeight = height;
		this.setPreferredSize(
					new Dimension(areaWidth, areaHeight)
				);
		
		Random rand = new Random();

		// set attributes for the ball's radius, speed, location, and direction
		int radius = 50;
		int x = rand.nextInt(width - radius * 2 - 20) + radius + 10;
		int y = rand.nextInt(height - radius * 2 - 20) + radius + 10;
		int speed = 5;
		int angleInDegree = rand.nextInt(360);

		// instantiate the Ball and BallArea objects
		ball = new Ball(x, y, radius, speed, angleInDegree, Color.BLUE);
		box = new BallArea(0, 0, width, height, Color.BLACK, Color.WHITE);

		//	get background size if frame is resized
		//	create a new anonymous class based on ComponentAdapter abstract class	
		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				Component c = (Component)e.getSource();
				Dimension d = c.getSize();
				
				areaWidth = d.width;
				areaHeight = d.height;
				box.set(0, 0, width, height);
			}
		});
		startThread();
	}

	private void startThread() {
		Thread gameThread = new Thread() {
			@Override
			public void run() {
				while (true) {
					ball.collide(box);
					repaint();
					
					try {
						Thread.sleep(1000 / REFRESH_RATE);
					}
					catch (InterruptedException ex) {}
				}
			}
		};
		gameThread.start();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		box.draw(g);
		ball.draw(g);
	}
}
