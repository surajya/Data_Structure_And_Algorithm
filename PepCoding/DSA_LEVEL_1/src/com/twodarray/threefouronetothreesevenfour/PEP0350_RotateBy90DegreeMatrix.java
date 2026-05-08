package com.twodarray.threefouronetothreesevenfour;

public class PEP0350_RotateBy90DegreeMatrix {

	public static void main(String[] args) {
		int[][] arr = {
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12},
				{13, 14, 15, 16}
		};

		rotateMatrix(arr);
		displayRotateMatrix(arr);

	}

	private static void displayRotateMatrix(int[][] arr) {
		for (int[] subarr : arr) {
			for (int a : subarr) {
				System.out.print(" " + a);
			}
			System.out.println();
		}

	}

	private static void rotateMatrix(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[j][i];
				arr[j][i] = temp;
			}
		}

		for (int j = 0; j < arr[0].length / 2; j++) {
			for (int i = 0; i < arr.length; i++) {
				int temp = arr[i][j];
				arr[i][j] = arr[i][arr[0].length - 1 - j];
				arr[i][arr[0].length - 1 - j] = temp;
			}
		}

	}

}
