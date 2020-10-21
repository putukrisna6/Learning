package com.main;
import com.employee.*;

public class Main {

	public static void main(String[] args) {		
		Employee[] employees = { 
				new Employee("John", "Doe", "144-12-412"), 
				new CommissionEmployee("Jane", "Smith", "142-123-111", 9.6, 0.5), 
				new BasePlusCommissionEmployee("Richard", "Baker", "111-11-111", 123.0, 0.3, 100)
				};
		
		displayInfo(employees);
	}
	
	public static void displayInfo(Employee[] employees) {
		for (Employee e : employees) {
			System.out.println(e.toString());
			System.out.println();
		}
	}
}
