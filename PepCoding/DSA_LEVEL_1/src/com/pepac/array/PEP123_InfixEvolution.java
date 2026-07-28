package com.pepac.array;

import java.util.Stack;

public class PEP123_InfixEvolution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// String expr = "2+(9-6*3/(2+1)+1)";
		// String expr = "2+(3*(4+5))";
		String expr = "-+2/*6483";
		Stack<String> operand = new Stack<>();
		Stack<Character> operator = new Stack<>();

		for (int i = expr.length()-1; i>=0; i--) {
			char c = expr.charAt(i);

			if (c >= '0' && c <= '9') {
				operand.push(Character.toString(c));
			} else {
				int a = Integer.parseInt(operand.pop()), b = Integer.parseInt(operand.pop());
				operand.push(String.valueOf(processValue(a, b, c)));

			}
		}
		System.out.println("Value of expression: " + operand.pop());
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
