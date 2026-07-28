package com.pepai.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class PEP0419_FloodFill {

	public static void main(String[] args) {
		int[][] arr={{0,1,0,0,0,0,0}, {0,1,0,1,1,1,0}, {0,0,0,0,0,0}, {1,0,1,1,0,1,1}, {1,0,1,1,0,1,1}, {1,0,0,0,0,0}};
		int[][] dp=new int[arr.length][arr[0].length];
		System.out.println("all path is :"+ findThePath(arr, dp, 0, 0, arr.length, arr[0].length,  ""));
	}

	private static List<String> findThePath(int[][] arr, int[][] dp, int i, int j, int m, int n, String s) {
		if(i==m-1 && j==n-1) return Collections.singletonList(s);

		if(dp[i][j]==1 || arr[i][j] == 1) return Collections.emptyList();
		dp[i][j] = 1;
		List<String> ans = new ArrayList<>();
		if(j < n-1){
			ans.addAll(Objects.requireNonNull(findThePath(arr, dp, i, j + 1, m, n, s + "r")));
		}
		if(i < m-1){
			ans.addAll(Objects.requireNonNull(findThePath(arr, dp, i + 1, j, m, n, s + "b")));
		}
		if(j > 0){
			ans.addAll(Objects.requireNonNull(findThePath(arr, dp, i, j - 1, m, n, s + "l")));
		}
		if(i > 0){
			ans.addAll(Objects.requireNonNull(findThePath(arr, dp, i - 1, j, m, n, s + "u")));
		}

		dp[i][j] = 0;
		return ans;
	}

}
