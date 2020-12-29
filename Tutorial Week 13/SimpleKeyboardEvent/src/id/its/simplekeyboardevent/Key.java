package id.its.simplekeyboardevent;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

public class Key {
	private static final int WIDTH = 50;
	private static final int HEIGHT = 50;
	private static final int RELEASED = 1;
	private static final int PRESSED = 2;
	
	private int x;
	private int y;
	private char symbol;
	private int state;
	
	public Key(int x, int y, char symbol) {
		this.x = x;
		this.y = y;
		this.state = RELEASED;
		this.symbol = symbol;
	}
	
	public void render(Graphics g) {
		
		Color keyColor = new Color (39, 34, 34);
		Color keyColorPressed = new Color(95, 91, 70);
		//	change color based on state	
		if (this.state == RELEASED) {
			g.setColor(keyColor);
		}
		else if (this.state == PRESSED) {
			g.setColor(keyColorPressed);
		}
		else {
			g.setColor(Color.WHITE);
		}
		
		g.fillRect(this.x, this.y, WIDTH, HEIGHT);
		
		// render text				
		Font font = new Font("Verdana", Font.ITALIC, 24);
		FontMetrics metrics = g.getFontMetrics(font);
		
		String text = String.valueOf(symbol);
		text = text.toUpperCase();
		int stringPosX = makeWidth(text, metrics);
		int stringPosY = makeHeight(y + (HEIGHT / 2), metrics);
		
		
		g.setColor(Color.WHITE);
		g.setFont(font);
		g.drawString(
					text, 
					stringPosX + (int)x, 
					stringPosY
				);
	}
	public boolean isSymbolMatch(char symbol) {
		return this.symbol == symbol;
	}
	
	public void setPressed() {
		this.state = PRESSED;
	}
	public void setReleased() {
		this.state = RELEASED;
	}
	
	private int makeWidth(String text, FontMetrics m) {
		return (WIDTH / 2) - (m.stringWidth(text) / 2); 
	}
	private int makeHeight(int y, FontMetrics m) {
		return (y - m.getHeight() / 2) + m.getAscent();
	}
}
