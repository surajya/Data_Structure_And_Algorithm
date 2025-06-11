package com.array.nintyToOneThirty;

public class PEP092_ArrayMemory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] one=new int[3];
		one[0]=10; one[1]=20; one[2]=30;
		int[] two=one;
		two[1]=200;
		for(int x:one) {
			System.out.print(x+" ");
		}
	}

}
