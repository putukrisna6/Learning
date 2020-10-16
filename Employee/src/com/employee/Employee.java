package com.employee;

public class Employee {
	//Attribute
	private String firstName;
	private String lastName;
	private double monthlyPay;
	
	//Checkers
	private double checkMonthlyPay(double monthlyPay) {
		return (monthlyPay < 0.0F) ? this.monthlyPay : monthlyPay;
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
	public void setFirstName(String newFirstName) {
		this.firstName = newFirstName;
	}
	public void setLastName(String newLastName) {
		this.lastName = newLastName;
	}
	
	//Getters
	public double getMonthlyPay() {
		return this.monthlyPay;
	}
	public String getFirstName() {
		return this.firstName;
	}
	public String getLastName() {
		return this.lastName;
	}
	
	//Method
	public void displayEmployeeSalary() {
		System.out.println("Employee: " + this.firstName + " " + this.lastName);
		System.out.println("Monthly Salary: " + this.monthlyPay);
	}
}
