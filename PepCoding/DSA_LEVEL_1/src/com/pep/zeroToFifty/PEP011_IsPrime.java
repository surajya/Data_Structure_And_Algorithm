package com.pep.zeroToFifty;

import java.util.Scanner;

public class PEP011_IsPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in); 
		System.out.print("\nHow many number you want to check: ");
		int count = Integer.parseInt(sc.nextLine());
		while(count-->0) {
			System.out.print("Enter number : ");
			int num = Integer.parseInt(sc.nextLine());
			if(num<2) {
				System.out.println("Input is not correct....");
				continue;
			}
			boolean check=isPrime(num);
			if(check) System.out.println("Given number: "+num+" is a prime number");
			else System.out.println("Gieven number: "+num+" is not a prime number");
		}
	}
	public static boolean isPrime(int x) {
		//int num=(int) Math.sqrt(x);i
		int num=nearSquareRoot(x);
		
		while(num>1) {
			if(x%num==0) return false;
			num--;
		}
		return true;
	}
	
	public static int nearSquareRoot(int a) {
		int i=1, j=a;
		
		while(i<=j) {
			if(i+1==j) return i;
			int mid=(i+j)/2;
			if(mid*mid>a) j=mid;
			else if(mid*mid<a) i=mid;
			else if(mid*mid==a) return mid;
			//System.out.println(mid);
		}
		return 0;
	}

}
