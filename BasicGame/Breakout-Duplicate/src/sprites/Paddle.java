package sprites;

import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import game.Commons;

public class Paddle extends Sprite{
	private int dx;
	private int moveSpeedLeft = -1;
	private int moveSpeedRight = 1;
	
	protected void loadImage() {
		ImageIcon ii = new ImageIcon("Resources/paddle.png");
		image = ii.getImage();
	}
	private void resetState() {
		x = Commons.INIT_PADDLE_X;
		y = Commons.INIT_PADDLE_Y;
	}
	
	public Paddle() {
		super();
		
		resetState();
	}
	public void move() {
		x += dx;
		
		if (x <= 0) {
			x = 0;
		}
		if (x >= Commons.WIDTH - getImageWidth()) {
			x = Commons.WIDTH - getImageWidth();
		}
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_LEFT) {
			dx = moveSpeedLeft;
		}
		else if (key == KeyEvent.VK_RIGHT) {
			dx = moveSpeedRight;
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
    }
	
	public void setMoveSpeedLeft(int moveSpeedLeft) {
		this.moveSpeedLeft = moveSpeedLeft;
	}
	public void setMoveSpeedRight(int moveSpeedRight) {
		this.moveSpeedRight = moveSpeedRight;
	}
}
