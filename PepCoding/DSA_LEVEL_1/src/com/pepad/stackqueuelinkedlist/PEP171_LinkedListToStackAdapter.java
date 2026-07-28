package com.pepad.stackqueuelinkedlist;

import java.util.Scanner;

public class PEP171_LinkedListToStackAdapter {
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
					"PLZ select the operation ->  1 : SIZE \t 2 : DISPLAY \t 3 : PUSH \t 4 : PEEK  \t 5 : POP \t 0 : EXIT");

			int index = Integer.parseInt(sc.nextLine());

			switch (index) {

				case 0 :
					System.out.println("We will meet again, Good By !!!");
					System.exit(0);
					break;

				case 1 :
					System.out.println(
							"Size of Stack: " + linkedlist.sz + "\n");
					break;

				case 2 :

					PEP150_Node test = linkedlist.head;
					if (test == null) {
						System.out.println("Stack is empty!! \n");
						break;
					}
					System.out.print("Element of Stack: ");
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
					System.out.println("Enter the element to push: ");
					int a = Integer.parseInt(sc.nextLine());
					PEP150_Node node = new PEP150_Node();
					node.data = a;
					node.next = null;

					if (linkedlist.sz == 0) {
						linkedlist.head = node;
						linkedlist.tail = node;
						linkedlist.sz = 1;
					} else {
						linkedlist.tail.next = node;
						linkedlist.tail = node;
						linkedlist.sz += 1;
					}
					break;

				case 4 :
					if (linkedlist.head == null) {
						System.out.println(
								"Stack has no element, before deletion pls push some data");
					} else {
						System.out.println("First element from Stack : "
								+ linkedlist.tail.data);
					}
					break;

				case 5 :
					if (linkedlist.head == null) {
						System.out.println(
								"Stack has no element, before deletion pls add some data");
					} else {
						System.out.println("pop value from Stack is : "
								+ linkedlist.tail.data);
						if (linkedlist.sz == 1) {
							linkedlist.head = null;
							linkedlist.tail = null;
						} else {
							PEP150_Node testNode = linkedlist.head;
							while (testNode.next.next != null) {
								testNode = testNode.next;
							}
							linkedlist.tail = testNode;
							testNode.next = null;
						}
						linkedlist.sz -= 1;
					}
					break;

				default :
					System.out.println("Your Input is incorrect, pls check");
			}

		}
	}
}
