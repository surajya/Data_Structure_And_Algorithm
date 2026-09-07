package com.pepam.dynamicProgramming;

public class PEP0485_01KnapsackProblem {

	public static void main(String[] args) {
		int capacity = 7;
		int[][] wv = { { 2, 15 }, { 5, 14 }, { 1, 10 }, { 3, 45 }, { 4, 130 } };
		int[] dp = new int[capacity + 1];

		for (int i = 1; i < dp.length; i++) {
			for (int[] arr : wv) {
				int weight = arr[0];
				int value = arr[1];
				if (weight > i)
					continue;
				dp[i] = dp[i] > value + dp[i - weight] ? dp[i] : value + dp[i - weight];
			}
		}

		System.out.println("highest weith is : " + dp[dp.length - 1]);
	}
}
