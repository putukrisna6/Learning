package com.carbon;

public class Bicycle implements CarbonFootprint{
	private double distanceTravelled;
	
	public Bicycle(double distance) {
		checkVal(distance);
		this.distanceTravelled = distance;
	}
		
	public double getDistanceTravelled() {
		return distanceTravelled;
	}
	public void setDistanceTravelled(double distanceTravelled) {
		checkVal(distanceTravelled);
		this.distanceTravelled = distanceTravelled;
	}

	@Override
	public double getCarbonFootprint() {
		return (this.distanceTravelled * 0.005) + (this.distanceTravelled * 0.021);
	}
	@Override
	public String toString() {
		return String.format("%s%n%s%n%s: %.2f %s%n%s: %.2f %s%n", 
				"Bicycle Annual Carbon Footprint",
				"--------------------------------",
				"Mileage", this.distanceTravelled, "km",
				"Carbon Footprint", getCarbonFootprint(), "kg CO2e/yr");
	}
	
	private void checkVal(double val) {
		if (val < 0.0) {
			throw new IllegalArgumentException("value can't be a negative number");
		}
	}
}
