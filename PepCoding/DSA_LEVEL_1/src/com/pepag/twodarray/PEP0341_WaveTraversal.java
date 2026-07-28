package com.pepag.twodarray;


public class PEP0341_WaveTraversal {

	public static void main(String[] args) {
		int[][] arr = {
				{11, 12, 13, 14},
				{21, 22, 23, 24},
				{31, 32, 33, 34},
				{41, 42, 43, 44}
		};

		waveTraversal(arr);
	}

	private static void waveTraversal(int[][] arr) {
		int rows = arr.length;
		int cols = arr[0].length;

		for (int j = 0; j < cols; j++) {
			for (int i = 0; i < rows; i++) {
				if (j % 2 == 0) {
					System.out.println(arr[i][j]);
				} else {
					System.out.println(arr[rows - i - 1][j]);
				}
			}
		}
	}

}
