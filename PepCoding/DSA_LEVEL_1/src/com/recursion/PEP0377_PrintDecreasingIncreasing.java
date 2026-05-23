package com.recursion;


public class PEP0377_PrintDecreasingIncreasing {

	public static void main(String[] args) {
		int n = 5;
		printDI(n);
	}

	private static void printDI(int n) {
		if (n == 0) {
			return;
		}
		System.out.println("desc: " + n);
		printDI(n - 1);
		System.out.println("inc: " + n);
	}
}
