package com.array.nintyToOneThirty;

import java.util.Stack;

public class PEP119_InfixConversion{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String expr = "2+(9-6*3/(2+1)+1)";
		String expr = "2+(3*(4+5))";
		Stack<String> prefix = new Stack<>();
		Stack<Character> stack2 = new Stack<>();
		Stack<String> postfix=new Stack<>();

		int sum = 0;
		for (int i = 0; i < expr.length(); i++) {
			char c = expr.charAt(i);

			if (c >= '0' && c <= '9') {
				prefix.push(Character.toString(c));
				postfix.push(Character.toString(c));
			} else {
				if (c == '(')
					stack2.push(c);
				else if (c == ')') {
					while (stack2.peek() != '(') {
						String b = prefix.pop(), a = prefix.pop(), d=postfix.pop(), cc=postfix.pop(); char e=stack2.pop();
						prefix.push(convertPrefix(a, b, e));
						postfix.push(convertPostfix(cc, d, e));
					}
					stack2.pop();
				} else {
					if (stack2.isEmpty())
						stack2.push(c);
					else if (stack2.peek() == '(')
						stack2.push(c);
					else if (c == '+' || c == '-') {

						while (stack2.size() > 0 && stack2.peek() != '(') {
							String b = prefix.pop(), a = prefix.pop(), d=postfix.pop(), cc=postfix.pop(); char e=stack2.pop();
							prefix.push(convertPrefix(a, b, e));
							postfix.push(convertPostfix(cc, d, e));
						}
						stack2.push(c);

					} else {
						if (stack2.peek() == '*' || stack2.peek() == '/') {
							while (stack2.size() > 0
									&& (stack2.peek() != '(' && stack2.peek() != '+' && stack2.peek() != '-')) {
								String b = prefix.pop(), a = prefix.pop(), d=postfix.pop(), cc=postfix.pop(); char e=stack2.pop();
								prefix.push(convertPrefix(a, b, e));
								postfix.push(convertPostfix(cc, d, e));
							}
							stack2.push(c);
						} else
							stack2.push(c);
					}
				}
			}
		}

		while (stack2.size() > 0) {
			String b = prefix.pop(), a = prefix.pop(), d=postfix.pop(), cc=postfix.pop(); char e=stack2.pop();
			prefix.push(convertPrefix(a, b, e));
			postfix.push(convertPostfix(cc, d, e));
		}

		System.out.println("Value of expression: " + prefix.pop());
		System.out.println("Value of expression: " + postfix.pop());
	}

	public static String convertPrefix(String a, String b, char c) {
		
		return c+a+b;
	}
	
	public static String convertPostfix(String a, String b, char c) {
		
		return a+b+c;
	}
	
	

}
