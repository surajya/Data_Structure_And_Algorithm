package com.twodarray.threefouronetothreesevenfour;

public class PEP0352_ShellRotation_Revise {

	public static void main(String[] args) {
		//		int[][] arr = {
		//				{1, 2, 3, 4},
		//				{5, 6, 7, 8},
		//				{9, 10, 11, 12},
		//				{13, 14, 15, 16}
		//		};

		int[][] arr = {
				{1, 2, 3, 4, 5, 6, 7, 8},
				{9, 10, 11, 12, 13, 14, 15, 16},
				{17, 18, 19, 20, 21, 22, 23, 24},
				{25, 26, 27, 28, 29, 30, 31, 32},
				{33, 34, 35, 36, 37, 38, 39, 40},
				{41, 42, 43, 44, 45, 46, 47, 48},
				{49, 50, 51, 52, 53, 54, 55, 56},
				{57, 58, 59, 60, 61, 62, 63, 64}
		};
		shellRotateMatrix(arr);
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

	private static void shellRotateMatrix(int[][] arr) {
		int m = arr.length, n = arr[0].length;
		int maxRotation = 90, shell = 2;

		// Correct shell boundaries
		int top = shell - 1;
		int bottom = m - shell;
		int left = shell - 1;
		int right = n - shell;

		// FIXED: perimeter not area
		int perimeter = 2 * ((bottom - top) + (right - left));

		int numberOfRotation = maxRotation % perimeter;

		while (numberOfRotation-- > 0) {
			everyTimeRotate(arr, m, n, shell, 1);
		}
	}

	private static void everyTimeRotate(int[][] arr, int m, int n, int shell, int NumberOfRotation) {
		int i = shell - 1, j = shell - 1;
		int previousValue = arr[i][j];
		int dir = 0;
		while (true) {
			if (checkValid(m, n, i, j, shell)) {
				int temp = previousValue;
				previousValue = arr[i][j];
				arr[i][j] = temp;

			} else {
				if (dir == 0) {
					j--;
				} else if (dir == 1) {
					i--;
				} else if (dir == 2) {
					j++;
				} else {
					i++;
				}
				dir = (dir + 1) % 4;
			}
			if (dir == 0) {
				j++;
			} else if (dir == 1) {
				i++;
			} else if (dir == 2) {
				j--;
			} else {
				i--;
			}
			//displayRotateMatrix(arr);
			if (NumberOfRotation == 0) {
				break;
			}
			if (i == shell - 1 && j == shell - 1) {
				NumberOfRotation--;
			}
		}
	}

	// ✅ FIXED - only allows cells ON the shell ring (top/bottom row OR left/right col)
	private static boolean checkValid(int m, int n, int i, int j, int shell) {
		int top = shell - 1;
		int bottom = m - shell;
		int left = shell - 1;
		int right = n - shell;

		// Cell must be on the boundary ring, not inside it
		boolean onRow = (i == top || i == bottom) && (j >= left && j <= right);
		boolean onCol = (j == left || j == right) && (i >= top && i <= bottom);

		return onRow || onCol;
	}

}