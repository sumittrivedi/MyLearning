package com.epam;

class Child extends Parent{
	
	public void walk() {
		super.walk();
	}
	public void run() {
		System.out.println("1");
		super.run();
	}
	
}

