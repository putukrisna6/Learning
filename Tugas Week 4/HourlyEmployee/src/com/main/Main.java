package com.main;
import com.employee.*;

public class Main {

	public static void main(String[] args) {
		HourlyEmployee myHour = new HourlyEmployee("Jill", "Cook", "123-90-000", 60.0, 3.0);
		System.out.println(myHour.toString());
	}

}
