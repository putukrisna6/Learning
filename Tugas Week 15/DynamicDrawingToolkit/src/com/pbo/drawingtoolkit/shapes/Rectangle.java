package com.pbo.drawingtoolkit.shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends DrawingObjectBounds{
	
	private int rectangleWidth;
	private int rectangleHeight;
	
	public Rectangle() {
		super();
	}
	public Rectangle(
				int x1, int y1,
				int x2, int y2,
				Color color,
				boolean fill
			) {
		super(x1, y1, x2, y2, color, fill);
	}
	
	@Override
	public void draw(Graphics g) {
		rectangleWidth = getWidth();
		rectangleHeight = getHeight();
		
		g.drawRect(
					getUpperLeftX(), 
					getUpperLeftY(), 
					rectangleWidth, 
					rectangleHeight
				);
	}
	
}
