package com.shapes;

public abstract class TwoDimensionalShapes extends Shapes{
	protected double area;
	
	public double getArea() {
		return this.area;
	}
	
	protected abstract void calcArea();
	
	public String toString() {
		return "2D Shape"; 
	}
}
