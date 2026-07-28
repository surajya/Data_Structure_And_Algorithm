package com.pepac.array;

import java.util.Stack;

public class PEP122_PostFixConversion{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String expr = "2+(9-6*3/(2+1)+1)";
		String expr = "264*8/+3-";
		Stack<String> prefix = new Stack<>();
		Stack<Character> stack2 = new Stack<>();
		Stack<String> infix=new Stack<>();

		int sum = 0;
		for (int i = 0; i < expr.length(); i++) {
			char c = expr.charAt(i);

			if (c >= '0' && c <= '9') {
				prefix.push(Character.toString(c));
				infix.push(Character.toString(c));
			} else {
						String b = prefix.pop(), a = prefix.pop(), d=infix.pop(), cc=infix.pop();
						prefix.push(convertPrefix(a, b, c));
						infix.push(convertInfix(cc, d, c));
					}
					
			}

		System.out.println("Value of expression of Prefix: " + prefix.pop());
		System.out.println("Value of expression of infix: " + infix.pop());
	}

	public static String convertPrefix(String a, String b, char c) {
		
		return c+a+b;
	}
	
	public static String convertInfix(String a, String b, char c) {
		
		return "("+a+c+b+")";
	}
	
	

}
