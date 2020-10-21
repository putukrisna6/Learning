package com.employee;

public class HourlyEmployee extends Employee{
	private double hours;
	private double wage;
	

	public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber, double hours, double wage) {
		super(firstName, lastName, socialSecurityNumber);
		
		checkHours(hours);
		checkWage(wage);
		
		this.hours = hours;
		this.wage = wage;
	}
	
	public double getHours() {
		return hours;
	}
	public double getWage() {
		return wage;
	}
	public void setHours(double hours) {
		checkHours(hours);
		this.hours = hours;
	}
	public void setWage(double wage) {
		checkWage(wage);
		this.wage = wage;
	}
	
	//TODO getEarnings -> hours * wage and 1.5 hours if over 40 hours
	public double getEarnings() {
		if (this.hours > 40.0) {
			return (40.0 * this.wage) + ((this.hours - 40.0) * this.wage * 1.5);
		}
		return this.hours * this.wage;
	}
	public String toString() {
		return String.format("%s %s%n%s: %.2f%n%s: %.2f%n%s: %.2f", "Hourly",
				super.toString(), "Hours", getHours(),
				"Wage", getWage(), 
				"Earnings", getEarnings());
	}
	
	private void checkHours(double hours) {
		if (hours <= 0.0 || hours >= 168.0) {
			throw new IllegalArgumentException(
					"Hours worked must be between 0.0 and 168.0");
		}
	}
	private void checkWage(double wage) {
		if (wage < 0.0) {
			throw new IllegalArgumentException(
					"Wage must not be a negative value");
		}
	}
}
