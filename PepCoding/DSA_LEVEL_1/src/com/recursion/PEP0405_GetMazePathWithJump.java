package com.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PEP0405_GetMazePathWithJump {

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
			for(int h=1; h<=l+1; h++) resultList.addAll(getMazePath(i, j + h, k, l, sb + "h"+h));
		}
		if(i<k) {
			for(int v=1; v<=k+1; v++) resultList.addAll(getMazePath(i + v, j, k, l, sb + "v"+v));
		}
		return resultList;
	}
}
