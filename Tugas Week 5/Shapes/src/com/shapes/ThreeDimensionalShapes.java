package com.shapes;

public abstract class ThreeDimensionalShapes extends Shapes{
	protected double area;
	protected double volume;
	
	public double getArea() {
		return area;
	}
	public double getVolume() {
		return volume;
	}
	
	protected abstract void calcArea();
	protected abstract void calcVolume();
	
	public String toString() {
		return "3D Shape"; 
	}
}
