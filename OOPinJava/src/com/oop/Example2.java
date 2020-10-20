package com.oop;

public class Example2 implements Example3{
	public void sayHi() {
		System.out.println("Hi there!");
	}

	@Override
	public void sayBye() {
		// TODO Auto-generated method stub
		System.out.println("Bye!");
	}
}
