package com.employee;

public class BasePlusCommissionEmployee extends CommissionEmployee{
	private double baseSalary;
	
	public BasePlusCommissionEmployee(String firstName, String lastName, 
			String socialSecurityNumber, double grossSales, 
			double commissionRate, double baseSalary) {
		super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate);
		
		checkBaseSalary(baseSalary);
		
		this.baseSalary = baseSalary;
	}
	
	public double getBaseSalary() {
		return baseSalary;
	}
	public void setBaseSalary(double baseSalary) {
		checkBaseSalary(baseSalary);
		this.baseSalary = baseSalary;
	}

	public double getEarnings() {
		return getBaseSalary() + super.getEarnings();
	}
	public String toString() {
		return String.format("%s %s%n%s: %.2f", 
				"Base-Salaried", super.toString(),
				"Base Salary", getBaseSalary());
	}
	
	private void checkBaseSalary(double baseSalary) {
		if (baseSalary < 0.0) {
			throw new IllegalArgumentException(
					"Base salary can't be negative");
		}
	}
}
