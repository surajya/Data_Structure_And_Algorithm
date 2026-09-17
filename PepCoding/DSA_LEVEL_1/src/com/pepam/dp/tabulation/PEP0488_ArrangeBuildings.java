package com.pepam.dp.tabulation;

public class PEP0488_ArrangeBuildings {

	public static void main(String[] args) {
		int spaces = 1, buildings = 1;
		int bsLength = 6;
		while (bsLength-- > 1) {
			int dummybuildings = buildings;
			buildings = spaces + buildings;
			spaces = dummybuildings;
		}
		System.out.println("Possible binary string is : " + ((spaces + buildings) * (spaces + buildings)));
	}

}
