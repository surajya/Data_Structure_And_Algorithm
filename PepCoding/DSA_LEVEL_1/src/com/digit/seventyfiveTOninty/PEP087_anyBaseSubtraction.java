package com.digit.seventyfiveTOninty;

import java.util.Scanner;

public class PEP087_anyBaseSubtraction {
	
	public static long findSub(int base, int numA, int numB) {
		long ans=0, carry=0, sub=0, remA=0, remB=0,i=1;
		while(numA>0 || numB>0 || carry<0) {
			if(numA%10>=base || numB%10>=base) {
				System.out.println("Input is wrong!!.........");
				System.exit(0);
			}
			remA=numA%10+carry; remB=numB%10;
			carry=0;
			if(remA<remB) {
				remA+=base;
				carry=-1;
			}
			sub=remA-remB;
			
			ans +=sub*i;
			i*=10;
			numA/=10; numB/=10;
		}
		
		
		return ans;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter base of number: ");
		int base=Integer.parseInt(sc.nextLine());
		System.out.print("Enter your first number: ");
		int numA=Integer.parseInt(sc.nextLine());
		System.out.print("Enter second number: ");
		int numB=Integer.parseInt(sc.nextLine());
		
		if(numA<numB) {
			int temp =numB;
			numB=numA;
			numA=temp;
		}
		
		System.out.println("Subtraction of "+numA+" and "+numB+" of base: "+base+" is: "+findSub(base, numA, numB));
	}

}
