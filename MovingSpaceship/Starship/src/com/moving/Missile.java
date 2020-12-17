package com.moving;

public class Missile extends Sprite {
	private final int BOARD_WIDTH = 390;
	private final int MISSILE_SPEED = 3;
	
	private void initMissile() {
		loadImage("src/resources/missile.png");
		getImageDimensions();
	}
	
	public Missile(int x, int y) {
		super(x, y);
		initMissile();
	}
	public void move() {
		x += MISSILE_SPEED;
		
		System.out.println("missile x, y: " + x + " " + y);
		
		if (x > BOARD_WIDTH)
			visible = false;
	}
}
