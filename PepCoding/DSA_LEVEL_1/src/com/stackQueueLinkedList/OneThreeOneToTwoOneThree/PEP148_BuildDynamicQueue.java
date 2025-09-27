package com.stackQueueLinkedList.OneThreeOneToTwoOneThree;

import java.util.Scanner;

public class PEP148_BuildDynamicQueue {
	static Scanner sc = new Scanner(System.in);
	static int[] allData;
	static int sizeq;

	static void initQueue() {
		System.out.println("Enter the size of queue: ");
		sizeq = Integer.parseInt(sc.nextLine());
		allData = new int[sizeq];
	}

	static int getSize(int front, int rear) {
		if (front == -1)
			return 0;
		else if (rear >= front)
			return rear - front + 1;
		else
			return sizeq - front + rear + 1;
	}

	public static void main(String[] args) {
		initQueue();
		int front = -1, rear = -1;

		while (true) {
			System.out.println(
					"PLZ select the operation ->  1 : SIZE \t 2 : DISPLAY \t 3 : ADD \t 4 : REMOVE \t 5 : PEEK \t 0 : EXIT");

			int index = Integer.parseInt(sc.nextLine());

			switch (index) {

			case 0:
				System.out.println("We will meet again, Good By !!!");
				System.exit(0);

			case 1:
				System.out.println("Size of queue: " + getSize(front, rear) + "\n");
				break;

			case 2:
				if (getSize(front, rear) != 0) {
					System.out.print("Element of queue: ");
					if (rear >= front) {
						for (int i = front; i <= rear; i++) {
							System.out.print(allData[i] + "  ");
						}
					} else {
						int x = front;
						do {
							System.out.print(allData[x] + "  ");
							x = (x + 1) % sizeq;
						} while (x-1 != rear);
					}
					System.out.println();
				} else {
					System.out.println("Queue is empty!!! ");
				}
				break;

			case 3:
				System.out.println("Enter the element: ");
				int a = Integer.parseInt(sc.nextLine());
				if (front == -1) {
					rear = 0;
					front = 0;
					allData[rear] = a;
				} else if (getSize(front, rear) != sizeq) {
					rear = (rear + 1) % sizeq;
					allData[rear] = a;
				} else {
					sizeq = 2*sizeq;
					int[] allDataDummy = new int[sizeq];
					int z = 0;
					if (rear >= front) {
						for (int i = front; i <= rear; i++) {
							allDataDummy[z++] = allData[i];
						}
					} else {
						int x = front;
						do {
							allDataDummy[z++] = allData[x];
							x = (x + 1) % sizeq;
						} while (x-1 != rear);
					}
					front = 0;
					rear=z;
					allDataDummy[rear]=a;
					z=0;
					allData = allDataDummy;
					allDataDummy = null;
				}
				break;

			case 4:

				if (getSize(front, rear) == 0) {
					System.out.println("Queue is empty!!!");
				} else {
					System.out.println("Remove element is : " + allData[front]);
					if (front == rear) {
						front = -1;
						rear = -1;
					} else
						front = (front + 1) % sizeq;
				}
				break;

			case 5:
				if (getSize(front, rear) == 0) {
					System.out.println("Queue is empty!!!");
				} else {
					System.out.println(allData[rear]);
				}
				break;

			default:
				System.out.println("Invalid value ! \n PLZ Inter value between 0 to 5 only");

			}

		}

	}

}
