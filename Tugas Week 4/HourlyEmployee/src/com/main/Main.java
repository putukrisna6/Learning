package com.main;
import com.employee.*;

public class Main {

	public static void main(String[] args) {
		HourlyEmployee hEmpl = new HourlyEmployee("Jill", "Cook", "123-90-000", 60.0, 3.0);
		
		//get hourly employee data;
		System.out.println("Information obtained by get methods: ");
		System.out.printf("%n%s %s%n", "First name is", hEmpl.getFirstName());
		System.out.printf("%s %s%n", "Last name is", hEmpl.getLastName());
		System.out.printf("%s %s%n", "SSN is", hEmpl.getSocialSecurityNumber());
		System.out.printf("%s %s%n", "Hourly wage is", hEmpl.getWage());
		System.out.printf("%s %s%n", "Hours worked is", hEmpl.getHours());

		//modify
		hEmpl.setHours(120.0);
		hEmpl.setWage(24);
		
		//get data from toString()
		System.out.println("\nInformation obtained by toString() method\n");
		System.out.println(hEmpl.toString());
	}

}
