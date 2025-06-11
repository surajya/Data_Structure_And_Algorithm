package com.digit.seventyfiveTOninty;

import java.util.Scanner;

public class PEP083_AnyBaseToAnyBase {
	
	public static long convertBase(int num, int initBase, int conBase) {
		long count=0, i=1;
		while(num>0) {
			int rem=num%conBase;
			if(rem>=initBase) {
				System.out.println("Your input is wrong!!");
				System.exit(0);
			}
			count+=i*rem;
			num/=conBase;
			i*=initBase;
		}
		return count;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter your initial base: ");
		int initBase=Integer.parseInt(sc.nextLine());
		System.out.print("Enter your number: ");
		int num=Integer.parseInt(sc.nextLine());
		System.out.print("Enter converted base: ");
		int conBase=Integer.parseInt(sc.nextLine());
		if(initBase==10 || conBase==10) System.out.println("Convert number "+num+" from base "+initBase+" into converted base "+ conBase +" is: "+convertBase(num,initBase, conBase));
		else {
			long conNum=convertBase(num,initBase, 10);
			System.out.println("Convert number "+num+" from base "+initBase+" into converted base "+ conBase +" is: "+convertBase((int)conNum,10, conBase));
		}
	}

}
