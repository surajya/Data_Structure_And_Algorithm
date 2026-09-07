package com.pepam.dynamicProgramming;

public class PEP0482_CoinChangeCombination {
	public static void main(String[] args) {
		int[] arr = { 2, 3, 5 };
		int targetSum = 7;
		int[] dp = new int[targetSum + 1];
		dp[0] = 1;
		for (int a : arr) {
			for (int i = 0; i <= targetSum; i++) {
				if (i - a >= 0 && dp[i - a] >= 1)
					dp[i] = dp[i] + 1;
			}
		}
		System.out.println("Total way to find the solution ; " + dp[targetSum]);
	}
}
