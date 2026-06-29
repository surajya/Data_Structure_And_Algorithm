package com.recursion;

import java.util.ArrayList;
import java.util.List;

public class PEP0398_SubsequenceOfArray {

	public static void main(String[] args) {
		String str = "abc";
		List<String> list = new ArrayList<>();
		subsequenceOfArray(str, 0, new StringBuilder(), list);
		System.out.println(list);

	}

	public static void subsequenceOfArray(String str, int indx, StringBuilder ans, List<String> list) {
		if (indx == str.length()) {
			list.add(ans.toString());
			return;
		}
		StringBuilder x = new StringBuilder(ans);
		StringBuilder y = new StringBuilder(ans.append(str.charAt(indx)));
		subsequenceOfArray(str, indx + 1, x, list);
		subsequenceOfArray(str, indx + 1, y, list);

	}

}
