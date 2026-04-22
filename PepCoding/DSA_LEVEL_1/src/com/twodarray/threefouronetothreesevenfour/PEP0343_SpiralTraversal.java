package com.twodarray.threefouronetothreesevenfour;

public class PEP0343_SpiralTraversal {

	public static void main(String[] args) {
		int[][] arr = {
				{11, 12, 13, 14},
				{21, 22, 23, 24},
				{31, 32, 33, 34},
				{41, 42, 43, 44}
		};

		spiralTraversal(arr);
	}

	private static void spiralTraversal(int[][] arr) {
		int rows = arr.length;
		int cols = arr[0].length;
		int imax = rows-1, imin = 0;
		int jmax = cols-1, jmin =0;
		
		while (imax >= imin) {
			int i = imin, j = jmin;
			if (checkbox(i, j, imin, imax, jmin, jmax)) {
				for (i = imin; i <= imax; i++) {
					System.out.print(arr[i][j] + " ");
				}
				i = imax;
			}

			System.out.println();
			if (checkbox(i, j + 1, imin, imax, jmin, jmax)) {
				for (j = jmin + 1; j <= jmax; j++) {
					System.out.print(arr[i][j] + " ");
				}
				j = jmax;
			}

			System.out.println();
			if (checkbox(i - 1, j, imin, imax, jmin, jmax)) {
				for (i = i - 1; i >= imin; i--) {
					System.out.print(arr[i][j] + " ");
				}
				i = imin;
			}
			
			System.out.println();
			if (checkbox(i, j - 1, imin, imax, jmin, jmax)) {
				for (j = j - 1; j >= jmin + 1; j--) {
					System.out.print(arr[i][j] + " ");
				}
				j = jmin;
			}

			System.out.println();

			imin++;
			imax--;
			jmin++;
			jmax--;
		}
	}

	public static boolean checkbox(int i, int j, int imin, int imax, int jmin, int jmax) {
		if (i >= imin && i <= imax && j <= jmax && j >= jmin) {
			return true;
		}
		return false;
	}

}
