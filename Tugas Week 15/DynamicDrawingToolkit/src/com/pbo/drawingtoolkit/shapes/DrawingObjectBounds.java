package com.pbo.drawingtoolkit.shapes;

import java.awt.Color;

public abstract class DrawingObjectBounds extends DrawingObject {
	
	public DrawingObjectBounds() {
		super();
	}
	public DrawingObjectBounds(
				int x1, int y1,
				int x2, int y2,
				Color color,
				boolean fill
			) {
		super(x1, y1, x2, y2, color);
	}
	public DrawingObjectBounds(DrawingObjectBounds source) {
		super(source);
	}
	
	public int getUpperLeftX() {
		return Math.min(getX1(), getX2());
	}
	public int getUpperLeftY() {
		return Math.min(getY1(), getY2());
	}
	
}
