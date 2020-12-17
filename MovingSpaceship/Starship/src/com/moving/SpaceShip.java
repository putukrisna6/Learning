package com.moving;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class SpaceShip extends Sprite{
	private int dx;
	private int dy;
	private List<Missile> missiles;
	
	protected static final int IMGHEIGHT = 30;
	protected static final int IMGWIDTH = 30;
	
	private void initSpaceShip() {
		missiles = new ArrayList<>();
		
		loadImage("src/resources/spaceship.png");
		getImageDimensions();
	}
	
	public SpaceShip(int x, int y) {
		super(x, y);
		initSpaceShip();
	}
	
	public List<Missile> getMissiles() {
		return missiles;
	}
	public void move() {
		if (x + dx > 0 && x + dx < MovingSpriteEx.WIDTH-IMGWIDTH-20) {
			if (y + dy > 0 && y + dy < MovingSpriteEx.HEIGHT-IMGHEIGHT-37) {
				x += dx;
				y += dy;
			}
		}	
	}
	public void fire() {
		missiles.add(new Missile(x + IMGWIDTH, y + IMGHEIGHT / 2 - 6));
	}
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_SPACE) {
			fire();
		}
		
		if (key == KeyEvent.VK_LEFT) {
			dx = -2;
		}
		if (key == KeyEvent.VK_RIGHT) {
            dx = 2;
        }
        if (key == KeyEvent.VK_UP) {
            dy = -2;
        }
        if (key == KeyEvent.VK_DOWN) {
            dy = 2;
        }
	}
	public void keyReleased(KeyEvent e) {     
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }
        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }
        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }
        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
//        System.out.println("x, y: " + x + " " + y);
    }
	
}
