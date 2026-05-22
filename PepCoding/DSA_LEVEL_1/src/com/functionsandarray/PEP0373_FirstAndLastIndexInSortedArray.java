package com.functionsandarray;

public class PEP0373_FirstAndLastIndexInSortedArray {

	public static void main(String[] args) {
		int[] arr = {10, 20, 20, 20, 50, 60, 60, 60, 70, 70};
		int value = 20;
		System.out.println("first index: " + firstIndexOfElementEaisyWay(arr, value));
		System.out.println("last index: " + lastIndexOfElementEaisyWay(arr, value));

	}

	private static int firstIndexOfElementEaisyWay(int[] arr, int value) {
		int low = 0, high = arr.length - 1, len = arr.length - 1, last = Integer.MIN_VALUE;
		while (low <= high) {
			int med = (low + high) / 2;
			if (arr[med] == value) {
				last = med;
				if (med > 0) {
					high = med - 1;
				} else {
					break;
				}
			} else if (arr[med] > value) {
				high = med - 1;
			} else {
				low = med + 1;
			}
		}
		return last;
	}

	private static int lastIndexOfElementEaisyWay(int[] arr, int value) {
		int low = 0, high = arr.length - 1, len = arr.length - 1, last = Integer.MAX_VALUE;
		while (low <= high) {
			int med = (low + high) / 2;
			if (arr[med] == value) {
				last = med;
				if (med < len) {
					low = med + 1;
				} else {
					break;
				}
			} else if (arr[med] > value) {
				high = med - 1;
			} else {
				low = med + 1;
			}
		}
		return last;
	}

}