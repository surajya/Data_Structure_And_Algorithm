package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class CheckPoint{
	int i;
	int j;

	CheckPoint(int a, int b){
		this.i = a;
		this.j = b;
	}

	public int getI(){
		return this.i;
	}

	public int getJ() {
		return j;
	}
}

public class Leet10001_KnightMove {

	public static void main(String[] args) {
		int n=2;
		int[][] arr = new int[n][n];
		List<CheckPoint> knightPointList = new ArrayList<>();
		knightPointList.addAll(Arrays.asList(
				(new CheckPoint(1,2)),
				(new CheckPoint(2,1)),
				(new CheckPoint(2,-1)),
				(new CheckPoint(1,-2)),
				(new CheckPoint(-1,-2)),
				(new CheckPoint(-2,-1)),
				(new CheckPoint(-2,1)),
				(new CheckPoint(-1,2))));
		List<String> listWay = findKnightMove(arr, 0, 0, knightPointList, "00-", 1);
		System.out.println("all path is :"+ listWay);
		int[][] ans = new int[n][n];
		for(String str : listWay){
			String[] qPoint = str.split("-");
			List<String> tempPath = new ArrayList<>();
			int path =0;
			for(String point : qPoint){
				int x = point.charAt(0)-'0';
				int y = point.charAt(1)-'0';
				ans[x][y] = path;
				path++;
			}
		}
		List<List<Integer>> list = new ArrayList<>();
		for (int[] row : ans) {
			List<Integer> rowList = new ArrayList<>();
			for (int val : row) {
				rowList.add(val);
			}
			list.add(rowList);
		}
		System.out.println(list);
	}

	private static List<String> findKnightMove(int[][] arr, int i, int j, List<CheckPoint> knightPointList, String way, int totalvisit) {
		if(totalvisit == arr.length * arr[0].length) return Collections.singletonList(way);

		arr[i][j] = 1;
		ArrayList<String> ways = new ArrayList<>();
		for(CheckPoint point : knightPointList){
			int x = i+ point.getI();
			int y = j+ point.getJ();
			if(checkSafe(arr, x, y) && arr[x][y] != 1){
				if(!ways.isEmpty()) return ways;
				ways.addAll(findKnightMove(arr, x, y, knightPointList, way+x+y+"-", totalvisit+1));

			}
		}
		arr[i][j] = 0;
		return ways;
	}

	private static boolean checkSafe(int[][] arr, int i, int j) {
        return i >= 0 && i< arr.length && j >= 0 && j < arr[0].length;
	}
}


