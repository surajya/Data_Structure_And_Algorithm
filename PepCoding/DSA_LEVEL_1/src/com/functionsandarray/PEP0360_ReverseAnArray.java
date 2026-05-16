package com.functionsandarray;

import java.util.Arrays;
import java.util.stream.IntStream;

public class PEP0360_ReverseAnArray {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4};

		reverseArray(arr);
		display(arr);
	}

	private static void reverseArray(int[] arr) {
		int arrSize = arr.length;
		IntStream.range(0, arrSize / 2).forEach(i -> {
			arr[i] = arr[i] + arr[arrSize - 1 - i];
			arr[arrSize - 1 - i] = arr[i] - arr[arrSize - 1 - i];
			arr[i] = arr[i] - arr[arrSize - 1 - i];
		});
		
	}

	private static void display(int[] arr) {
		Arrays.stream(arr).forEach(System.out::println);
	}

}