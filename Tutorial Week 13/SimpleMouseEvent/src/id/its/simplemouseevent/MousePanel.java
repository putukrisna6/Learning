package id.its.simplemouseevent;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MousePanel extends JPanel implements MouseListener, MouseMotionListener {
	
	private int areaWidth;
	private int areaHeight;
	private String text;
	private String motionText;
	
	public MousePanel(int width, int height) {
		this.areaWidth = width;
		this.areaHeight = height;
	
		this.setPreferredSize(
					new Dimension(areaWidth, areaHeight)
				);
		
		this.text = "Lakukan sesuatu menggunakan mouse...";
		this.motionText = "Implements MouseMotionListener";
	
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.setFocusable(true);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawString(this.text, 0, this.areaHeight / 2);
		g.drawString(this.motionText, 0, 20);
	}

//	MouseListener
	@Override
	public void mouseClicked(MouseEvent e) {
		this.text = "Tombol mouse diklik pada posisi X: " + e.getX() + " Y: " + e.getY();
		repaint();
	}
	@Override
	public void mousePressed(MouseEvent e) {
		this.text = "Tombol mouse ditekan pada posisi X: " + e.getX() + " Y: " + e.getY();
		repaint();		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		this.text = "Tombol mouse dilepas pada posisi X: " + e.getX() + " Y: " + e.getY();
		repaint();		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		this.text = "Mouse memasuki area MousePanel";
		repaint();
	}
	@Override
	public void mouseExited(MouseEvent e) {
		this.text = "Mouse meninggalkan area MousePanel";
		repaint();
	}

//	MouseMotionListener
	@Override
	public void mouseDragged(MouseEvent e) {
		this.motionText = "Position X= " + e.getX() + " Y= " + e.getY() + " Dragged.";
		repaint();
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		this.motionText = "Position X= " + e.getX() + " Y= " + e.getY() + " Moved.";
		repaint();
	}
}
