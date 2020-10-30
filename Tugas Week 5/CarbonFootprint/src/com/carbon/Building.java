package com.carbon;

public class Building implements CarbonFootprint{
	private double electricity;
	private double naturalGas;
	private double fuelOil;
	private double LPG;
	private double waste;
	private double water;
	
	public Building(double electricity, double naturalGas, double fuelOil,
			double LPG, double waste, double water) {
		checkVal(electricity);
		checkVal(naturalGas);
		checkVal(fuelOil);
		checkVal(LPG);
		checkVal(waste);
		checkVal(water);
		
		this.electricity = electricity;
		this.naturalGas = naturalGas;
		this.fuelOil = fuelOil;
		this.LPG = LPG;
		this.waste = waste;
		this.water = water;
	}
	
	public double getElectricity() {
		return electricity;
	}
	public void setElectricity(double electricity) {
		checkVal(electricity);
		this.electricity = electricity;
	}
	public double getNaturalGas() {
		return naturalGas;
	}
	public void setNaturalGas(double naturalGas) {
		checkVal(naturalGas);
		this.naturalGas = naturalGas;
	}
	public double getFuelOil() {
		return fuelOil;
	}
	public void setFuelOil(double fuelOil) {
		checkVal(fuelOil);
		this.fuelOil = fuelOil;
	}
	public double getLPG() {
		return LPG;
	}
	public void setLPG(double lPG) {
		checkVal(lPG);
		LPG = lPG;
	}
	public double getWaste() {
		return waste;
	}
	public void setWaste(double waste) {
		checkVal(waste);
		this.waste = waste;
	}
	public double getWater() {
		return water;
	}
	public void setWater(double water) {
		checkVal(water);
		this.water = water;
	}

	@Override
	public double getCarbonFootprint() {
		//figures obtained from http://shrinkthatfootprint.com/calculate-your-carbon-footprint
		//EF for waste carbon footprint is obtained from https://ec.europa.eu/eurostat/web/products-eurostat-news/-/DDN-20200123-1
		return (this.electricity * 0.65) + (this.naturalGas * 6.6) + (this.fuelOil * 3.1) 
				+ (this.LPG * 1.8) + (this.waste * 52 * 0.23) + (this.water * 365 * 0.1);
	}
	@Override
	public String toString() {
		return String.format("%s%n%s%n%s: %.2f %s%n%s: %.2f %s%n%s: %.2f %s%n%s: %.2f %s%n%s: %.2f %s%n%s: %.2f %s%n%s: %.2f %s%n", 
				"Building Annual Carbon Footprint",
				"--------------------------------",
				"Electricity", this.electricity, "kWh/yr",
				"Natural Gas", this.naturalGas, "therms/yr",
				"Fuel Oil", this.fuelOil, "litres/yr",
				"LPG", this.LPG, "litres/yr",
				"Waste", this.waste, "kg/week",
				"Water", this.water, "litres/day", 
				"Carbon Footprint", getCarbonFootprint(), "kg CO2e/yr");
	}
	
	private void checkVal(double val) {
		if (val < 0.0) {
			throw new IllegalArgumentException("value can't be a negative number");
		}
	}
}
