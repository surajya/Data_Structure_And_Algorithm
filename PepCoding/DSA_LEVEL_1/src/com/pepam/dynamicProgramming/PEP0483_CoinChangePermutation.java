package com.pepam.dynamicProgramming;

public class PEP0483_CoinChangePermutation {
	public static void main(String[] args) {
		int[] coins = { 2, 3, 5 };
		int targetSum = 7;
		int[] dp = new int[targetSum + 1];
		dp[0] = 1;
		for (int target = 1; target <= targetSum; target++) {
			for (int coin : coins) {
				if (target - coin >= 0 && dp[target - coin] >= 1)
					dp[target] += dp[target - coin];
			}
		}
		System.out.println("Total way to find the solution ; " + dp[targetSum]);
	}
}
