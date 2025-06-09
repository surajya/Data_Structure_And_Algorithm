package com.pep.zeroToFifty;

import java.util.Scanner;

public class PEP029_PrimeFactorization {

	public static void main(String[] args) {
		System.out.println("Enter the Number: ");
		Scanner sc=new Scanner(System.in);
		int num = Integer.parseInt(sc.nextLine());
		if(num<2) {
			System.out.println("Prime factorization is not defined for numbers less than 2.");
			System.exit(0);
		}
		System.out.print("Prime Factorization of number is: ");
		printPrimeFactorization(num,2);

	}
	public static void printPrimeFactorization(int num, int a) {
		while(num!=1) {
			while(num%a==0) {
				System.out.print(a+" ");
				num/=a;
			}
			a++;
		}
	}
	
//	public static boolean checkPrime(int a) {
//		int sq=(int)Math.sqrt(a);
//		while(sq>1) {
//			if(a%sq==0) return false;
//			sq--;
//		}
//		return true;
//	}
}
