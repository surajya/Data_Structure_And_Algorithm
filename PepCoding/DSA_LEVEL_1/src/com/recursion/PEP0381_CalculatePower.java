package com.recursion;


public class PEP0381_CalculatePower {

	static int count = 0;
	public static void main(String[] args) {
		int x = 2, n = 17;
		System.out.println("power of " + x + ", " + n + " is: " + power(x, n) + " time taken is : " + count);
		count = 0;
		System.out.println(
				"powerEasySolve of " + x + ", " + n + " is: " + powerEasySolve(x, n) + " time taken is : " + count);
	}

	private static int power(int x, int n) {
		count++;
		if (n == 0) {
			return 1;
		}
		return x * power(x, n - 1);
	}

	private static int powerEasySolve(int x, int n) {
		count++;
		if (n == 0) {
			return 1;
		}
		int powerEasySolve = powerEasySolve(x, n / 2);
		powerEasySolve = powerEasySolve * powerEasySolve;
		if (n % 2 == 1) {
			powerEasySolve = x * powerEasySolve;
		}

		return powerEasySolve;
	}

}
