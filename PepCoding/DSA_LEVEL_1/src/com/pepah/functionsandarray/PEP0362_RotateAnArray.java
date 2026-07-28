package com.pepah.functionsandarray;

import java.util.Arrays;
import java.util.stream.IntStream;

public class PEP0362_RotateAnArray {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};

		//				rotateArray(arr, 2);
		//				display(arr);
		System.out.println("Reduce the time complexity with help of size");
		rotateInLessTime(arr, 3);
		display(arr);
	}

	private static void rotateInLessTime(int[] arr, int totalRotation) {
		int arrSize = arr.length;
		int reqRotation = (arrSize - totalRotation) % arrSize;
		int[] helperArr = new int[arrSize];
		IntStream.range(0, arrSize).forEach(i -> {
			helperArr[(i + reqRotation) % arrSize] = arr[i];
		});
		IntStream.range(0, arrSize).forEach(i -> {
			arr[i] = helperArr[i];
		});

	}

	private static void rotateArray(int[] arr, int totalRotation) {
		int arrSize = arr.length;
		int reqRotation = totalRotation % arrSize;
		IntStream.range(0, reqRotation).forEach(j->
		{
			int firstValue = arr[0];
			IntStream.range(0, arrSize - 1).forEach(i -> {
				arr[i] = arr[i + 1];
			});
			arr[arrSize - 1] = firstValue;
		});
		
	}

	private static void display(int[] arr) {
		Arrays.stream(arr).forEach(System.out::println);
	}

}