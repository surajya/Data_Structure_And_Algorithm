package com.pep.zeroToFifty;

import java.util.Scanner;

public class PEP013_PrintPrimeNumberTillN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in); 
		System.out.print("\nHow many number you want to check: ");
		int count = Integer.parseInt(sc.nextLine());
		long startTime = System.nanoTime();
		while(count-->0) {
			if(count<2) {
				System.out.println("Input is not correct....");
				continue;
			}
			boolean check=isPrime(count);
			if(check) System.out.println("Given number: "+count+" is a prime number");
			else System.out.println("Gieven number: "+count+" is not a prime number");
		}
		long endTime = System.nanoTime();
        long duration = endTime - startTime; // in nanoseconds

        System.out.println("Execution time: " + duration + " nanoseconds");
        System.out.println("Execution time: " + (duration / 1000000) + " milliseconds");
	}
	public static boolean isPrime(int x) {
		//int num=(int) Math.sqrt(x);
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
