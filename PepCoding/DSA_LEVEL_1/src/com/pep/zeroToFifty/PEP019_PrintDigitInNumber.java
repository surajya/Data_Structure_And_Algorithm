package com.pep.zeroToFifty;

import java.util.Scanner;

public class PEP019_PrintDigitInNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number: ");
		int num = Integer.parseInt(sc.nextLine());
		int num1=num;
		int count=0;
		while(num>0) {
			count++;
			num/=10;
		}
		
		int a=(int)(Math.pow(10, count-1));
		
		while(num1>0) {
			int rem=num1/a;
			num1%=a;
			a/=10;
			System.out.println(rem);
		}
	}

}
