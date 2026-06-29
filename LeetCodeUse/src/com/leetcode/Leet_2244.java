package com.leetcode;

import java.util.HashMap;

public class Leet_2244 {

	public static void main(String[] args) {
		int[] tasks = {2, 2, 3, 3, 2, 4, 4, 4, 4, 4};
		System.out.println(minimumRounds(tasks));
	}

	public static int minimumRounds(int[] tasks) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int task : tasks) {
			map.put(task, map.getOrDefault(task, 0) + 1);
		}

		int rounds = 0;
		for (int count : map.values()) {
			if (count == 1) {
				return -1; // If there's a task that appears only once, it's impossible to complete it
			}
			rounds += (count + 2) / 3; // Calculate the number of rounds needed for this task
		}

		return rounds;
	}

}
