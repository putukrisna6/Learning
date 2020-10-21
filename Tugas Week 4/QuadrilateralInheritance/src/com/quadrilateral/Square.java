package com.quadrilateral;
import java.text.DecimalFormat;

public class Square extends Quadrilateral{
	private double side;
	
	public Square(double x0, double y0, double x1, double y1, 
			double x2, double y2, double x3, double y3) {
		super(x0, y0, x1, y1, x2, y2, x3, y3);
		
		this.side = Math.sqrt(Math.pow((getP2().getX() - getP1().getX()), 2)
	               + Math.pow((getP2().getY() - getP1().getY()), 2));
	}
	
	public double getSide() {
		return side;
	}
	public void setSide(double side) {
		this.side = side;
	}

	public double getArea() {
		return this.side * this.side;
	}
	public String toString() {
		DecimalFormat df = new DecimalFormat(".0");
		return "\nCoordinates of The square are:\n" + super.toString() 
			+ "\nSide is :" + df.format(side)+"\nArea is :" + df.format(getArea());
	}
}
