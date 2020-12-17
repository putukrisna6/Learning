package gameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class MenuState extends GameState{
	private int currentChoice = 0;
	private String[] options = {"Start", "Help", "Quit"};
	
	private Color titleColor;
	private Font titleFont;
	
	private Font font;
	
	public MenuState(GameStateManager gsm) {
		this.gsm = gsm;
		
		try {

			titleColor = new Color(128, 0, 0);
			titleFont = new Font("Century Gothic", Font.PLAIN, 28);
		
			font = new Font("Arial", Font.PLAIN, 12);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
	}
	@Override
	public void draw(Graphics2D g2d) {
		// draw title
		g2d.setColor(titleColor);
		g2d.setFont(titleFont);
		g2d.drawString("Wacky Game", 70, 70);
		
		// draw menu
		g2d.setFont(font);
		for (int i = 0; i < options.length; i++) {
			if (i == currentChoice) {
				g2d.setColor(Color.BLACK);
			}
			else {
				g2d.setColor(Color.RED);
			}
			g2d.drawString(options[i], 145, 140 + i * 15);
		}
	}
	@Override
	public void keyPressed(int k) {
		if (k == KeyEvent.VK_ENTER) {
			select();
		}
		if (k == KeyEvent.VK_UP) {
			currentChoice--;
			// I changed it from == -1 to < 0
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
	public void keyReleased(int k) {
		// TODO Auto-generated method stub
		
	}
	
	private void select() {
		if (currentChoice == 0) {
			// start
			gsm.setState(GameStateManager.LEVEL1STATE);
		}
		else if (currentChoice == 1) {
			// help
		}
		else if (currentChoice == 2) {
			System.exit(0);
		}
	}
	
}
