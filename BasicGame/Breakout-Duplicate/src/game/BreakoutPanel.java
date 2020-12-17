package game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import gameState.GameStateManager;

@SuppressWarnings("serial")
public class BreakoutPanel extends JPanel implements KeyListener, Runnable {
	
	private GameStateManager gsm;
	
	private BufferedImage image;
	private Graphics2D g2d;
	
	private boolean running;
	
	public BreakoutPanel() {
		super();
		setFocusable(true);
		setPreferredSize(
					new Dimension(
							Commons.WIDTH, 
							Commons.HEIGHT)
					);
		requestFocus();
		
	}
	
	private void init() {
		image = new BufferedImage(
					Commons.WIDTH, Commons.HEIGHT, 
					BufferedImage.TYPE_INT_RGB
				);
		g2d = (Graphics2D) image.getGraphics();
		
		running = true;
		
		gsm = new GameStateManager();
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyPressed(KeyEvent e) {
		gsm.keyPressed(e.getKeyCode());
	}
	@Override
	public void keyReleased(KeyEvent e) {
		gsm.keyReleased(e.getKeyCode());
	}
	@Override
	public void run() {
		init();
		System.out.println("wack");
		while(running) {
			update();
			draw();
			drawToScreen();
		}
	}
	
	private void update() {
		gsm.update();
	}
	private void draw() {
		System.out.println("draw");
		gsm.draw(g2d);
	}
	private void drawToScreen() {
		Graphics g2 = getGraphics();
		g2.drawImage(image, 0, 0, Commons.WIDTH, Commons.HEIGHT, null);
		g2.dispose();
	}
	
}
