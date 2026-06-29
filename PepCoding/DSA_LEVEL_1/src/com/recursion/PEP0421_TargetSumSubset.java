package com.recursion;

import java.util.*;

public class PEP0421_TargetSumSubset {

	public static void main(String[] args) {
		int[] arr={10, 20, 30, 40, 50};
		int target=70;
		System.out.println("all path is :"+ findSubset(arr, target, 0, 0, ""));
	}

	private static List<String> findSubset(int[] arr, int target, int i, int total, String s) {
		if(total == target) return Collections.singletonList(s);

		if(total > target || i==arr.length){
			return Collections.emptyList();
		}

		ArrayList<String> ans = new ArrayList<>();
		ans.addAll(findSubset(arr, target, i+1, total, s));
		ans.addAll(findSubset(arr, target, i+1, total+arr[i], s+"-"+arr[i]));
		return ans;
	}

}
