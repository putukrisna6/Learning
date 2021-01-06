package com.pbo.drawingtoolkit.shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;

public abstract class DrawingObject {
	
//	Coordinates of the shape
	private int x1;
	private int y1;
	private int x2;
	private int y2;
//	Shape color
	private Color color;
	
	public boolean isSelected = false;
	public boolean reverse = false;
	
	final static float dash1[] = { 10.0f };
	final static BasicStroke dashed = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash1, 0.0f);
	
	public DrawingObject() {
		x1 = 0;
		y1 = 0;
		x2 = 0;
		y2 = 0;
		color = Color.BLACK;
	}
	public DrawingObject(
					int x1, int y1, 
					int x2, int y2, 
					Color color
				) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.color = color;
	}
	public DrawingObject(DrawingObject source) {
		this.x1 = source.x1;
		this.y1 = source.y1;
		this.x2 = source.x2;
		this.y2 = source.y2;
		this.color = source.color;
		this.isSelected = source.isSelected;
	}

	public int getX1() {
		return x1;
	}
	public void setX1(int x1) {
		this.x1 = x1;
	}
	public int getY1() {
		return y1;
	}
	public void setY1(int y1) {
		this.y1 = y1;
	}
	public int getX2() {
		return x2;
	}
	public void setX2(int x2) {
		this.x2 = x2;
	}
	public int getY2() {
		return y2;
	}
	public void setY2(int y2) {
		this.y2 = y2;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}

	public void draw(Graphics g) {
		if (isSelected) {
			Graphics2D g2d = (Graphics2D) g;
			
			int x, y;
			
			if (x1 < x2) {
				x = x1;
			}
			else {
				x = x2;
			}
			
			if (y1 < y2) {
				y = y1;
			}
			else {
				y = y2;
			}
			
			g2d.setPaint(Color.BLUE);
			g2d.setStroke(dashed);
			g2d.draw(new RoundRectangle2D.Double(x-2, y-2, getWidth()+4, getHeight()+4, 10, 10));
			
			g2d.setStroke( new BasicStroke( 1.0f ));
			g2d.setPaint(Color.BLACK);
		}
		
	}
	
	public int getWidth() {
		return Math.abs(getX1()-getX2());
	}
	public int getHeight() {
		return Math.abs(getY1()-getY2());
	}
}
