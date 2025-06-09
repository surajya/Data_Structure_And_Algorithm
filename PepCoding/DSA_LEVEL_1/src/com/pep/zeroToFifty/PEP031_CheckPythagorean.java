package com.pep.zeroToFifty;

import java.util.Scanner;

public class PEP031_CheckPythagorean {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter all three number: ");
		int num1 = Integer.parseInt(sc.nextLine());
		int num2 = Integer.parseInt(sc.nextLine());
		int num3 = Integer.parseInt(sc.nextLine());
		boolean check=num1>num2?  (num1>num3?(num1*num1)==((num2*num2)+(num3*num3)):(num3*num3)==((num2*num2)+(num1*num1)))  :  (num2>num3?(num2*num2)==((num1*num1)+(num3*num3)):(num3*num3)==((num2*num2)+(num1*num1)));
		System.out.println(num1+", "+num2+", "+num3+" are pythagorean: "+check);
	}

}
