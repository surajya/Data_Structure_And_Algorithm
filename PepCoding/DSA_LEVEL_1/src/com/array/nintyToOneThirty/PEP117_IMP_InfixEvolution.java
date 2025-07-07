package com.array.nintyToOneThirty;

import java.util.Stack;

public class PEP117_IMP_InfixEvolution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String expr = "2+(9-6*3/(2+1)+1)";
		String expr = "2+(3*(4+5))";
		Stack<String> stack1 = new Stack<>();
		Stack<Character> stack2 = new Stack<>();

		int sum = 0;
		for (int i = 0; i < expr.length(); i++) {
			char c = expr.charAt(i);

			if (c >= '0' && c <= '9') {
				stack1.push(Character.toString(c));
			} else {
				if (c == '(')
					stack2.push(c);
				else if (c == ')') {
					while (stack2.peek() != '(') {
						int b = Integer.parseInt(stack1.pop()), a = Integer.parseInt(stack1.pop());
						stack1.push(String.valueOf(processValue(a, b, stack2.pop())));
					}
					stack2.pop();
				} else {
					if (stack2.isEmpty())
						stack2.push(c);
					else if (stack2.peek() == '(')
						stack2.push(c);
					else if (c == '+' || c == '-') {

						while (stack2.size() > 0 && stack2.peek() != '(') {
							int b = Integer.parseInt(stack1.pop()), a = Integer.parseInt(stack1.pop());
							stack1.push(String.valueOf(processValue(a, b, stack2.pop())));
						}
						stack2.push(c);

					} else {
						if (stack2.peek() == '*' || stack2.peek() == '/') {
							while (stack2.size() > 0
									&& (stack2.peek() != '(' && stack2.peek() != '+' && stack2.peek() != '-')) {
								int b = Integer.parseInt(stack1.pop()), a = Integer.parseInt(stack1.pop());
								stack1.push(String.valueOf(processValue(a, b, stack2.pop())));
							}
							stack2.push(c);
						} else
							stack2.push(c);
					}
				}
			}
		}

		while (stack2.size() > 0) {
			int b = Integer.parseInt(stack1.pop()), a = Integer.parseInt(stack1.pop());
			stack1.push(String.valueOf(processValue(a, b, stack2.pop())));
		}

		System.out.println("Value of expression: " + stack1.pop());
	}

	public static int processValue(int a, int b, char c) {
		int sum = 0;
		switch (c) {
		case '+':
			sum = a + b;
			break;
		case '-':
			sum = a - b;
			break;
		case '*':
			sum = a * b;
			break;
		case '/':
			try {
				sum = a / b;
			} catch (Exception e) {
				System.out.println("There are exception" + e);
			}
		}
		return sum;
	}

}
