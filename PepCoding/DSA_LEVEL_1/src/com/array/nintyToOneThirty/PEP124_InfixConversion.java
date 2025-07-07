package com.array.nintyToOneThirty;

import java.util.Stack;

public class PEP124_InfixConversion{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String expr = "2+(9-6*3/(2+1)+1)";
		String expr = "-+2/*6483";
		Stack<String> postfix = new Stack<>();
		Stack<Character> stack2 = new Stack<>();
		Stack<String> infix=new Stack<>();

		int sum = 0;
		for (int i=expr.length()-1; i>=0; i--) {
			char c = expr.charAt(i);

			if (c >= '0' && c <= '9') {
				postfix.push(Character.toString(c));
				infix.push(Character.toString(c));
			} else {
						String a = postfix.pop(), b = postfix.pop(), cc=infix.pop(), d=infix.pop();
						postfix.push(convertPostfix(a, b, c));
						infix.push(convertInfix(cc, d, c));
					}
					
			}

		System.out.println("Value of expression of postfix: " + postfix.pop());
		System.out.println("Value of expression of infix: " + infix.pop());
	}

	public static String convertPostfix(String a, String b, char c) {
		
		return a+b+c;
	}
	
	public static String convertInfix(String a, String b, char c) {
		
		return "("+a+c+b+")";
	}
	
	

}
