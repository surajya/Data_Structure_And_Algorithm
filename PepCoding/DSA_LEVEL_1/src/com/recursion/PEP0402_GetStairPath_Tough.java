package com.recursion;

import java.util.ArrayList;
import java.util.List;

public class PEP0402_GetStairPath_Tough {

	static int[] arr = {1, 2, 3};
	public static void main(String[] args) {
		List<List<Integer>> ans = new ArrayList<>();
		int totalSteps = 4;
		getstairPath(totalSteps, 0, new StringBuilder(), 0, ans);
		System.out.println(ans);

	}

	private static void getstairPath(int totalSteps, int indx, StringBuilder sb, int sum,
			List<List<Integer>> list) {
		if (sum > totalSteps) {
			return;
		}
		if (sum == totalSteps) {
			List<Integer> ans = new ArrayList<>();
			for (int i = 0; i < sb.length(); i++) {
				ans.add(sb.charAt(i) - '0');
			}
			list.add(ans);
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
			getstairPath(totalSteps, indx + 1, sb, sum + arr[i], list);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

}
