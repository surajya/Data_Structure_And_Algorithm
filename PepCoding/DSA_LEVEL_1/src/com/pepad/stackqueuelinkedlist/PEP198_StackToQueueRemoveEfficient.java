package com.pepad.stackqueuelinkedlist;

import java.util.Scanner;
import java.util.Stack;

public class PEP198_StackToQueueRemoveEfficient {

	static Scanner sc = new Scanner(System.in);
	static Stack<Integer> mainq = new Stack<>();
	static Stack<Integer> helperq = new Stack<>();

	public static void main(String[] args) {
		while (true) {
			System.out
					.println("\"PLZ select the operation on QUEUE -> 0 : Exit \t  1 : Remove \t 2 : PUSH \t 3 : First");
			int a = Integer.parseInt(sc.nextLine());

			switch (a) {
				case 0:
					System.exit(0);

				case 1:
					if (mainq.isEmpty()) {
						System.out.println("Hi, queue is empty. remove operation  can not be performed");
					} else {

						System.out.println("Pop element is: " + mainq.pop());
					}
					break;

				case 2:
					System.out.println("Enter element: ");
					int num = Integer.parseInt(sc.nextLine());
					while (!mainq.isEmpty()) {
						helperq.add(mainq.pop());
					}
					mainq.push(num);
					while (!helperq.isEmpty()) {
						mainq.add(helperq.pop());
					}
					break;

				case 3:
					if (mainq.isEmpty()) {
						System.out.println("Hi, queue is empty. Pop operation  can not be performed");
					} else {
						System.out.println("Top element is: " + mainq.peek());
					}

				default:
					break;
			}

		}
	}
}
