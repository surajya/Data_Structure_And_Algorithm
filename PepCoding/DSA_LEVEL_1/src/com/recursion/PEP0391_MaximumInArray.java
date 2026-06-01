package com.recursion;


public class PEP0391_MaximumInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 2, 3, 44, 5, 6, 7, 8, 9};
		System.out.println(maxInArray(arr, 0));
	}

	public static int maxInArray(int[] arr, int indx) {
		if (indx == arr.length - 1) {
			return arr[indx];
		}
		int a = maxInArray(arr, indx + 1);
		return arr[indx] > a ? arr[indx] : a;
	}

}
