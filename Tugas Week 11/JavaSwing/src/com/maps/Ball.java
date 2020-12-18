package com.maps;

import java.awt.Graphics2D;

import com.main.Commons;

public class Ball {

	private final int diameter;
	
	private int x = 0;
	private int y = 0;
	private int xa = 1;
	private int ya = 1;
	
	public Ball(int diameter) {
		this.diameter = diameter;
	}
	
	public void move() {		
		if (x + xa < 0) {
			xa = 1;
		}
		else if (x + xa > Commons.WIDTH - diameter) {
			xa = -1;
		}
		else if (y + ya < 0) {
			ya = 1;
		}
		else if (y + ya > Commons.HEIGHT - diameter) {
			ya = -1;
		}
		
		x += xa;
		y += ya;
	}
	
	public void paint(Graphics2D g2d) {
		g2d.fillOval(x, y, diameter, diameter);
	}
}
