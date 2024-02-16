package com.epam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class StringPOC {
		public static void getName(Object name){
		 System.out.println("My name is Sumit");
		}

		public static void getName(String name){
		 System.out.println("My name is " + name );
		}
	
	public static void main(String args[]) {
		List<String> list = Arrays.asList("sumit", "SURAJ", "Kumar", "SANJAY", "sandeep");
		System.out.println(
		list.stream().filter( x-> x.toUpperCase().equals(x)).collect(Collectors.toList()));
		
		getName("obj");
		getName(new Object());
		//{0, 8, 0, 0, 5, 0, 0, 10, 0, 0, 1, 1, 0, 3}
		int array[] = new int[14];
		int[] tempArray = array;
		for (int i =0; i < 14;i++)
			tempArray[i] = i;
		for (int i =0; i < 14;i++)
			System.out.println("Array" + array[i]);
//		System.out.println(StringPOC.waterArea(array));
		String s1 = null;
		String s2 = null;
		if(s1 == s2) {
			System.out.println("---q-===>");
		}
//		if(s1.equals(s2)){
//		System.out.println("---b-===>");
//	}
		String s11 = "java";
		StringBuffer s22 = new StringBuffer("java");
//		if(s11 == s22){
//			System.out.println("---c-===>");
//		}
		if(s11.equals(s22)){
			System.out.println("----d===>");
		}
		if(s11.toString().equals(s22)){
			System.out.println("---e-===>");
		}
		if(s11.equals(s22.toString())){
			System.out.println("---hghg-===>");
		}
		
	}

}



