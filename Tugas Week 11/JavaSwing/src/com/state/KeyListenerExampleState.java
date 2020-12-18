package com.state;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;

import com.main.Commons;
import com.maps.Background;

public class KeyListenerExampleState extends State {
	
	private Background bg;
	
	private int clicks = 0;
	
//	fonts
	private Color titleColor;
	private Font titleFont;
	private Font font;
	private Font optionFont;
	
//	options
	private String[] options = {
				"Add", "Subtract", "Back to Menu"
			};
	private int currentChoice = 0;
	
	public KeyListenerExampleState(StateManager sm) {
		super(sm);
		
		try {
			bg = new Background("/Backgrounds/keylistexbg.png", 1);
			bg.setVector(0, 0);
			
			titleColor = new Color(17, 27, 28);
			titleFont = new Font("Century Gothic", Font.BOLD, 40);
			
			optionFont = new Font("Arial", Font.BOLD, 12);
			
			font = new Font("Arial", Font.PLAIN, 14);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	@Override
	public void init() {
		
	}
	@Override
	public void update() {
		bg.update();
	}
	@Override
	public void draw(Graphics2D g2d) {
		bg.draw(g2d);

		g2d.setRenderingHint(
					RenderingHints.KEY_TEXT_ANTIALIASING, 
					RenderingHints.VALUE_TEXT_ANTIALIAS_ON
				);

		FontMetrics m ;
		String text;
		int x;
		int y;
		
//		draw counter
		m = g2d.getFontMetrics(titleFont);
		text = String.valueOf(clicks);
		
		x = makeWidth(text, m);
		y = makeHeight(70, m);
		
		g2d.setColor(titleColor);
		g2d.setFont(titleFont);
		g2d.drawString(text, x, y);
		
//		draw description
		m = g2d.getFontMetrics(font);
		text = "Press Enter";
		
		x = makeWidth(text, m);
		y = makeHeight(120, m);
		
		g2d.setFont(font);
		g2d.drawString(text, x, y);
		
//		draw options
		m = g2d.getFontMetrics(optionFont);
		g2d.setFont(optionFont);
		for (int i = 0; i < options.length; i++) {
			if (i == currentChoice) {
				g2d.setColor(Color.WHITE);
			}
			else {
				g2d.setColor(titleColor);
			}
			text = options[i];
			x = makeWidth(text, m);
			y = makeHeight(160 + i * 27, m);
			g2d.drawString(text, x, y);
		}
	}
	
	@Override
	public void keyPressed(int k) {
		if (k == KeyEvent.VK_ENTER) {
			select();
		}
		if (k == KeyEvent.VK_UP) {
			currentChoice--;
			if (currentChoice < 0) {
				currentChoice = options.length - 1;
			}
		}
		if (k == KeyEvent.VK_DOWN) {
			currentChoice++;
			if (currentChoice == options.length) {
				currentChoice = 0;
			}
		}
	}
	@Override
	public void keyReleased(int k) {}
	
	private void select() {
		if (currentChoice == 0) {
			clicks++;
		}
		else if (currentChoice == 1) {
			clicks--;
		}
		else if (currentChoice == 2) {
			sm.setState(StateManager.MENUSTATE);
			clicks = 0;
		}
	}
	
	private int makeWidth(String text, FontMetrics m) {
		return (Commons.WIDTH / 2) - (m.stringWidth(text) / 2);
	}
	private int makeHeight(int y, FontMetrics m) {
		return (y - m.getHeight() / 2) + m.getAscent();
	}

}
