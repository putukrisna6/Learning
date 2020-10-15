package com.employee;

public class Employee {
	//Attribute
	private String firstName;
	private String lastName;
	private double monthlyPay;
	
	//Checkers
	private double checkMonthlyPay(double monthlyPay) {
		return (monthlyPay < 0.0F) ? 0.0F : monthlyPay;
	}
	
	//Constructor
	Employee(String firstName, String lastName, double monthlyPay) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.monthlyPay = checkMonthlyPay(monthlyPay);
	}
	
	//Setters
	public void setMonthlyPay(double newMonthlyPay) {
		this.monthlyPay = checkMonthlyPay(newMonthlyPay);
	}
	
	//Getters
	public double getMonthlyPay() {
		return this.monthlyPay;
	}
	
	//Method
	public void displayEmployeeSalary() {
		System.out.println("Employee: " + this.firstName + " " + this.lastName);
		System.out.println("Monthly Salary: " + this.monthlyPay);
	}
}
