package com.quadrilateral;
import java.text.DecimalFormat;

public class Rectangle extends Quadrilateral{
	private double width;
	private double height;
	
	public Rectangle(double x0, double y0, double x1, double y1, 
			double x2, double y2, double x3, double y3) {
		super(x0, y0, x1, y1, x2, y2, x3, y3);
		
		this.width = Math.sqrt(Math.pow((getP2().getX() - getP1().getX()), 2)
	               + Math.pow((getP2().getY() - getP1().getY()), 2));
		this.height = Math.sqrt(Math.pow((getP4().getX() - getP1().getX()), 2)
	               + Math.pow((getP4().getY() - getP1().getY()), 2));
	}
	
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}

	public double getArea() {
		return this.width * this.height;
	}
	public String toString() {
		DecimalFormat df = new DecimalFormat(".0");
	              
		return "\nCoordinates of the rectangle are:\n" + super.toString()
	               + "\nWidth is :" + df.format(width) + "\nHeight is :" + df.format(height)
	               + "\nArea is :" + df.format(getArea());
	}
}
