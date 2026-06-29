package com.recursion;

import java.util.ArrayList;
import java.util.List;

public class PEP0400_GetKeyPadCombination {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("mnop");
		list.add("uv");
		list.add("ghi");
		List<String> ans = getKeyPadCombination(list);
		System.out.println(ans);

	}

	private static List<String> getKeyPadCombination(List<String> list) {
		if (list.isEmpty()) {
			List<String> list1 = new ArrayList<>();
			list1.add("");
			return list1;
		}

		String str = list.remove(0);
		List<String> ansList = getKeyPadCombination(list);
		List<String> newans = new ArrayList<>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			for (int j = 0; j < ansList.size(); j++) {
				newans.add(c + ansList.get(j));
			}
		}
		return newans;
	}



}
