package com.pepai.recursion;

import java.util.ArrayList;

public class PEP0396_AllIndexOfOccurance {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 8, 5, 6, 7, 8, 9};
		ArrayList<Integer> list = new ArrayList<>();
		int[] indxArr = firstindeInArray(arr, 0, 0);
		for (int a : indxArr) {
			System.out.println(a);
		}

	}

	public static int[] firstindeInArray(int[] arr, int indx, int fsf) {
		if (indx == arr.length) {
			return new int[fsf];
		}

		if (arr[indx] == 8) {
			fsf++;
		}
		int[] indxArr = firstindeInArray(arr, indx + 1, fsf);
		if (arr[indx] == 8) {
			indxArr[--fsf] = indx;
		}
		return indxArr;
	}

}
