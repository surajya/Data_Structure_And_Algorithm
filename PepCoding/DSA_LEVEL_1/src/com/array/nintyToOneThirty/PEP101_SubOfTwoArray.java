package com.array.nintyToOneThirty;

import java.util.Scanner;

public class PEP101_SubOfTwoArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arrB= {2,5,4,9,2};
		int[] arrA= {9,6,4,8,3,2,7,5};
		int lenA=arrA.length-1, lenB=arrB.length-1, sum=0, carry=0;
		String str="";
		while(lenA>=0 || lenB>=0 || carry<0) {
			if(lenA>=0 && lenB>=0) {
				if(arrA[lenA]+carry>=arrB[lenB]) {sum=arrA[lenA--]-arrB[lenB--]+carry; carry=0;}
				else {sum=arrA[lenA--]+10-arrB[lenB--]+carry; carry =-1;}
			}
			else if(lenA>=0) {sum=arrA[lenA--]+carry; carry=0;}
			if(sum>=10) {
				str=sum%10 +str;
				carry=1;
			}else str=sum+str;
		}
		System.out.println(str);
	}
}
