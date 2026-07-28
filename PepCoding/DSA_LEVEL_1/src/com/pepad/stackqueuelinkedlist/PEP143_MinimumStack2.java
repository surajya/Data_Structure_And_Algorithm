package com.pepad.stackqueuelinkedlist;

import java.util.Scanner;
import java.util.Stack;

public class PEP143_MinimumStack2 {
	

	public static void main(String[] args) {
		
		Stack<Integer> allData = new Stack<Integer>();
		int minData =0;
		Scanner sc=new Scanner(System.in);
		int a;
		
		while (true) {
			System.out.println(
					"PLZ inter value \n 1 : PUSH \t 2 : POP \t 3 : TOP \t 4 : SIZE \t 5 : DISPLAY \t 6 : MIN VALUE \t 0 : EXIT");

			int index = Integer.parseInt(sc.nextLine());

			switch (index) {

			case 0:
				System.out.println("We will meet again, Good By !!!");
				System.exit(0);

			case 1:
				System.out.print("Enter the value: ");
				a = Integer.parseInt(sc.nextLine());
				if(allData.isEmpty()) {allData.add(a); minData=a;}
				else if(a>minData) allData.add(a);
				else {
					allData.add(2*a-minData); 
					minData=a;
				}
				break;

			case 2:
				if(allData.isEmpty()) System.out.println("Stack is Empty !!!\n");
				else {
					a=allData.peek();
					if(a<minData) {
					minData = 2*minData-a;
					}
					allData.pop();
				}
				break;

			case 3:
				if(allData.isEmpty()) System.out.println("Stack is Empty !!!\n");
				else System.out.println("Stack Top Value : "+ allData.peek()+"\n");
				break;

			case 4:
				System.out.println("Stack size : "+allData.size());
				break;

			case 5:
				System.out.println("Stack Element : "+allData);
				break;
			
			case 6:
				if(allData.isEmpty()) System.out.println("Stack is Empty !!!\n");
				else System.out.println("Minimum element is : "+minData);
				break;
				
			default:
				System.out.println("Invalid value ! \n PLZ Inter value between 0 to 5 only");

			}

		}

	}

}
