package com.leetcode75;

import java.util.Arrays;

class Solution {

	public static int minCostClimbingStairs(int[] cost) {
		int[] dp = new int[cost.length];
		Arrays.fill(dp, -1);
		return getMinCost(cost, -1, 0, dp);
	}

	private static int getMinCost(int[] cost, int index, int totalCost, int[] dp) {
		if (index >= cost.length) {
			return totalCost;
		}
		if (index != -1 && dp[index] != -1) {
			return dp[index];
		}
		int costTotal = index == -1 ? totalCost : totalCost + cost[index];
		int minCost = costTotal;

		int firstCost = getMinCost(cost, index + 1, costTotal, dp);
		int secCost = getMinCost(cost, index + 2, costTotal, dp);
		minCost = firstCost > secCost ? secCost : firstCost;
		if (index != -1) {
			dp[index] = minCost;
		}
		return minCost;
	}

	public static void main(String[] args) {
		int[] cost = {10, 15, 20};
		System.out.println(minCostClimbingStairs(cost));
	}
}