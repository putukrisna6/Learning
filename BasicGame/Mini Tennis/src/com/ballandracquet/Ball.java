package com.ballandracquet;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball {
	private static final int DIAMETER = 30;
	int x = 0;
	int y = 0;
	int xa = 1;
	int ya = 1;
	private Game game;

	public Ball(Game game) {
		this.game = game;
	}

	void move() {
		@SuppressWarnings("unused")
		boolean changeDirection = true;
		
		if (x + xa < 0)
			xa = game.speed;
		else if (x + xa > game.getWidth() - 30)
			xa = -game.speed;
		else if (y + ya < 0)
			ya = game.speed;
		else if (y + ya > game.getHeight() - 30)
			game.gameOver();
		else if (collision()) {
			ya = -game.speed;
			y = game.racquet.getTopY() - DIAMETER;
			game.speed++;
		}
		else {
			changeDirection = false;
		}
		
		x = x + xa;
		y = y + ya;
	}
	
	private boolean collision() {
		return game.racquet.getBounds().intersects(getBounds());
	}

	public void paint(Graphics2D g) {
		g.fillOval(x, y, 30, 30);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, DIAMETER, DIAMETER);
	}
}
