package com.main;

import java.util.ArrayList;
import com.carbon.*;

public class Main {

	public static void main(String[] args) {
		Building building = new Building(100, 100, 100, 100, 10, 1);
		Car car = new Car(100, 25);
		Bicycle bike = new Bicycle(100);
		
		ArrayList<CarbonFootprint> list = new ArrayList<CarbonFootprint>();  
		
		list.add(building);
		list.add(car);
		list.add(bike);
		
		for (CarbonFootprint c : list) {
			System.out.print(c.getClass().getName().substring(11) + "'s ");
			System.out.println("Carbon Footprint: " + c.getCarbonFootprint());
		}
		System.out.println();
		
		for (CarbonFootprint c : list) {
			System.out.println(c.toString());
		}
	}

}
