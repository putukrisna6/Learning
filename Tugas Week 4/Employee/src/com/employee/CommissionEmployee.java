package com.employee;

public class CommissionEmployee extends Employee{
	private double grossSales;
	private double commissionRate;
	
	public CommissionEmployee(String firstName, String lastName, 
			String socialSecurityNumber, double grossSales, double commissionRate) {
		super(firstName, lastName, socialSecurityNumber);
		
		checkGrossSales(grossSales);
		checkCommissionRate(commissionRate);
		
		this.grossSales = grossSales;
		this.commissionRate = commissionRate;
	}
	
	public double getGrossSales() {
		return grossSales;
	}
	public void setGrossSales(double grossSales) {
		checkGrossSales(grossSales);
		this.grossSales = grossSales;
	}
	public double getCommissionRate() {
		return commissionRate;
	}
	public void setCommissionRate(double commissionRate) {
		checkCommissionRate(commissionRate);
		this.commissionRate = commissionRate;
	}
	
	private void checkGrossSales(double grossSales) {
		if (grossSales < 0.0) {
			throw new IllegalArgumentException(
					"Gross sales must >= 0.0");
		}
	}
	private void checkCommissionRate(double commissionRate) {
		if (commissionRate <= 0.0 || commissionRate >= 1.0) {
			throw new IllegalArgumentException(
					"Commission rate must be between 0.0 and 1.0");
		}
	}

	public double getEarnings() {
		return getCommissionRate() * getGrossSales();
	}
	public String toString() {
		return String.format("%s %s%n%s: %.2f%n%s: %.2f%n%s: %.2f", "Commission",
				super.toString(), "Gross Sales", getGrossSales(),
				"Commission Rate", getCommissionRate(), 
				"Earnings", getEarnings());
	}
}
