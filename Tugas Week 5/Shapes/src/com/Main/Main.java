package com.Main;

import com.shapes.Shapes;
import com.shapes.threed.*;
import com.shapes.twod.*;

public class Main {

	public static void main(String[] args) {
		Shapes[] myShapes = {
				new Circle(10.0), new Square(5.0), new Triangle(3.0, 4.0, 5.0),
				new Sphere(4.0), new Cube(6.0), new Tetrahedron(3.0)
				};
		
		for (Shapes s : myShapes) {
			System.out.println(s.toString());
		}
	}

}
