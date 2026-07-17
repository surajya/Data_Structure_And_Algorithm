package com.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PEP0423_NQueenProblem {

	public static void main(String[] args) {
		int[][] arr = new int[1][1];
		//System.out.println("all path is :"+ findWayToSit(arr, 0, new int[arr.length], new int[arr[0].length], ""));
		List<String> listWay = findWayToSit(arr, 0, new int[arr.length], new int[arr[0].length], "");
		List<List<String>> ans = new ArrayList<>();
		for(String str : listWay){
			String[] qPoint = str.split("-");
			List<String> tempPath = new ArrayList<>();
			for(String point : qPoint){
				int x = point.charAt(0)-'0';
				int y = point.charAt(1)-'0';
				StringBuilder path = new StringBuilder();
				for(int i=0; i<arr.length; i++){
					if(i==y) path.append("Q");
					else path.append(".");
				}
				tempPath.add(path.toString());
			}
			ans.add(tempPath);
		}
		System.out.println(ans);
	}

	private static List<String> findWayToSit(int[][] arr, int i, int[] row, int[] col, String way) {
		if(i == arr.length) return Collections.singletonList(way);

		ArrayList<String> ways = new ArrayList<>();
		for(int x=0; x<arr[0].length; x++){
			if(row[i] == 1 || col[x] == 1 || checkClash(arr, i, x)) continue;
			row[i] = 1; col[x] = 1;
			arr[i][x] = 1;
			ways.addAll(findWayToSit(arr, i+1, row, col, way+i+x+"-"));
			row[i] = 0; col[x] = 0;
			arr[i][x] = 0;
		}
		return ways;
	}

	private static boolean checkClash(int[][] arr, int i, int x) {
		int row = i, col= x;
		while(checkBoundary(arr, i, x)){
			if(arr[i][x] == 1) return true;
			i--; x--;
		}

		while(checkBoundary(arr, row, col)){
			if(arr[row][col] == 1) return true;
			row--; col++;
		}
		return false;
	}

	private static boolean checkBoundary(int[][] arr, int i, int x) {
        return i >= 0 && x >= 0 && x < arr[0].length;
	}
}
