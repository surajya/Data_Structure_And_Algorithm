package com.stackQueueLinkedList.OneThreeOneToTwoOneThree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class PEP194_QueueToStackPopEfficient {

	static Scanner sc = new Scanner(System.in);
	static Queue<Integer> mainq = new ArrayDeque<>();
	static Queue<Integer> helperq = new ArrayDeque<>();

	public static void main(String[] args) {
		while (true) {
			System.out.println("\"PLZ select the operation  on STACK -> 0 : Exit \t  1 : POP \t 2 : PUSH \t 3 : TOP");
			int a = Integer.parseInt(sc.nextLine());

			switch (a) {
				case 0:
					System.exit(0);

				case 1:
					if (mainq.isEmpty()) {
						System.out.println("Hi, stack is empty. Pop operation  can not be performed");
					} else {

						System.out.println("Pop element is: " + mainq.poll());
					}
					break;

				case 2:
					System.out.println("Enter element: ");
					int num = Integer.parseInt(sc.nextLine());
					helperq.add(num);
					while (!mainq.isEmpty()) {
						helperq.add(mainq.poll());
					}
					while (!helperq.isEmpty()) {
						mainq.add(helperq.poll());
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
