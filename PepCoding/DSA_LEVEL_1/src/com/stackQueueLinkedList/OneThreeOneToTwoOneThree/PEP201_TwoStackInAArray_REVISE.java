package com.stackQueueLinkedList.OneThreeOneToTwoOneThree;

import java.util.Scanner;

public class PEP201_TwoStackInAArray_REVISE {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] arr = new int[6];
		int st1 = -1, st2 = -1;

		while (true) {
			System.out.println(
					"\"PLZ select the operation -> 0 : Exit \t  1 : POP1 \t 2 : PUSH1 \t 3 : TOP1 \t 4 : POP2 \t 5 : PUSH2 \t 6 : TOP2");
			int op = Integer.parseInt(scanner.nextLine());
			switch (op) {
				case 0:
					scanner.close();
					System.exit(0);
				case 1:
					if (st1 == -1) {
						System.out.println("Stack-1 is underflow!!!!!!");
					} else {
						System.out.println("Pop value from Stack-1 : " + arr[st1--]);
					}
					break;
				case 2:
					if (st2 - st1 == 1) {
						System.out.println("Stack-1 is Overflow!!!!!");
					} else {
						System.out.println("Enter the value : ");
						arr[++st1] = Integer.parseInt(scanner.nextLine());
					}
					break;
				case 3:
					if (st1 == -1) {
						System.out.println("Stack-1 is underflow!!!!!!");
					} else {
						System.out.println("Top value from Stack-1 : " + arr[st1]);
					}
					break;
				case 4:
					if (st2 == -1) {
						System.out.println("Stack-2 is underflow!!!!!!");
					} else {
						System.out.println("Pop value from Stack-1 : " + arr[st2++]);
						if (st2 == 6) {
							st2 = -1;
						}
					}
					break;
				case 5:
					if (st2 - st1 == 1) {
						System.out.println("Stack-2 is Overflow!!!!!");
					} else {
						st2 = st2 == -1 ? 5 : --st2;
						System.out.println("Enter the value : ");
						arr[st2] = Integer.parseInt(scanner.nextLine());
					}
					break;
				case 6:
					if (st2 == -1) {
						System.out.println("Stack-2 is underflow!!!!!!");
					} else {
						System.out.println("Pop value from Stack-1 : " + arr[st2]);
					}
					break;
				default:
					System.out.print("PLZ Select correct operation b/w 1-6");
			}
		}
	}

}
