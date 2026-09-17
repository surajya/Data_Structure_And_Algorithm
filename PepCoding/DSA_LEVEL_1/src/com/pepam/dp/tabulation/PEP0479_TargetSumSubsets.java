package com.pepam.dp.tabulation;

public class PEP0479_TargetSumSubsets {

	public static void main(String[] args) {
		int[] arr = { 4, 2, 7, 3 };
		int targetSum = 10;

		System.out.println("Is any subset present : " + isSubsetPresent(0, arr, arr.length, targetSum));

		System.out.println("Check using Tabulation DP-> " + checkUsingTabulation(arr, targetSum));
	}

	private static boolean checkUsingTabulation(int[] arr, int targetSum) {
		boolean[][] dp = new boolean[arr.length + 1][targetSum + 1];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if (i == 0 || j == 0) {
					if (j == 0)
						dp[i][j] = true;
					continue;
				}
				if (arr[i - 1] > j) {
					dp[i][j] = dp[i - 1][j];
				} else if (arr[i - 1] == j) {
					dp[i][j] = true;
				} else {
					dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
				}
			}
		}
		for (int i = 0; i < dp.length; i++) {
			if (dp[i][targetSum] == true)
				return true;
		}
		return false;
	}

	private static boolean isSubsetPresent(int indx, int[] arr, int size, int targetSum) {
		if (targetSum == 0)
			return true;
		if (indx >= size || targetSum < 0)
			return false;

		boolean nonIncluded = isSubsetPresent(indx + 1, arr, size, targetSum);
		boolean included = isSubsetPresent(indx + 1, arr, size, targetSum - arr[indx]);
		return (nonIncluded || included);
	}

}
