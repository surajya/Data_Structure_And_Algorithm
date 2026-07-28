package com.pepad.stackqueuelinkedlist;

import java.util.Scanner;

public class PEP157_GetValueFromLinkedList {
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
					"PLZ select the operation ->  1 : SIZE \t 2 : DISPLAY \t 3 : ADD \t 4 : GetFirst \t 5 : GetLast \t 6 : GetAtIndex \t 0 : EXIT");

			int index = Integer.parseInt(sc.nextLine());

			switch (index) {

				case 0 :
					System.out.println("We will meet again, Good By !!!");
					System.exit(0);
					break;

				case 1 :
					System.out.println(
							"Size of linkedlist: " + linkedlist.sz + "\n");
					break;

				case 2 :

					PEP150_Node test = linkedlist.head;
					if (test == null) {
						System.out.println("linkedlist is empty!! \n");
						break;
					}
					System.out.print("Element of linkedlist: ");
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
					System.out.println("Enter the element to add at End: ");
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
								"Linked list has no element, before deletion pls add some data");
					} else {
						System.out.println("First element from linked list : "
								+ linkedlist.head.data);
					}
					break;

				case 5 :
					if (linkedlist.head == null) {
						System.out.println(
								"Linked list has no element, before deletion pls add some data");
					} else {
						PEP150_Node testGetLast = linkedlist.head;
						while (testGetLast.next != null) {
							testGetLast = testGetLast.next;
						}
						System.out.println("Last element from linked list : "
								+ testGetLast.data);
					}
					break;

				case 6 :
					if (linkedlist.head == null) {
						System.out.println(
								"Linked list has no element, before deletion pls add some data");
					} else {
						System.out.println("Enter the index : ");
						int indx = Integer.parseInt(sc.nextLine());
						if (indx > linkedlist.sz) {
							System.out.println(
									"Linked list size is less than your index!!!");
						}
						PEP150_Node testGetLast = linkedlist.head;
						int testIndx = indx;
						while (--testIndx >= 1) {
							testGetLast = testGetLast.next;
						}
						System.out.println("linked list value "
								+ testGetLast.data + " at index " + indx);
					}
					break;

				default :
					System.out.println("Your Input is incorrect, pls check");
			}

		}
	}
}
