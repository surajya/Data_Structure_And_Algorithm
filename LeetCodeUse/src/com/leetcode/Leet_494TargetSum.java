package com.leetcode;

public class Leet_494TargetSum {

	public static void main(String[] args) {
		int[] tasks = {1,1,1,1,1};
		int target = 3;
		System.out.println(findTargetSumWays(tasks, target, 0, 0));
	}

	public static int findTargetSumWays(int[] nums, int target, int index, int total) {
		if(total == target) return 1;
		if(total > target || index == nums.length) return 0;
		int sum =0;
		 sum += findTargetSumWays(nums, target, index + 1, total + nums[index]);
		sum += findTargetSumWays(nums, target, index + 1, total - nums[index]);
		  return sum;
	}
}
