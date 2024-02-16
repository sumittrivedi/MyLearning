package com.epam;

/* We have a Parent class with 2 methods walk and run. We have a child class which overrides both the methods.
Both methods of child class just call their respective Super implementation.
Parent class run method calls walk().
class Parent
Parent p = new Child();
p.run();
Tell the order in which each method is called */

public class Parent {
	
	public void walk() {
		System.out.println("3");
		System.out.println("Walk");
	}
	public void run() {
		System.out.println("2");
		this.walk();
	}
	public static void main(String args[]) {
		Parent p = new Child();
		p.run();
	}

}

