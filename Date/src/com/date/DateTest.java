package com.date;

public class DateTest {

	public static void main(String[] args) {
		Date myDate = new Date(15, 10, 2020);
		
		//Display date info
		myDate.displayDate();
		
		//Changing the date
		myDate.setDay(1);
		myDate.setMonth(1);
		myDate.setYear(1);
		
		//Displaying each day, month, and year one by one
		System.out.println("Day: " + myDate.getDay());
		System.out.println("Month: " + myDate.getMonth());
		System.out.println("Year: " + myDate.getYear());
		
		//Recalling displayDate()
		myDate.displayDate();
	}

}
