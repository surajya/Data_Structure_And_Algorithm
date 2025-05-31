package com.pep.zeroToFifty;

import java.util.Scanner;

public class PEP015_AllFibonacciNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter how many you want print febonacci number: ");
		int num = Integer.parseInt(sc.nextLine());
		int a=0, b=1;
		while(num-->0) {
			if(a<0) {
				System.out.println("System in dangor.....");
				System.exit(0);
			}
			System.out.println(a);
			int c=a+b;
			a=b;
			b=c;
			
		}
		System.out.println("all are done.........");
	}

}
