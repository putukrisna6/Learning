package com.shapes.twod;

import java.lang.Math;
import com.shapes.TwoDimensionalShapes;

public class Triangle extends TwoDimensionalShapes{
	private double a;
	private double b;
	private double c;
	
	public Triangle(double a, double b, double c) {
		checkSide(a);
		checkSide(b);
		checkSide(c);
		this.a = a;
		this.b = b;
		this.c = c;
		calcArea();
	}
	
	public double getA() {
		return a;
	}
	public void setA(double a) {
		checkSide(a);
		this.a = a;
	}
	public double getB() {
		return b;
	}
	public void setB(double b) {
		checkSide(b);
		this.b = b;
	}
	public double getC() {
		return c;
	}
	public void setC(double c) {
		checkSide(c);
		this.c = c;
	}

	@Override
	protected void calcArea() {
		double s = (this.a + this.b + this.c) / 2;
		super.area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
	}
	public String toString() {
		return String.format("%s%s%n%s%.2f%n%s%.2f%n%s%.2f%n%s%.2f%n", 
				super.toString(), " - Triangle", "Side A: ", this.a, "Side B: ", this.b, "Side C: ", this.c, "Area: ", super.area);
	}
	
	private void checkSide(double s) {
		if (s <= 0) {
			throw new IllegalArgumentException("Side length should be > 0");
		}
	}
}
