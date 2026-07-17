package com.recursion;

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

public class PEP0425_KnightMove {

	public static void main(String[] args) {
		System.out.println("Starting...........");
		int[][] arr = new int[5][5];
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
		System.out.println("all path is :"+ findKnightMove(arr, 0, 0, knightPointList, "00-", 1));
//		List<String> listWay = findWayToSit(arr, 0, new int[arr.length], new int[arr[0].length], "");
//		List<List<String>> ans = new ArrayList<>();
//		for(String str : listWay){
//			String[] qPoint = str.split("-");
//			List<String> tempPath = new ArrayList<>();
//			for(String point : qPoint){
//				int x = point.charAt(0)-'0';
//				int y = point.charAt(1)-'0';
//				StringBuilder path = new StringBuilder();
//				for(int i=0; i<arr.length; i++){
//					if(i==y) path.append("Q");
//					else path.append(".");
//				}
//				tempPath.add(path.toString());
//			}
//			ans.add(tempPath);
//		}
//		System.out.println(ans);
	}

	private static List<String> findKnightMove(int[][] arr, int i, int j, List<CheckPoint> knightPointList, String way, int totalvisit) {
		if(totalvisit == arr.length * arr[0].length) return Collections.singletonList(way);

		arr[i][j] = 1;
		ArrayList<String> ways = new ArrayList<>();
		for(CheckPoint point : knightPointList){
			int x = i+ point.getI();
			int y = j+ point.getJ();
			if(checkSafe(arr, x, y) && arr[x][y] != 1){
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
