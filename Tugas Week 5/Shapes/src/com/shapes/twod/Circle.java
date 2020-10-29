package com.shapes.twod;

import java.lang.Math;
import com.shapes.TwoDimensionalShapes;

public class Circle extends TwoDimensionalShapes{
	private double radius;
	
	public Circle(double radius) {
		checkRadius(radius);
		this.radius = radius;
		calcArea();
	}

	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		checkRadius(radius);
		this.radius = radius;
	}

	@Override
	protected void calcArea() {
		super.area = Math.PI * this.radius * this.radius;
	}
	public String toString() {
		return String.format("%s%s%n%s%.2f%n%s%.2f%n", 
				super.toString(), " - Circle", "Radius: ", this.radius, "Area: ", super.area);
	}
	
	private void checkRadius(double radius) {
		if (radius <= 0) {
			throw new IllegalArgumentException("Radius should be > 0");
		}
	}
}
