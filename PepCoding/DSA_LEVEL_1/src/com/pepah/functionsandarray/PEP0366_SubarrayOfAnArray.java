package com.pepah.functionsandarray;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class PEP0366_SubarrayOfAnArray {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3};

		System.out.println("subarray of an array");
		subArray(arr);
	}

	private static void subArray(int[] arr) {
		IntStream.range(0, arr.length).forEach(i -> {
			List<Integer> list = new ArrayList<>();
			IntStream.range(i, arr.length).forEach(j -> {
				list.add(arr[j]);
				System.out.println(list);
			});

		});
	}

}