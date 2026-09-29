package com.pepam.dp.tabulation;

import java.util.ArrayList;
import java.util.List;

public class PEP0489_DecodingString {

	public static void main(String[] args) {
		String str = "231011";
		List<String> aphValue = new ArrayList<>();
		for (int i = 1; i < 27; i++)
			aphValue.add("" + i);
		int prevList = 1;
		int list = 0;
		if (str.charAt(0) != '0')
			list = 1;

		for (int i = 1; i < str.length(); i++) {
			String single = "" + str.charAt(i);
			String both = str.charAt(i - 1) + single;
			int dummyList = list;
			if (single.equals("0")) {
				list = 0;
			}
			if (aphValue.contains(both)) {
				list += prevList;
			}
			prevList = dummyList;
		}
		System.out.println("total value is: " + list);
	}
}
