package com.quadrilateral;
import java.text.DecimalFormat;

public class Trapezoid extends Quadrilateral{
	private double height;
	private double sum;

	public Trapezoid(double x0, double y0, double x1, double y1, double x2, double y2, double x3, double y3) {
		super(x0, y0, x1, y1, x2, y2, x3, y3);
		
		this.height = calcHeight();
		this.sum = calcSum();
	}
	
	private double calcHeight() {
		if (getP1().getY() == getP2().getY()) {
			return Math.abs(getP2().getY() - getP3().getY());
		}
		return Math.abs(getP1().getY() - getP2().getY());
	}
	private double calcSum() {
		if (getP1().getY() == getP2().getY()) {
			return Math.abs(getP1().getX() - getP2().getX()) + 
					Math.abs(getP3().getX() - getP4().getX());
		}
		return Math.abs(getP2().getX() - getP3().getX()) + 
				Math.abs(getP4().getX() - getP1().getX());
	}
	public double getArea() {
		return this.sum * this.height / 2;
	}
	
	public String toString() {
		DecimalFormat df = new DecimalFormat(".0");
		return "\nCoordinates of the trapezoid are:\n" + super.toString() 
			+ "\nSum is :" + df.format(sum) + "\nHeight is :" + df.format(height) 
			+ "\nArea is :" + df.format(getArea());
	}
}
