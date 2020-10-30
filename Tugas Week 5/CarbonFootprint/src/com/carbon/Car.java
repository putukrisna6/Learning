package com.carbon;

public class Car implements CarbonFootprint{
	private double distanceTravelled;
	private double fuelEfficiency;
	private double direct;
	private double indirect;
	
	public Car(double distanceTravelled, double fuelEfficiency) {
		checkVal(fuelEfficiency);
		checkVal(distanceTravelled);
		
		this.distanceTravelled = distanceTravelled;
		this.fuelEfficiency = fuelEfficiency;
		
		this.direct = 8.78 / this.fuelEfficiency;
		this.indirect = 1.55 / this.fuelEfficiency;
	}
	
	public double getDistanceTravelled() {
		return distanceTravelled;
	}
	public void setDistanceTravelled(double distanceTravelled) {
		checkVal(distanceTravelled);
		this.distanceTravelled = distanceTravelled;
	}
	public double getFuelEfficiency() {
		return fuelEfficiency;
	}
	public void setFuelEfficiency(double fuelEfficiency) {
		checkVal(fuelEfficiency);
		this.fuelEfficiency = fuelEfficiency;
	}

	@Override
	public double getCarbonFootprint() {
		//figures obtained from http://shrinkthatfootprint.com/calculate-your-carbon-footprint
		return (this.distanceTravelled * this.direct) + 
				(this.distanceTravelled * this.indirect) + (this.distanceTravelled * 0.06);
	}
	@Override
	public String toString() {
		return String.format("%s%n%s%n%s: %.2f %s%n%s: %.2f %s%n%s: %.2f %s%n", 
				"Car Annual Carbon Footprint",
				"--------------------------------",
				"Mileage", this.distanceTravelled, "miles",
				"Efficiency", this.fuelEfficiency, "MPG",
				"Carbon Footprint", getCarbonFootprint(), "kg CO2e/yr");
	}
	
	private void checkVal(double val) {
		if (val < 0.0) {
			throw new IllegalArgumentException("value can't be a negative number");
		}
	}
}
