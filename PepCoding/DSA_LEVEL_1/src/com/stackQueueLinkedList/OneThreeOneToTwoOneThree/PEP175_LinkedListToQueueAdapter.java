package com.stackQueueLinkedList.OneThreeOneToTwoOneThree;

import java.util.Scanner;

public class PEP175_LinkedListToQueueAdapter {
	static Scanner sc = new Scanner(System.in);
	static PEP151_LinkedList linkedlist;

	static void initLinkedList() {
		linkedlist = new PEP151_LinkedList();
		linkedlist.head = null;
		linkedlist.tail = null;
		linkedlist.sz = 0;
	}

	public static void main(String[] args) {
		initLinkedList();
		while (true) {
			System.out.println(
					"PLZ select the operation ->  1 : SIZE \t 2 : DISPLAY \t 3 : CreateLinkedList \t 4 : FindTheKthElementFromTheEndOfLInkedList \t 0 : EXIT");

			int index = Integer.parseInt(sc.nextLine());

			switch (index) {

				case 0 :
					System.out.println("We will meet again, Good By !!!");
					System.exit(0);
					break;

				case 1 :
					System.out.println(
							"Size of Queue: " + linkedlist.sz + "\n");
					break;

				case 2 :
					PEP150_Node test = linkedlist.head;
					if (test == null) {
						System.out.println("linkedlist is empty!! \n");
						break;
					}
					System.out.print("Element of Queue: ");
					while (test != null) {
						if (test.next == null) {
							System.out.print(test.data);
						} else {
							System.out.print(test.data + " -> ");
						}
						test = test.next;
					}
					System.out.println();
					break;

				case 3 :
					for (int i = 10; i <= 20; i++) {
						PEP150_Node node = new PEP150_Node();
						node.data = i;
						node.next = null;
						if (linkedlist.head == null) {
							linkedlist.head = node;
							linkedlist.tail = node;
							linkedlist.sz = 1;
						} else {
							linkedlist.tail.next = node;
							linkedlist.tail = node;
							linkedlist.sz += 1;
						}
					}
					break;

				case 4 :
					System.out.println("Enter the Kth Index from end: ");
					int a = Integer.parseInt(sc.nextLine());
					if (linkedlist.head == null) {
						System.out.println(
								"linkedlist has no element, before deletion pls add some data");
					} else if (a > linkedlist.sz) {
						System.out
								.println("index is out of bound of linkedlist");
					} else {
						PEP150_Node testNode = linkedlist.head;
						while (linkedlist.sz - a != 0) {
							a++;
							testNode = testNode.next;
						}
						System.out.println(a
								+ "th Element From The End Of LInkedList is : "
								+ testNode.data);
					}
					break;

				default :
					System.out.println("Your Input is incorrect, pls check");
			}

		}
	}
}
