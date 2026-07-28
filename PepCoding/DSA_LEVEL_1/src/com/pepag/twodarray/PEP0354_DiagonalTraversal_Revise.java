package com.pepag.twodarray;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PEP0354_DiagonalTraversal_Revise {

	public static void main(String[] args) {
		int[][] arr = {
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12},
				{13, 14, 15, 16}
		};
		diagonaleTraversal(arr);
		diagonalTraversalStreamAPI(arr);
		displayAboveMatrix(arr);
		displayBelowMatrix(arr);
	}

	private static void displayAboveMatrix(int[][] arr) {
		int m = arr.length, n = arr[0].length;
		IntStream.range(0, n).forEach(j -> System.out.println(
				IntStream.range(0, n)
						.filter(i -> (i + j) < n)
						.mapToObj(i -> arr[i][i + j] + " ")
						.collect(Collectors.joining())));

	}

	private static void displayBelowMatrix(int[][] arr) {
		int m = arr.length, n = arr[0].length;
		IntStream.range(0, m).forEach(i -> System.out.println(
				IntStream.range(0, n)
						.filter(j -> (i + j) < n)
						.mapToObj(j -> arr[i + j][j] + " ")
						.collect(Collectors.joining())));

	}

	private static void diagonaleTraversal(int[][] arr) {
		int m = arr.length, n = arr[0].length;
		for (int j = 0; j < n; j++) {
			int x = j;
			for (int i = 0; i < m && x < n; i++, x++) {
				System.out.print(arr[i][x] + " ");
			}
			System.out.println();
		}
	}

	private static void diagonalTraversalStreamAPI(int[][] arr) {
		int m = arr.length, n = arr[0].length;

		IntStream.range(0, n).forEach(j -> System.out.println(
				IntStream.range(0, m)
						.filter(i -> (i + j) < n)
						.mapToObj(i -> arr[i][i + j] + " ")
						.collect(Collectors.joining())));
	}

}