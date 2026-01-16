package com.stackQueueLinkedList.OneThreeOneToTwoOneThree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class PEP196_QueueToStackPushEfficient {

	static Scanner sc = new Scanner(System.in);
	static Queue<Integer> mainq = new ArrayDeque<>();
	static Queue<Integer> helperq = new ArrayDeque<>();

	public static void main(String[] args) {
		while (true) {
			System.out.println("\"PLZ select the operation on STACK -> 0 : Exit \t  1 : POP \t 2 : PUSH \t 3 : TOP");
			int a = Integer.parseInt(sc.nextLine());

			switch (a) {
				case 0:
					System.exit(0);

				case 1:
					if (mainq.isEmpty()) {
						System.out.println("Hi, stack is empty. Pop operation  can not be performed");
					} else {
						while (mainq.size() > 1) {
							helperq.add(mainq.poll());
						}
						System.out.println("Pop element is: " + mainq.poll());
						while (!helperq.isEmpty()) {
							mainq.add(helperq.poll());
						}
					}
					break;

				case 2:
					System.out.println("Enter element: ");
					int num = Integer.parseInt(sc.nextLine());
					mainq.add(num);

					break;

				case 3:
					if (mainq.isEmpty()) {
						System.out.println("Hi, stack is empty. Pop operation  can not be performed");
					} else {
					while (mainq.size() > 1) {
						helperq.add(mainq.poll());
					}
					System.out.println("Pop element is: " + mainq.peek());
					helperq.add(mainq.poll());
					while (!helperq.isEmpty()) {
						mainq.add(helperq.poll());
					}
				}

				default:
					break;
			}

		}
	}
}
