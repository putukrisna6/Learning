package com.pbo.drawingtoolkit.shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends DrawingObjectBounds {
	
	private int circleWidth;
	private int circleHeight;
	
	public Circle() {
		super();
	}
	public Circle(
				int x1, int y1,
				int x2, int y2,
				Color color,
				boolean fill
			) {
		super(x1, y1, x2, y2, color, fill);
	}
	public Circle(Circle source) {
		super(source);
	}
	
	@Override
	public void draw(Graphics g) {
		circleWidth = getWidth();
		circleHeight = getHeight();
		
		g.drawOval(
					getUpperLeftX(), 
					getUpperLeftY(), 
					circleWidth, 
					circleHeight
				);
		
		super.draw(g);
	}
 
}
