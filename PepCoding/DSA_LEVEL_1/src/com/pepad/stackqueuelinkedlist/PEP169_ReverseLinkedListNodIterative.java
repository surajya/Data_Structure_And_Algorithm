package com.pepad.stackqueuelinkedlist;

import java.util.Scanner;

public class PEP169_ReverseLinkedListNodIterative {
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
					"PLZ select the operation ->  1 : SIZE \t 2 : DISPLAY \t 3 : ADD \t 4 : GetFirst  \t 5 : AddFirst  \t 6 : AddAtIndex \t 7 : GetLast \t 8 : GetAtIndex \t 9 : RemoveLastIndex \t 10 : RemoveAtIndex \t 11 : ReverseLinkedListDataIterative \t 12 : ReverseLinkedListNodeIterative \t 0 : EXIT");

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
					System.out.println("Enter the element to add at First: ");
					int a1 = Integer.parseInt(sc.nextLine());
					PEP150_Node node1 = new PEP150_Node();
					node1.data = a1;
					node1.next = null;
					if (linkedlist.sz == 0) {
						linkedlist.head = node1;
						linkedlist.tail = node1;
						linkedlist.sz = 1;
					} else {
						node1.next = linkedlist.head;
						linkedlist.head = node1;
						linkedlist.sz += 1;
					}
					break;

				case 6 :
					System.out.println("Enter the element to add at index: ");
					int a2 = Integer.parseInt(sc.nextLine());
					PEP150_Node node2 = new PEP150_Node();
					node2.data = a2;
					node2.next = null;
					if (linkedlist.head == null) {
						linkedlist.head = node2;
						linkedlist.tail = node2;
						linkedlist.sz = 1;
					} else {
						System.out.println("Enter the index : ");
						int indx = Integer.parseInt(sc.nextLine());
						if (indx > linkedlist.sz) {
							System.out.println(
									"Linked list size is less than your index!!!");
						} else {
							PEP150_Node testGetLast = linkedlist.head;
							int testIndx = indx;
							while (testIndx > 2) {
								testGetLast = testGetLast.next;
								testIndx--;
							}

							node2.next = testGetLast.next;
							testGetLast.next = node2;
						}
					}
					break;

				case 7 :
					if (linkedlist.head == null) {
						System.out.println(
								"Linked list has no element, before getting element pls add some data");
					} else {
						PEP150_Node testGetLast = linkedlist.head;
						while (testGetLast.next != null) {
							testGetLast = testGetLast.next;
						}
						System.out.println("Last element from linked list : "
								+ testGetLast.data);
					}
					break;

				case 8 :
					if (linkedlist.head == null) {
						System.out.println(
								"Linked list has no element, before Getting element pls add some data");
					} else {
						System.out.println("Enter the index : ");
						int indx = Integer.parseInt(sc.nextLine());
						if (indx > linkedlist.sz) {
							System.out.println(
									"Linked list size is less than your index!!!");
							break;
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

				case 9 :
					if (linkedlist.head == null) {
						System.out.println(
								"Linked list has no element, before deletion pls add some data");
					} else {
						if (linkedlist.sz == 1) {
							System.out.println(linkedlist.head.data
									+ " is deleted from linked list");
							linkedlist.head = null;
							linkedlist.tail = null;
							linkedlist.sz = 0;
						} else {
							PEP150_Node testGetLast = linkedlist.head;
							int element = linkedlist.tail.data;
							while (!(testGetLast.next.next == null)) {
								testGetLast = testGetLast.next;
								linkedlist.tail = testGetLast;
							}
							testGetLast.next = null;
							System.out.println(
									element + " is deleted from linked list");
							linkedlist.sz -= 1;
						}
					}
					break;

				case 10 :
					if (linkedlist.head == null) {
						System.out.println(
								"Linked list has no element, before deletion pls add some data");
					} else {
						System.out.println("Enter the index : ");
						int indx = Integer.parseInt(sc.nextLine());
						if (indx > linkedlist.sz) {
							System.out.println(
									"Linked list size is less than your index!!!");
							break;
						}
						PEP150_Node testGetLast = linkedlist.head;
						PEP150_Node testGetLastprev = linkedlist.head;
						int flag = 0;
						int testIndx = indx;
						while (--testIndx >= 1) {
							testGetLast = testGetLast.next;
							if (flag > 1) {
								testGetLastprev = testGetLastprev.next;
							}
							flag += 1;
						}
						if (testGetLast.next == null && linkedlist.sz == 1) {
							linkedlist.head = null;
							linkedlist.tail = null;
							linkedlist.sz = 0;
						} else {
							testGetLastprev.next = testGetLast.next;
							linkedlist.sz -= 1;
							if (testGetLast.next == null) {
								linkedlist.tail = testGetLast;
							} else {
								linkedlist.tail = testGetLastprev;
							}
						}
						System.out.println(testGetLast.data
								+ " is deleted from linked list");
					}
					break;

				case 11 :
					if (linkedlist.head == null) {
						System.out.println(
								"Linked list has no element, before reversal pls add some data");
					} else {
						int left = 0;
						int right = linkedlist.sz - 1;

						while (left < right) {
							PEP150_Node leftNode = linkedlist.head;
							PEP150_Node rightNode = linkedlist.head;

							int l = left;
							int r = right;

							while (l-- > 0) {
								leftNode = leftNode.next;
							}

							while (r-- > 0) {
								rightNode = rightNode.next;
							}

							// swap data
							int temp = leftNode.data;
							leftNode.data = rightNode.data;
							rightNode.data = temp;

							left++;
							right--;
						}
						System.out.println(
								"Linked list data reversed successfully");
					}
					break;

				case 12 :
					if (linkedlist.head == null) {
						System.out.println(
								"Linked list has no element, before reversal pls add some data");
					} else {
						PEP150_Node prev = null;
						PEP150_Node curr = linkedlist.head;
						PEP150_Node next = null;
						linkedlist.tail = linkedlist.head;

						while (curr != null) {
							next = curr.next;
							curr.next = prev;
							prev = curr;
							curr = next;
						}
						linkedlist.head = prev;
						System.out.println(
								"Linked list nodes reversed successfully");
					}
					break;

				default :
					System.out.println("Your Input is incorrect, pls check");
			}

		}
	}
}
