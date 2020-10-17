package com.heartrates;

public class HeartRates {
	//Variables
	private String firstName;
	private String lastName;
	private int birthDay;
	private int birthMonth;
	private int birthYear;
	
	//Constructor
	HeartRates(String firstName, String lastName, int birthDay, int birthMonth, int birthYear) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDay = birthDay;
		this.birthMonth = birthMonth;
		this.birthYear = birthYear;
	}
	
	//Getters
	public String getFirstName() {
		return this.firstName;
	}
	public String getLastName() {
		return this.lastName;
	}
	public int getBirthDay() {
		return this.birthDay;
	}
	public int getBirthMonth() {
		return this.birthMonth;
	}
	public int getBirthYear() {
		return this.birthYear;
	}
	
	//Setters
	public void setFirstName(String newFirstName) {
		this.firstName = newFirstName;
	}
	public void setLastName(String newLastName) {
		this.lastName = newLastName;
	}
	public void setBirthDay(int newDay) {
		this.birthDay = newDay;
	}
	public void setBirthMonth(int newMonth) {
		this.birthMonth = newMonth;
	}
	public void setBirthYear(int newYear) {
		this.birthYear = newYear;
	}
	
	//Methods
	private int getAge() {
		if (this.birthDay <= 20 && this.birthMonth <= 10) {
			return 2020 - this.birthYear;
		}
		else return 2019 - this.birthYear;
	}
	private int maxHeartRate() {
		return 220 - this.getAge();
	}
	private double targetHeartRate(double range) {
		return this.maxHeartRate() * range;
	}
	public void displayStartDetails() {
		System.out.println("Displaying your entered information: ");
		System.out.println("Name\t\t\t: " + this.getFirstName() + " " + this.getLastName());
		System.out.println("DOB\t\t\t: " + this.getBirthDay() + "/" + this.getBirthMonth() + "/" + this.getBirthYear());
		System.out.println("Age\t\t\t: " + this.getAge() + " Years Old");
		System.out.println("Maximum Heart Rate\t: " + this.maxHeartRate() + " BPM");
		System.out.println("Target Heart Rate\t: " + this.targetHeartRate(0.5) + " to " + this.targetHeartRate(0.85) + " BPM");
	}
}
