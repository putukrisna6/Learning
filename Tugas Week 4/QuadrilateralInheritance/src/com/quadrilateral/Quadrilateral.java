package com.quadrilateral;

public class Quadrilateral {
	private Points[] edgeCoords = new Points[4];
	
	public Quadrilateral(double x0, double y0, double x1, double y1, double x2, double y2, double x3, double y3) {
		edgeCoords[0].setPoints(x0, y0);
		edgeCoords[0].setPoints(x1, y1);
		edgeCoords[0].setPoints(x2, y2);
		edgeCoords[0].setPoints(x3, y3);
	}
	public void calculateArea() {}
}
