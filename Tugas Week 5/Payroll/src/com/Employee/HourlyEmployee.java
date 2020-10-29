package com.Employee;

public class HourlyEmployee extends Employee{
	private double wage;
	private double hours;
	
	public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber, double wage, double hours) {
		super(firstName, lastName, socialSecurityNumber);
		checkHours(hours);
		checkWage(wage);
		
		this.hours = hours;
		this.wage = wage;
	}

	public double getWage() {
		return wage;
	}
	public void setWage(double wage) {
		checkWage(wage);
		this.wage = wage;
	}
	public double getHours() {
		return hours;
	}
	public void setHours(double hours) {
		checkHours(hours);
		this.hours = hours;
	}

	@Override
	public double earnings() {
		if (getHours() <= 40) return getWage() * getHours();
		else return 40 * getWage() + (getHours() - 40) * getWage() * 1.5;
	}
	@Override
	public String toString() {
		return String.format("hourly employee: %s%n%s: $%,.2f; %s: %,.2f", 
				super.toString(), "hourly wage", getWage(), "hours worked", getHours());
	}
	
	private void checkWage(double wage) {
		if (wage < 0.0) {
			throw new IllegalArgumentException("Hourly wage must be >= 0.0");
		}
	}
	private void checkHours(double hours) {
		if ((hours < 0.0) || (hours > 168.0)) { 
			throw new IllegalArgumentException("Hours worked must be >= 0.0 and <= 168.0");
		}
	}
}
