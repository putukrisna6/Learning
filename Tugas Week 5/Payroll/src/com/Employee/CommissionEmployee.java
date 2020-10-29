package com.Employee;

public class CommissionEmployee extends Employee{
	private double grossSales;
	private double commissionRate;
	
	public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales, double commissionRate) {
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

	@Override
	public double earnings() {
		return getCommissionRate() * getGrossSales();
	}
	@Override
	public String toString() {
	return String.format("%s: %s%n%s: $%,.2f; %s: %.2f", 
			"commission employee", super.toString(), "gross sales", 
			getGrossSales(), "commission rate", getCommissionRate());
	}
	
	private void checkGrossSales(double grossSales) {
		if (grossSales < 0.0) {
			throw new IllegalArgumentException("Gross sales must be >= 0.0");
		}
	}
	private void checkCommissionRate(double commissionRate) {
		if (commissionRate <= 0.0 || commissionRate >= 1.0) {
			throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
		}
	}
}
