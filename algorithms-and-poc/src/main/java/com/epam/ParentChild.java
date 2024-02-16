package com.epam;

class Parent2 {
	{
		System.out.println("A");
	}
	static {
		System.out.println("B");
	}
}

public class ParentChild extends Parent2{
	
	{
		System.out.println("C");
	}
	static {
		System.out.println("D");
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parent2 x = new ParentChild();
	}

}
