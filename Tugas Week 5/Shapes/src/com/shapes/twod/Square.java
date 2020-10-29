package com.shapes.twod;

import com.shapes.TwoDimensionalShapes;

public class Square extends TwoDimensionalShapes{
	private double side;
	
	public Square(double side) {
		checkSide(side);
		this.side = side;
		calcArea();
	}
	
	public double getSide() {
		return side;
	}
	public void setSide(double side) {
		checkSide(side);
		this.side = side;
	}

	@Override
	protected void calcArea() {
		super.area = this.side * this.side;
	}
	public String toString() {
		return String.format("%s%s%n%s%.2f%n%s%.2f%n", 
				super.toString(), " - Square", "Sides: ", this.side, "Area: ", super.area);
	}
	
	private void checkSide(double side) {
		if (side <= 0) {
			throw new IllegalArgumentException("Side should be > 0");
		}
	}
}
