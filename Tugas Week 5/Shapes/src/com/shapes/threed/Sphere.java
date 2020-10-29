package com.shapes.threed;

import java.lang.Math;
import com.shapes.ThreeDimensionalShapes;

public class Sphere extends ThreeDimensionalShapes{
	private double radius;
	
	public Sphere(double radius) {
		checkRadius(radius);
		this.radius = radius;
		calcArea();
		calcVolume();
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
		super.area = 4 * Math.PI * this.radius * this.radius;
	}
	@Override
	protected void calcVolume() {
		super.volume = (4 / 3) * Math.PI * this.radius * this.radius * this.radius;
	}

	public String toString() {
		return String.format("%s%s%n%s%.2f%n%s%.2f%n%s%.2f%n", 
				super.toString(), " - Sphere", "Radius: ", this.radius, "Area: ", super.area, "Volume: ", super.volume);
	}
	
	private void checkRadius(double radius) {
		if (radius <= 0) {
			throw new IllegalArgumentException("Radius should be > 0");
		}
	}
}
