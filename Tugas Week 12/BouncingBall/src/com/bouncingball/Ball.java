package com.bouncingball;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {
//	Attributes that keep track of the ball's location
	private float x;
	private float y;
//	Attributes that dictate the ball's speed
	private float speedX;
	private float speedY;
//	Attributes that dictate how the ball looks
	private float radius;
	private Color color;
	
	public Ball(
				float x, float y,
				float radius, float speed,
				float angleInDegree, Color color
			) {
		this.x = x;
		this.y = y;
		
		this.speedX = (float)(speed * Math.cos(Math.toRadians(angleInDegree)));
		this.speedY = (float)(-speed * (float)Math.sin(Math.toRadians(angleInDegree)));
		
		this.radius = radius;
		this.color = color;
	}
	
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(
					(int)(x - radius), 
					(int)(y - radius), 
					(int)(2 * radius), 
					(int)(2 * radius)
				);
	}
	public void collide(BallArea box) {
		float ballMinX = box.minX + radius;
		float ballMinY = box.minY + radius;
		float ballMaxX = box.maxX - radius;
		float ballMaxY = box.maxY - radius;
		
		x += speedX;
		y += speedY;
		
		if (x < ballMinX) {
			speedX = -speedX;
			x = ballMinX;
		} 
		else if (x > ballMaxX) {
			speedX = -speedX;
			x = ballMaxX;
		}
		
		if (y < ballMinY) {
			speedY = -speedY;
			y = ballMinY;
		} 
		else if (y > ballMaxY) {
			speedY = -speedY;
			y = ballMaxY;
		}
	}
}
