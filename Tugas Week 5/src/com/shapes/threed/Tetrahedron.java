package com.shapes.threed;

import java.lang.Math;
import com.shapes.ThreeDimensionalShapes;

public class Tetrahedron extends ThreeDimensionalShapes{
	private double side;
	
	public Tetrahedron(double side) {
		checkSide(side);
		this.side = side;
		calcArea();
		calcVolume();
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
		super.area = Math.sqrt(3) * this.side * this.side;
	}
	@Override
	protected void calcVolume() {
		super.volume = (Math.sqrt(2) / 12) * this.side * this.side * this.side;
	}
	@Override
	public String toString() {
		return String.format("%s%s%n%s%.2f%n%s%.2f%n%s%.2f%n", 
				super.toString(), " - Tetrahedron", "Side: ", this.side, "Area: ", super.area, "Volume: ", super.volume);
	}
	
	private void checkSide(double side) {
		if (side <= 0) {
			throw new IllegalArgumentException("Side should be > 0");
		}
	}
}
