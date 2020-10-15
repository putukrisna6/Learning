package com.employee;

public class EmployeeTest {

	public static void main(String[] args) {
		Employee employeeOne = new Employee("John", "Smith", 500.0);
		
		employeeOne.displayEmployeeSalary();
		
		employeeOne.setMonthlyPay(employeeOne.getMonthlyPay() * (1 + 0.1));
		
		employeeOne.displayEmployeeSalary();
	}

}
