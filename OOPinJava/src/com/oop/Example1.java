package com.oop;

//	Example1 (sub-class) inherit Example2 (super-class)
public class Example1 extends Example2{
	public void sayName() {
		System.out.println("Name! Haha, get it, name?");
	}
//	overloads previous sayName();
	public void sayName(String name) {
		System.out.println("My name is " + name);
	}
//	overwrites Example2's sayHi();
	public void sayHi() {
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Example1 epicEx = new Example1();
		
		epicEx.sayHi();
	}

}

