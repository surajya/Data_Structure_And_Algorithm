package com.pep.zeroToFifty;

import java.util.Scanner;

public class PEP021_ReverseNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number: ");
		int num = Integer.parseInt(sc.nextLine());
		while(num>0) {
			int rem=num%10;
			num/=10;
			System.out.println(rem);
		}
	}

}
