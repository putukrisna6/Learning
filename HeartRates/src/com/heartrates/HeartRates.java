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
	public int personAge() {
		return 0;
	}
	public int maxHeartRate() {
		return 0;
	}
	public int targetHeartRate() {
		return 0;
	}
}
