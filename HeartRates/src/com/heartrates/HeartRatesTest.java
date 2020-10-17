package com.heartrates;

import java.util.Scanner;

public class HeartRatesTest {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Welcome to Heart Rate Calculator App!");
		System.out.println("To start, please enter your name!");
		String firstName = scn.next();
		String lastName = scn.next();
		System.out.println("Awesome! Now please enter your,");
		System.out.println("Day of birth: ");
		int birthDay = scn.nextInt();
		System.out.println("Month of birth: ");
		int birthMonth = scn.nextInt();
		System.out.println("Year of birth: ");
		int birthYear = scn.nextInt();
		
		
		HeartRates myHeartRate = new HeartRates(firstName, lastName, birthDay, birthMonth, birthYear);
		myHeartRate.displayStartDetails();
		
		scn.close();
	}

}
