package com.pepad.stackqueuelinkedlist;

import java.util.Scanner;
import java.util.Stack;

public class PEP200_StackToQueueAddEfficient {

	static Scanner sc = new Scanner(System.in);
	static Stack<Integer> mainq = new Stack<>();
	static Stack<Integer> helperq = new Stack<>();

	public static void main(String[] args) {
		while (true) {
			System.out.println("\"PLZ select the operation on QUEUE -> 0 : Exit \t  1 : POP \t 2 : PUSH \t 3 : TOP");
			int a = Integer.parseInt(sc.nextLine());

			switch (a) {
				case 0:
					System.exit(0);

				case 1:
					if (mainq.isEmpty()) {
						System.out.println("Hi, queue is empty. Pop operation  can not be performed");
					} else {
						while (mainq.size() > 1) {
							helperq.push(mainq.pop());
						}
						System.out.println("Pop element is: " + mainq.pop());
						while (!helperq.isEmpty()) {
							mainq.push(helperq.pop());
						}
					}
					break;

				case 2:
					System.out.println("Enter element: ");
					int num = Integer.parseInt(sc.nextLine());
					mainq.push(num);

					break;

				case 3:
					if (mainq.isEmpty()) {
						System.out.println("Hi, queue is empty. Pop operation  can not be performed");
					} else {
					while (mainq.size() > 1) {
						helperq.push(mainq.pop());
					}
					System.out.println("Pop element is: " + mainq.peek());
					helperq.push(mainq.pop());
					while (!helperq.isEmpty()) {
						mainq.push(helperq.pop());
					}
				}

				default:
					break;
			}

		}
	}
}
