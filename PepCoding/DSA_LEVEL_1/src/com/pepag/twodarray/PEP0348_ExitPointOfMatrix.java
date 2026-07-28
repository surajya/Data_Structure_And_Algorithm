package com.pepag.twodarray;

class Ans {

	int i;
	int j;

	public Ans(int i, int j) {
		this.i = i;
		this.j = j;
	}
}


public class PEP0348_ExitPointOfMatrix {

	public static void main(String[] args) {
		int[][] arr = {
				{1, 0, 1, 0},
				{1, 0, 0, 1},
				{0, 1, 0, 0},
				{0, 0, 1, 1}
		};

		Ans ans = exitPoint(arr, 0, 0, "up");
		System.out.println("i = " + ans.i + "\nj = " + ans.j);

		easyExistPoint(arr);
	}


	private static Ans exitPoint(int[][] arr, int i, int j, String dir) {
		if (checkPosition(arr, i, j)) {
			if (arr[i][j] == 1) {
				switch (dir) {
					case "up":
						return exitPoint(arr, i, j + 1, "right");


					case "right":
						return exitPoint(arr, i + 1, j, "down");


					case "down":
						return exitPoint(arr, i, j - 1, "left");


					case "left":
						return exitPoint(arr, i - 1, j, "up");

				}
			} else {
				switch (dir) {
					case "up":
						return exitPoint(arr, i - 1, j, "up");


					case "right":
						return exitPoint(arr, i, j + 1, "right");


					case "down":
						return exitPoint(arr, i + 1, j, "down");


					case "left":
						return exitPoint(arr, i, j - 1, "left");


				}
			}
		}
		return checkbox(i, j, dir);
	}


	private static boolean checkPosition(int[][] arr, int i, int j) {
		int m = arr.length, n = arr[0].length;
		if (i >= 0 && i < m && j >= 0 && j < n) {
			return true;
		}
		return false;
	}



	public static Ans checkbox(int i, int j, String dir) {
		Ans ans = null;
		switch (dir) {
			case "up":
				ans = new Ans(i + 1, j);
				break;

			case "right":
				ans = new Ans(i, j - 1);
				break;

			case "down":
				ans = new Ans(i - 1, j);
				break;

			case "left":
				ans = new Ans(i, j + 1);
				break;

		}
		return ans;
	}

	public static void easyExistPoint(int[][] arr) {
		// dir -> 0:east, 1:south, 2:west, 3:north
		int i = 0, j = 0, dir = 3, m = arr.length, n = arr[0].length;
		while (i < m && i >= 0 && j < n && j >= 0) {
			if (arr[i][j] == 1) {
				dir = (dir + 1) % 4;
			}
			switch (dir) {
				case 0:
					j++;
					break;
				case 1:
					i++;
					break;
				case 2:
					j--;
					break;
				case 3:
					i--;
					break;
			}
		}
		switch (dir) {
			case 0:
				j--;
				break;
			case 1:
				i--;
				break;
			case 2:
				j++;
				break;
			case 3:
				i++;
				break;
		}

		System.out.println("after sorted formate :: \ni = " + i + "\nj = " + j);

	}

}
