package com.Main;

import com.Employee.*;

public class Main {

	public static void main(String[] args) {
		Employee[] myEmployees = {
				new SalariedEmployee("Joni", "Somito", "111-11-1111", 800.00),
				new HourlyEmployee("Karen", "Price", "222-22-2222", 16.75, 40),
				new CommissionEmployee( "Sue", "Jones", "333-33-3333", 10000, .06),
				new BasePlusCommissionEmployee( "Bob", "Lewis", "444-44-4444", 5000, .04, 300),
				new PieceWorker("Boedi", "Tjiptodjojo", "123-45-6789", 1.23, 500)
				};
		
		for (Employee e : myEmployees) {
			System.out.println(e);
			System.out.println("-------------------------------------------------------------------");
		}
		
		for (Employee e : myEmployees) {
			System.out.println(e.getClass().getName());
		}
	}

}
