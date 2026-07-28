package com.pepai.recursion;

import java.util.ArrayList;
import java.util.List;

public class PEP0400_GetKeyPadCombination_OptimizeSolution {

	static String[] arr = {" ", " ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	public static void main(String[] args) {
		List<String> ans = new ArrayList<>();
		String digits = "789";
		getKeyPadCombination(digits, 0, new StringBuilder(), ans);
		System.out.println(ans);

	}

	private static void getKeyPadCombination(String digits, int indx, StringBuilder sb, List<String> list) {
		if (digits.length() == indx) {
			list.add(sb.toString());
			return;
		}

		String str = arr[digits.charAt(indx) - '0'];
		for (int i = 0; i < str.length(); i++) {
			sb.append(str.charAt(i)); //choose
			getKeyPadCombination(digits, indx + 1, sb, list);
			sb.deleteCharAt(sb.length() - 1); //unchoose
		}
	}



}
