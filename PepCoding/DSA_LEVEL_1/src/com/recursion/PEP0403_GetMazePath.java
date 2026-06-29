package com.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PEP0403_GetMazePath {

	public static void main(String[] args) {
		int n = 3;
		int m = 3;
		System.out.println(getMazePath(0, 0, n - 1, m - 1, ""));
	}

	private static List<String> getMazePath(int i, int j, int k, int l, String sb) {
		// TODO Auto-generated method stub
		if (i == k && j == l) {
			return Arrays.asList(sb);
		}

		List<String> resultList = new ArrayList<>();
		if(j<l) {
			resultList.addAll(getMazePath(i, j + 1, k, l, sb + "h"));
		}
		if(i<k) {
			resultList.addAll(getMazePath(i + 1, j, k, l, sb + "v"));
		}
		return resultList;
	}

}
