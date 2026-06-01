package com.recursion;


public class PEP0394_LastIndexOfOccurance {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 8, 5, 6, 7, 8, 9};
		System.out.println("First index of occurance of 8 is :" + firstindeInArray(arr, 0));
	}

	public static int firstindeInArray(int[] arr, int indx) {
		if (indx == arr.length) {
			return -1;
		}

		int lastIndex = firstindeInArray(arr, indx + 1);
		if (lastIndex != -1) {
			return lastIndex;
		} else if (arr[indx] == 8) {
			return indx;
		}
		return -1;
	}

}
