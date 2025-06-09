package com.pep.zeroToFifty;

import java.util.Scanner;

public class PEP037_Pattern2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the row");
		Scanner sc=new Scanner(System.in);
		int a= Integer.parseInt(sc.nextLine());
		
		for(int i=a; i>0; i--) {
			for(int j=0; j<i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

}
