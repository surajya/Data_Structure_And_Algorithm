package com.digit.seventyfiveTOninty;

import java.util.Scanner;

public class PEP089_anyBaseMultiplication {
	
	public static long findSum(int base, int numA, int numB) {
		long ans=0, carry=0, sum=0, i=1;
		while(numA>0 || numB>0 || carry>0) {
			if(numA%10>=base || numB%10>=base) {
				System.out.println("Input is wrong!!.........");
				System.exit(0);
			}
			sum=(numA%10)+(numB%10)+carry;
			carry=0;
			if(sum>=base) {
				sum=sum%base;
				carry=1;
			}
			ans +=sum*i;
			i*=10;
			numA/=10; numB/=10;
		}
		
		
		return ans;
	}
	
	public static long findMult(int base, int numA, int numB) {
		int ans=0, mult=0, tempA=numA, tempB=numB, remA=0, remB=0, carry=0, i=1;
		while(tempA>0) {
			tempB=numB;
			remA=tempA%10;
			tempA/=10;
			int j=i;
			mult=0;
			while(tempB>0 || carry>0) {
				remB=tempB%10;
				int sum=remA*remB+carry;
				carry=0;
				if(sum>=base) {
					carry=sum/base;
					sum=sum%base;
				}
				mult +=sum*j;
				j*=10;
				tempB/=10;
			}
			i*=10;
			ans=(int)findSum(base,ans,mult);
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
		
		System.out.println("Multiplication of "+numA+" and "+numB+" of base: "+base+" is: "+findMult(base, numA, numB));
	}

}
