package com.pep.zeroToFifty;

import java.util.Scanner;

public class PEP027_GCDandLCM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter FIRST number: ");
		int num1 = Integer.parseInt(sc.nextLine());
		System.out.println("Enter SECOND number: ");
		int num2 = Integer.parseInt(sc.nextLine());
		int GCD=findGCD(num1,num2);
		System.out.println("GCD IS: "+GCD);
		int LCM=(num1 * num2)/GCD;
		System.out.println("LCM IS: "+LCM);
	}
	
	public static int findGCD(int num1, int num2) {
		
		while(true) {
			if(num1<=num2) {
				if(num2%num1==0) return num1;
				num2=num2%num1;
			}else {
				if(num1%num2==0) return num2;
				num1=num1%num2;
			}
		}
	}

}
