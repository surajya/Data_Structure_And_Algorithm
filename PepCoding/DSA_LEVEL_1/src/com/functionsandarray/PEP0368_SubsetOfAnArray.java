package com.functionsandarray;

public class PEP0368_SubsetOfAnArray {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3};

		System.out.println("subarray of an array");
		subArray(arr);
	}

	private static void subArray(int[] arr) {
		for (int i = 0; i < Math.pow(2, arr.length); i++) {
			String binString = convertBinary(i, arr.length);
			for (int j = 0; j < arr.length; j++) {
				if (binString.charAt(j) == '1') {
					System.out.print(arr[j] + " ");
				}
			}
			System.out.println();
		}
	}

	private static String convertBinary(int num, int len) {
		StringBuffer bin = new StringBuffer();
		for (int i = 0; i < len; i++) {
			bin.append(num % 2 + "");
			num /= 2;
		}
		return bin.toString();
	}

}