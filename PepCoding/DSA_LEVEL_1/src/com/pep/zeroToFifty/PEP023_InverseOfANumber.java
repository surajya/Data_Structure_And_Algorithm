package com.pep.zeroToFifty;

import java.util.Scanner;

public class PEP023_InverseOfANumber {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Your Number: ");
		int num=Integer.parseInt(sc.nextLine());
		int reverse=0, x=1;
		
		while(num>0) {
			int a=num%10;
			int nt= (int)Math.pow(10, a-1);
			reverse+=nt*x;
			x++;
			num/=10;
		}
		System.out.println("reverse number: "+reverse);
	}

}
