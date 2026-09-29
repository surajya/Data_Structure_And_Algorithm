package com.pepam.dp.tabulation;

public class PEP0487_CountBinaryString {

	public static void main(String[] args) {
		int czeros = 1, cones = 1;
		int bsLength = 6;
		while (bsLength-- > 1) {
			int dummycOnes = cones;
			cones = czeros + cones;
			czeros = dummycOnes;
		}
		System.out.println("Possible binary string is : " + (czeros + cones));
	}

}
