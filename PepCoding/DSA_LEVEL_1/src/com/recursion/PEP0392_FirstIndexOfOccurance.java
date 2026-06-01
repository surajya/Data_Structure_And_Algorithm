package com.recursion;


public class PEP0392_FirstIndexOfOccurance {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 8, 5, 6, 7, 8, 9};
		System.out.println("First index of occurance of 8 is :" + firstindeInArray(arr, 0));
	}

	public static int firstindeInArray(int[] arr, int indx) {
		if (indx == arr.length) {
			return -1;
		}
		if (arr[indx] == 9) {
			return indx;
		}
		return firstindeInArray(arr, indx + 1);
	}

}
