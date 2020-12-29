package id.its.simplekeyboardevent;

import java.awt.Color;
import java.awt.Graphics;

public class Spacebar {
	private static final int WIDTH = 350;
	private static final int HEIGHT = 50;
	private static final int RELEASED = 1;
	private static final int PRESSED = 2;
	
	private int x;
	private int y;
	private int state;
	
	public Spacebar(int x, int y) {
		this.x = x;
		this.y = y;
		this.state = RELEASED;
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
	}
	
	public void setPressed() {
		this.state = PRESSED;
	}
	public void setReleased() {
		this.state = RELEASED;
	}
}
