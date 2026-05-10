package com.twodarray.threefouronetothreesevenfour;

public class PEP0356_SaddlePoint2DMatrix_Revise {

	public static void main(String[] args) {
		int[][] arr = {
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12},
				{13, 14, 15, 16}
		};

		findSaddlePoint(arr);
	}

	private static void findSaddlePoint(int[][] arr) {
		int m = arr.length, n = arr[0].length;
		for (int i = 0; i < m; i++) {
			int amin = Integer.MAX_VALUE;
			int col = 0;
			for (int j = 0; j < n; j++) {
				if (arr[i][j] < amin) {
					amin = arr[i][j];
					col = j;
				}
			}
			int amax = Integer.MIN_VALUE;
			for (int x = 0; x < m; x++) {
				if (amax < arr[x][col]) {
					amax = arr[x][col];
				}
			}

			if (amax == amin) {
				System.out.println("Saddle point value is : " + amax);
			}
		}
	}
}