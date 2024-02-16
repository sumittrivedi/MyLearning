package com.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


public class ValidBrackets {
	public static void main(String args[]) {
		System.out.println(Program3.balancedBrackets("(((((({{{{{[[[[[([)])]]]]]}}}}}))))))"));
	}
}

class Program3 {
	private static List<Character> openingBrackets = new ArrayList<>(Arrays.asList('(', '{', '['));
	private static List<Character> closingBrackets = new ArrayList<>(Arrays.asList(')', '}', ']'));

	public static boolean balancedBrackets(String str) {
		Stack<Character> stack = new Stack<>();
		int i = 0;
		int n = str.length();
		while (i < n) {
			if (openingBrackets.contains(str.charAt(i))) {
				stack.push(str.charAt(i));
			} else {
				if (closingBrackets.contains(str.charAt(i))) {
					if (stack.empty() || (!stack.empty() && !isValidBrackets(stack.pop(), str.charAt(i))))
						return false;
				}
			}
			i++;
		}
		return stack.empty();
	}

	private static boolean isValidBrackets(Character openingBracket, Character closingBracket) {
		return openingBrackets.indexOf(openingBracket) == closingBrackets.indexOf(closingBracket) ? true : false;
	}
}
