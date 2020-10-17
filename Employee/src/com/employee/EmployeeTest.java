package com.employee;

public class EmployeeTest {

	public static void main(String[] args) {
		//Declare two instances of class Employee
		Employee employeeOne = new Employee("John", "Smith", 500.0);
		Employee employeeTwo = new Employee("Daffa", "Zaki", 125.0);
		
		//Get each employee's info
		employeeOne.displayEmployeeSalary();
		employeeTwo.displayEmployeeSalary();
		System.out.println();
		
		//Modifying employee two's name
		employeeTwo.setFirstName("Joni");
		employeeTwo.setLastName("Samsul");
		
		//Giving both employee a raise
		employeeOne.setMonthlyPay(employeeOne.getMonthlyPay() * (1 + 0.1));
		employeeTwo.setMonthlyPay(employeeTwo.getMonthlyPay() * (1 + 0.1));
		
		//Displaying the updated salary
		employeeOne.displayEmployeeSalary();
		employeeTwo.displayEmployeeSalary();
	}

}
