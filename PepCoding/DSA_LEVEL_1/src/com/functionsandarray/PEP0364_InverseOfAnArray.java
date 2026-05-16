package com.functionsandarray;

import java.util.Arrays;

public class PEP0364_InverseOfAnArray {

	public static void main(String[] args) {
		int[] arr = {3, 4, 0, 5, 2, 1};

		//				rotateArray(arr, 2);
		//				display(arr);
		System.out.println("Reduce the time complexity with help of size");
		inverseArray(arr, 0, arr[0]);
		display(arr);
	}

	private static void inverseArray(int[] arr, int i, int prevValue) {
		int temp = arr[i];
		arr[i] = prevValue;
		prevValue = i;
		i = temp;
		if (i == 0) {
			arr[i] = prevValue;
			return;
		}
		inverseArray(arr, i, prevValue);
	}

	private static void display(int[] arr) {
		Arrays.stream(arr).forEach(i -> System.out.println(" " + i));
	}

}