package com.pepah.functionsandarray;

public class PEP0371_CeilAndFloorInSortedArray {

	public static void main(String[] args) {
		int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90};
		ceildAndfloorOfElement(arr, 400);
		ceildAndfloorOfElementEaisyWay(arr, 400);

	}

	private static void ceildAndfloorOfElementEaisyWay(int[] arr, int value) {
		int low = 0, high = arr.length - 1, floor = Integer.MIN_VALUE, ceil = Integer.MAX_VALUE;
		while (low <= high) {
			int med = (low + high) / 2;
			if (arr[med] == value) {
				ceil = floor = arr[med];
			} else if (arr[med] > value) {
				high = med - 1;
				ceil = arr[med];
			} else {
				low = med + 1;
				floor = arr[med];
			}
		}
		System.out.println("ceil value easy way: " + ceil);
		System.out.println("floor value easy way: " + floor);
	}

	private static void ceildAndfloorOfElement(int[] arr, int val) {
		int i = 0, j = arr.length - 1;
		while (i <= j) {
			int med = (i + j) / 2;
			if (arr[med] == val) {

			} else if (arr[med] > val) {
				if (med == 0) {
					System.out.println("ceil value : " + arr[med]);
					System.out.println("floor value : -veInfinite");
					break;
				} else if (arr[med] > val && arr[med - 1] < val) {
					System.out.println("ceil value : " + arr[med]);
					System.out.println("floor value : " + arr[med - 1]);
					break;
				} else {
					j = med - 1;
				}
			} else {
				if (med == arr.length - 1) {
					System.out.println("ceil value : +veInfinite");
					System.out.println("floor value : " + arr[med]);
					break;
				} else if (arr[med] < val && arr[med + 1] > val) {
					System.out.println("ceil value : " + arr[med + 1]);
					System.out.println("floor value : " + arr[med]);
					break;
				} else {
					i = med + 1;
				}
			}
		}
	}

}