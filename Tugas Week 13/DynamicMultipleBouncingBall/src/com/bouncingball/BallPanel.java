package com.bouncingball;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BallPanel extends JPanel implements KeyListener {
	private static final int REFRESH_RATE = 30;
	private static final int RADIUS = 30;
	private static final int SPEED = 5;
	
	private ArrayList<Ball> balls;
	private BallArea box;
	
	private int areaWidth;
	private int areaHeight;
	
	public BallPanel(int width, int height) {
		this.areaWidth = width;
		this.areaHeight = height;
		this.setPreferredSize(
					new Dimension(areaWidth, areaHeight)
				);
				
		this.addKeyListener(this);
		this.setFocusable(true);
		
		// instantiate the Ball and BallArea objects
		balls = new ArrayList<Ball>();
		box = new BallArea(0, 0, width, height, Color.BLACK, Color.WHITE);

//		balls.add(new Ball(getPlacement(), getPlacement(), RADIUS, SPEED, 10, getColor(), "A"));
//		balls.add(new Ball(getPlacement(), getPlacement(), RADIUS, SPEED, 10, getColor(), "B"));

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
					for (Ball ball : balls) {
						ball.collide(box);
					}
					
					for (Ball b1 : balls) {
						for (Ball b2 : balls) {
							if (b1 != b2) {
								Rectangle rect1 = b1.getBound();
								Rectangle rect2 = b2.getBound();
								if (rect1.intersects(rect2)) {
									int ballLeft = (int) rect1.getMinX();
									int ballHeight = (int) rect1.getHeight();
									int ballWidth = (int) rect1.getWidth();
									int ballTop = (int) rect1.getMinY();
									
									Point pointRight = new Point(ballLeft + ballWidth + 1, ballTop);
						    		Point pointLeft = new Point(ballLeft - 1, ballTop);
						    		Point pointTop = new Point(ballLeft, ballTop - 1);
						    		Point pointBottom = new Point(ballLeft, ballTop + ballHeight + 1);
						    		
						    		if (rect2.contains(pointRight)) {
						    			b1.moveWest();
						    			b2.moveEast();
						    		}
						    		else if (rect2.contains(pointLeft)) {
						    			b2.moveWest();
						    			b1.moveEast();
						    		}
						    		
						    		if (rect2.contains(pointTop)) {
						    			b1.moveSouth();
						    			b2.moveNorth();
						    		}
						    		else if (rect2.contains(pointBottom)) {
						    			b2.moveSouth();
						    			b1.moveNorth();
						    		}
								}
							}
						}
					}
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
		for (Ball ball : balls) {
			ball.draw(g);
		}
	}
	
	private Color getColor() {
		Random rand = new Random();
		int colorRand = rand.nextInt(5);
		
		switch (colorRand) {
		case 0: {
			return Color.RED;
		}
		case 1: {
			return Color.BLUE;
		}
		case 2: {
			return Color.WHITE;
		}
		case 3: {
			return Color.GREEN;
		}
		case 4: {
			return Color.YELLOW;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + colorRand);
		}
	}
	private int getPlacement() {
		Random rand = new Random();
		return rand.nextInt(areaWidth - RADIUS * 2 - 20) + RADIUS + 10;
	}
	private int getAngle() {
		Random rand = new Random();
		return rand.nextInt(360);
	}

	@Override
	public void keyTyped(KeyEvent e) {	}
	@Override
	public void keyPressed(KeyEvent e) {
		balls.add(
				new Ball(
						getPlacement(), getPlacement(), 
						RADIUS, SPEED, getAngle(), 
						getColor(), 
						String.valueOf(
								e.getKeyChar()
								)
						)
				);
		
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {	}
}
