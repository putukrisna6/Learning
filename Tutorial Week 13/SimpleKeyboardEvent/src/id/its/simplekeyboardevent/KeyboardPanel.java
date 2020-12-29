package id.its.simplekeyboardevent;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class KeyboardPanel extends JPanel implements KeyListener{
	private List<Key> keys;
	private Spacebar spacebar;
	
	public KeyboardPanel(int width, int height) {
		this.setPreferredSize(
					new Dimension(width, height)
				);
		this.keys = new ArrayList<Key>();
		
		this.keys.add(new Key(10, 10, '1'));
		this.keys.add(new Key(70, 10, '2'));
		this.keys.add(new Key(130, 10, '3'));
		this.keys.add(new Key(190, 10, '4'));
		this.keys.add(new Key(250, 10, '5'));
		this.keys.add(new Key(310, 10, '6'));
		this.keys.add(new Key(370, 10, '7'));
		this.keys.add(new Key(430, 10, '8'));
		this.keys.add(new Key(490, 10, '9'));
		this.keys.add(new Key(550, 10, '0'));
		
		this.keys.add(new Key(30, 70, 'q'));
		this.keys.add(new Key(90, 70, 'w'));
		this.keys.add(new Key(150, 70, 'e'));
		this.keys.add(new Key(210, 70, 'r'));
		this.keys.add(new Key(270, 70, 't'));
		this.keys.add(new Key(330, 70, 'y'));
		this.keys.add(new Key(390, 70, 'u'));
		this.keys.add(new Key(450, 70, 'i'));
		this.keys.add(new Key(510, 70, 'o'));
		this.keys.add(new Key(570, 70, 'p'));

		this.keys.add(new Key(50, 130, 'a'));
		this.keys.add(new Key(110, 130, 's'));
		this.keys.add(new Key(170, 130, 'd'));
		this.keys.add(new Key(230, 130, 'f'));
		this.keys.add(new Key(290, 130, 'g'));
		this.keys.add(new Key(350, 130, 'h'));
		this.keys.add(new Key(410, 130, 'j'));
		this.keys.add(new Key(470, 130, 'k'));
		this.keys.add(new Key(530, 130, 'l'));
		
		this.keys.add(new Key(70, 190, 'z'));
		this.keys.add(new Key(130, 190, 'x'));
		this.keys.add(new Key(190, 190, 'c'));
		this.keys.add(new Key(250, 190, 'v'));
		this.keys.add(new Key(310, 190, 'b'));
		this.keys.add(new Key(370, 190, 'n'));
		this.keys.add(new Key(430, 190, 'm'));
		
		this.spacebar = new Spacebar(100, 250);
		
		this.addKeyListener(this);
		this.setFocusable(true);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for (Key key : keys) {
			key.render(g);
		}
		spacebar.render(g);
	}

	@Override
	public void keyTyped(KeyEvent e) {	}
	@Override
	public void keyPressed(KeyEvent e) {
		char key = e.getKeyChar();
		
		for (Key k : keys) {
			if (k.isSymbolMatch(key)) {
				k.setPressed();
				repaint();
			}
		}
		
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			spacebar.setPressed();
			repaint();
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		char key = e.getKeyChar();
		
		for (Key k : keys) {
			if (k.isSymbolMatch(key)) {
				k.setReleased();
				repaint();
			}
		}
		
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			spacebar.setReleased();
			repaint();
		}
	}
}
