package com.date;

public class Date {
	private int month;
	private int day;
	private int year;
	
	//Constructor
	Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	//Setters
	public void setDay(int newDay) {
		this.day = newDay;
	}
	public void setMonth(int newMonth) {
		this.month = newMonth;
	}
	public void setYear(int newYear) {
		this.year = newYear;
	}
	
	//Getters
	public int getDay() {
		return this.day;
	}
	public int getMonth() {
		return this.month;
	}
	public int getYear() {
		return this.year;
	}
	
	//Method
	public void displayDate() {
		System.out.println(this.day + "/" + this.month + "/" + this.year);
	}
}
