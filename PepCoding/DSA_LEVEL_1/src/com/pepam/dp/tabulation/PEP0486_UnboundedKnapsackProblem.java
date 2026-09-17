package com.pepam.dp.tabulation;

public class PEP0486_UnboundedKnapsackProblem {

	public static void main(String[] args) {
		int capacity = 7;
		int[][] wv = { { 2, 15 }, { 5, 140 }, { 1, 10 }, { 3, 45 }, { 4, 30 } };
		int[][] dp = new int[wv.length + 1][capacity + 1];

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (wv[i - 1][0] > j)
					continue;
				dp[i][j] = dp[i - 1][j] > dp[i - 1][j - wv[i - 1][0]] + wv[i - 1][1] ? dp[i - 1][j]
						: dp[i - 1][j - wv[i - 1][0]] + wv[i - 1][1];
			}
		}

		System.out.println("highest weith is : " + dp[dp.length - 1][dp[0].length - 1]);
	}
}
