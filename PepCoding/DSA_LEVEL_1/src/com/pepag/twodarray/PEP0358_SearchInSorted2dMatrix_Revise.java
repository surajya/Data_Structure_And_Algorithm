package com.pepag.twodarray;

public class PEP0358_SearchInSorted2dMatrix_Revise {

	public static void main(String[] args) {
		int[][] arr = {
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12},
				{13, 14, 15, 16}
		};

		searchElement2(arr);
	}

		
	public static void searchElement2(int[][] arr) {
		int i = 0, j = arr[0].length - 1, m = arr.length, n = arr[0].length;
		int target = 15;
		while (i < m && j >= 0) {
			int value = arr[i][j];
			if (target == value) {
				System.out.print("target is present this co-ordinate : " + i + " - " + j);
				target = 0;
				break;
			}
			else if (target < value) {
				j--;
			} else {
				i++;
			}
		}
		if (target != 0) {
			System.out.print("target is not present in this matrix");
		}
	}
}