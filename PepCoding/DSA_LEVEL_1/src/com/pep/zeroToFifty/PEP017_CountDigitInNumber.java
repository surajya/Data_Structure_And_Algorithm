package com.pep.zeroToFifty;

import java.util.Scanner;

public class PEP017_CountDigitInNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number: ");
		int num = Integer.parseInt(sc.nextLine());
		int count=0;
		while(num>0) {
			count++;
			num/=10;
		}
		System.out.println("Total number of digit in "+num+" is: "+count);
	}

}
