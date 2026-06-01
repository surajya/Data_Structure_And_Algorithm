package com.recursion;


public class PEP0379_FactorialOfN {

	public static void main(String[] args) {
		int n = 5;
		System.out.println("Factorial of " + n + " is: " + factorialN(n));
	}

	private static int factorialN(int n) {
		if (n == 1) {
			return 1;
		}
		return n * factorialN(n - 1);
	}
}
