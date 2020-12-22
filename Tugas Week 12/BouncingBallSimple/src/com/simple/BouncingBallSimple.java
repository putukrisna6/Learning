package com.simple;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class BouncingBallSimple extends JPanel {
//	attributes for the area
	private static final int AREA_WIDTH = 640;
	private static final int AREA_HEIGHT = 480;
	
//	attributes for the ball
	//	for the initial position
	private static final int BALL_X_INITIAL_POSITION = 50;
	private static final int BALL_Y_INITIAL_POSITION = 20;
	//	for the ball's radius
	private double ballRadius = 50;
	//	for the ball's initial location based on its radius
	private double ballX = ballRadius + BALL_X_INITIAL_POSITION;
	private double ballY = ballRadius + BALL_Y_INITIAL_POSITION;
	//	for the ball's speed on the X and Y axis
	private float ballSpeedX = 4;
	private float ballSpeedY = 3;
	
//	Target refresh rate
	private static final int REFRESH_RATE = 30;
	
//	Override the paintComponent to render the ball and area background
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//	draw a black background
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, AREA_WIDTH, AREA_HEIGHT);

		// draw a red ball
		g.setColor(Color.RED);
		g.fillOval(
					(int) (ballX - ballRadius), 
					(int) (ballY - ballRadius), 
					(int)(2 * ballRadius), 
					(int)(2 * ballRadius)
				);
	}
	
//	Constructor and code to detect collision with the border
	public BouncingBallSimple() {
		this.setPreferredSize(
					new Dimension(AREA_WIDTH, AREA_HEIGHT)
				);

		//	Thread to update the ball's position and detect collision
		Thread gameThread = new Thread() {
			@Override
			public void run() {
				while (true) {
					//	Update the ball's position as it moves
					ballX += ballSpeedX;
					ballY += ballSpeedY;
					
					// Detect collision with the left and right sides
					if (ballX - ballRadius < 0) {
						ballSpeedX = -ballSpeedX;
						ballX = ballRadius;
					} 
					else if (ballX + ballRadius > AREA_WIDTH) {
						ballSpeedX = -ballSpeedX;
						ballX = AREA_WIDTH - ballRadius;
					}
					// While this one detects collision with the top and bottom sides
					if (ballY - ballRadius < 0) {
						ballSpeedY = -ballSpeedY;
						ballY = ballRadius;
					} 
					else if (ballY + ballRadius > AREA_HEIGHT) {
						ballSpeedY = -ballSpeedY;
						ballY = AREA_HEIGHT - ballRadius;
					}
					
					// Refresh screen
					// this method will call the paintComponent() method
					repaint();
					// delay
					try {
						Thread.sleep(1000 / REFRESH_RATE); 
					} 
					catch (InterruptedException ex) {}
				}
			}
		};
		//	run thread
		gameThread.start();
	}
	
	public static void main(String[] args) {
		// Run UI at Event dispatcher thread
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// instantiate the JFrame and put the panel on the frame
				JFrame frame = new JFrame("Simple Bouncing Ball");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setContentPane(new BouncingBallSimple());
				frame.pack();
				frame.setVisible(true);
			}
		});

	}

}
