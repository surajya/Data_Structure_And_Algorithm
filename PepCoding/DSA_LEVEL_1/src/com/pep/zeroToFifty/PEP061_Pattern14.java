package com.pep.zeroToFifty;

import java.util.Scanner;

public class PEP061_Pattern14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the row");
		Scanner sc=new Scanner(System.in);
		int a= Integer.parseInt(sc.nextLine());
		for(int i=1; i<=10; i++) {
			System.out.println(a+" * "+i+" = "+a*i);
		}
	}

}
