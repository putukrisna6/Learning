package com.main;
import com.quadrilateral.*;

public class Main {

	public static void main(String[] args) {
		Parallelogram parallelogram = new Parallelogram(5.0, 5.0, 11.0, 5.0, 12.0, 20.0, 6.0, 20.0);
		Rectangle rectangle = new Rectangle(17.0, 14.0, 30.0, 14.0, 30.0, 28.0, 17.0, 28.0);
		Square square = new Square(4.0, 0.0, 8.0, 0.0, 8.0, 4.0, 4.0, 4.0);
		Trapezoid trapezoid = new Trapezoid(-6.0, 0, -2.0, 2.0, 2.0, 2.0, 6.0, 0.0);
		
		System.out.printf("%s%n%s%n%s%n%s%n", parallelogram, rectangle, square, trapezoid);
	}

}
