package com.pepad.stackqueuelinkedlist;

import java.util.Scanner;

public class PEP137_BuildNormalStack {

	public static int capacity;
	public static int len = -1;

	public static void push(int[] arr, int a) {
		if (len >= capacity-1)
			System.out.println("StackOverFlow !!!\n");
		else {
			arr[++len] = a;
			System.out.println("Value add successfully\n");
		}
	}

	public static int pop(int[] arr) {
		if (len == -1) {
			System.out.println("StackUnderFlow !!!\n");
			return -1;
		} else {
			int x = arr[len];
			len--;
			return x;
		}
	}

	public static int top(int[] arr) {
		if (len == -1) {
			System.out.println("StackUnderFlow !!!");
			return -1;
		} else {
			int x = arr[len];
			return x;
		}
	}

	public static int size() {
		if (len == -1) {
			System.out.println("Array Size is ZERO !!");
			return -1;
		} else {
			return len+1;
		}
	}

	public static void display(int[] arr) {
		if (len == -1) {
			System.out.println("Array is empty !!");
		} else {
			for (int i = 0; i <= len; i++)
				System.out.print(arr[i] + " ");
			System.out.println();
		}
	}

	public static void main(String[] args) {
		System.out.println("Your welcome in STACK DATA STRUCTURE");
		System.out.println("Enter the size of Stack : ");
		Scanner sc = new Scanner(System.in);
		capacity = Integer.parseInt(sc.nextLine());
		int[] arr = new int[capacity];
		
		
		while (true) {
			System.out.println(
					"PLZ inter value \n 1 : PUSH \t 2 : POP \t 3 : TOP \t 4 : SIZE \t 5 : DISPLAY \t 0 : EXIT");

			int index = Integer.parseInt(sc.nextLine());

			switch (index) {

			case 0:
				System.out.println("We will meet again, Good By !!!");
				System.exit(0);

			case 1:
				System.out.print("Enter the value: ");
				push(arr, Integer.parseInt(sc.nextLine()));
				break;

			case 2:
				int a=pop(arr);
				if(a!=-1) System.out.println("pop value is : "+a+"\n");
				break;

			case 3:
				a=top(arr);
				if(a!=-1) System.out.println("top value is : "+a+"\n");
				break;

			case 4:
				a=size();
				if(a!=-1) System.out.println("size of array is : "+a+"\n");
				break;

			case 5:
				display(arr);
				break;

			default:
				System.out.println("Invalid value ! \n PLZ Inter value between 0 to 5 only");

			}

		}
	}

}
