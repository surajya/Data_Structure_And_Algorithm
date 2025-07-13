package com.stackQueueLinkedList.OneThreeOneToTwoOneThree;

import java.util.Scanner;
import java.util.Stack;

public class PEP141_MinimumStack1 {
	

	public static void main(String[] args) {
		
		Stack<Integer> allData = new Stack<Integer>();
		Stack<Integer> minData = new Stack<Integer>();
		Scanner sc=new Scanner(System.in);
		Integer min=Integer.MAX_VALUE;
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
				allData.add(a);
				if(minData.isEmpty()) minData.add(a);
				else {
					if(minData.peek()>=a) minData.add(a);
				}
				break;

			case 2:
				if(allData.isEmpty()) System.out.println("Stack is Empty !!!\n");
				else {
					a=allData.peek();
					if(a==minData.peek()) minData.pop();
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
				else System.out.println("Minimum element is : "+minData.peek());
				break;
				
			default:
				System.out.println("Invalid value ! \n PLZ Inter value between 0 to 5 only");

			}

		}

	}

}
