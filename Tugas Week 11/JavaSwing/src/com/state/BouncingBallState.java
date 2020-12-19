package com.state;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;

import com.main.Commons;
import com.maps.Background;
import com.maps.Ball;

public class BouncingBallState extends State {

	private Background bg;
	
//	option
	private Font optionFont;
	
//	Balls
	private Ball ball1 = new Ball(30);
	private Ball ball2 = new Ball(60);
	private Ball ball3 = new Ball(120);
	
//	Constructor
	public BouncingBallState(StateManager sm) {
		super(sm);
//		load the background image and instantiate the font that'll be used in this state
		try {
			bg = new Background("/Backgrounds/bounceball.png", 1);
			bg.setVector(0, 0);
			
			optionFont = new Font("Arial", Font.BOLD, 18);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void init() {}
//	call each balls' method to make them move
	@Override
	public void update() {
		ball1.move();
		ball2.move();
		ball3.move();
	}
	@Override
	public void draw(Graphics2D g2d) {
		bg.draw(g2d);
		
//		draw option text
		g2d.setRenderingHint(
				RenderingHints.KEY_TEXT_ANTIALIASING, 
				RenderingHints.VALUE_TEXT_ANTIALIAS_ON
			);
		FontMetrics m = g2d.getFontMetrics(optionFont);
		String text = "Back to Menu";
		
		int x = makeWidth(text, m);
		int y = makeHeight(70, m);
		
		g2d.setColor(Color.BLACK);
		g2d.setFont(optionFont);
		g2d.drawString(text, x, y);
		
//		draw balls
		g2d.setRenderingHint(
				RenderingHints.KEY_ANTIALIASING, 
				RenderingHints.VALUE_ANTIALIAS_ON
			);
		
		ball1.paint(g2d);
		g2d.setColor(Color.GRAY);
		ball2.paint(g2d);
		g2d.setColor(Color.WHITE);
		ball3.paint(g2d);
		g2d.setColor(Color.DARK_GRAY);
	}
	
//	Receive key inputs
	@Override
	public void keyPressed(int k) {
		if (k == KeyEvent.VK_ENTER) {
			sm.setState(StateManager.MENUSTATE);
		}
	}
	@Override
	public void keyReleased(int k) {}
	
//	Methods to keep the String centered
	private int makeWidth(String text, FontMetrics m) {
		return (Commons.WIDTH / 2) - (m.stringWidth(text) / 2);
	}
	private int makeHeight(int y, FontMetrics m) {
		return (y - m.getHeight() / 2) + m.getAscent();
	}
}
