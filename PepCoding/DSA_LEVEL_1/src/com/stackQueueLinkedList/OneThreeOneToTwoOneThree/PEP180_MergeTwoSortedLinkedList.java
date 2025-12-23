package com.stackQueueLinkedList.OneThreeOneToTwoOneThree;

import java.util.Scanner;

public class PEP180_MergeTwoSortedLinkedList {
	static Scanner sc = new Scanner(System.in);
	static PEP151_LinkedList linkedlist;
	static PEP151_LinkedList linkedlist1;
	static PEP151_LinkedList linkedlist2;
	static PEP151_LinkedList sortedlLinkedlist;

	static void initLinkedList() {
		linkedlist = new PEP151_LinkedList();
		linkedlist.head = null;
		linkedlist.tail = null;
		linkedlist.sz = 0;
		sortedlLinkedlist = new PEP151_LinkedList();
		sortedlLinkedlist.head = null;
		sortedlLinkedlist.tail = null;
		sortedlLinkedlist.sz = 0;
	}

	static void initBothLinkedList() {
		linkedlist1 = new PEP151_LinkedList();
		for (int i = 10; i <= 20; i++) {
			PEP150_Node node = new PEP150_Node();
			node.data = i;
			node.next = null;
			if (linkedlist1.head == null) {
				linkedlist1.head = node;
				linkedlist1.tail = node;
				linkedlist1.sz = 1;
			} else {
				linkedlist1.tail.next = node;
				linkedlist1.tail = node;
				linkedlist1.sz += 1;
			}
			i++;
		}

		linkedlist2 = new PEP151_LinkedList();
		for (int i = 9; i <= 20; i++) {
			PEP150_Node node = new PEP150_Node();
			node.data = i;
			node.next = null;
			if (linkedlist2.head == null) {
				linkedlist2.head = node;
				linkedlist2.tail = node;
				linkedlist2.sz = 1;
			} else {
				linkedlist2.tail.next = node;
				linkedlist2.tail = node;
				linkedlist2.sz += 1;
			}
			i++;
		}

	}

	public static void main(String[] args) {
		initLinkedList();
		while (true) {
			System.out.println(
					"PLZ select the operation ->  1 : SIZE \t 2 : DISPLAY \t 3 : CreateLinkedList \t 4 : FindTheKthElementFromTheEndOfLInkedList \t 5 : MiddleOfLInkedList \t 6 : MergeTwoSortedLinkedList \t 0 : EXIT");

			int index = Integer.parseInt(sc.nextLine());

			switch (index) {

				case 0 :
					System.out.println("We will meet again, Good By !!!");
					System.exit(0);
					break;

				case 1 :
					System.out
							.println("Size of Queue: " + linkedlist.sz + "\n");
					break;

				case 2 :
					PEP150_Node test = sortedlLinkedlist.head;
					if (test == null) {
						System.out.println("sortedlLinkedlist is empty!! \n");
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
					System.out.println("Enter the element to add at End: ");
					int a = Integer.parseInt(sc.nextLine());
					PEP150_Node node = new PEP150_Node();
					node.data = a;
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
					break;

				case 4 :
					System.out.println("Enter the Kth Index from end: ");
					int aa = Integer.parseInt(sc.nextLine());
					if (linkedlist.head == null) {
						System.out.println(
								"linkedlist has no element, before deletion pls add some data");
					} else if (aa > linkedlist.sz) {
						System.out
								.println("index is out of bound of linkedlist");
					} else {
						PEP150_Node testNode = linkedlist.head;
						while (linkedlist.sz - aa != 0) {
							aa++;
							testNode = testNode.next;
						}
						System.out.println(aa
								+ "th Element From The End Of LInkedList is : "
								+ testNode.data);
					}
					break;

				case 5 :
					if (linkedlist.head == null) {
						System.out.println("linkedlist has no element");
					} else if (linkedlist.head.next == null) {
						System.out.println("Middle Element of linkedlist: "
								+ linkedlist.head.data);
					} else {
						PEP150_Node middleNode = linkedlist.head;
						PEP150_Node testNode = linkedlist.head;
						while (true) {
							if (testNode.next != null
									&& testNode.next.next != null) {
								testNode = testNode.next.next;
							} else {
								break;
							}
							if (middleNode.next != null) {
								middleNode = middleNode.next;
							}

						}
						System.out.println("Middle Element Of LInkedList is : "
								+ middleNode.data);
					}
					break;

				case 6 :
					initBothLinkedList();
					PEP150_Node testNode1 = linkedlist1.head;
					PEP150_Node testNode2 = linkedlist2.head;
					while (testNode1 != null && testNode2 != null) {
						PEP150_Node node2 = new PEP150_Node();
						if (testNode1.data >= testNode2.data) {
							node2.data = testNode2.data;
							node2.next = null;
							if (sortedlLinkedlist.head == null) {
								sortedlLinkedlist.head = node2;
								sortedlLinkedlist.tail = node2;
								sortedlLinkedlist.sz = 1;
							} else {
								sortedlLinkedlist.tail.next = node2;
								sortedlLinkedlist.tail = node2;
								sortedlLinkedlist.sz += 1;
							}
							testNode2 = testNode2.next;
						} else {
							node2.data = testNode1.data;
							node2.next = null;
							if (sortedlLinkedlist.head == null) {
								sortedlLinkedlist.head = node2;
								sortedlLinkedlist.tail = node2;
								sortedlLinkedlist.sz = 1;
							} else {
								sortedlLinkedlist.tail.next = node2;
								sortedlLinkedlist.tail = node2;
								sortedlLinkedlist.sz += 1;
							}
							testNode1 = testNode1.next;
						}
					}
					while (testNode1 != null) {
						PEP150_Node node2 = new PEP150_Node();
						node2.data = testNode1.data;
						node2.next = null;
						if (sortedlLinkedlist.head == null) {
							sortedlLinkedlist.head = node2;
							sortedlLinkedlist.tail = node2;
							sortedlLinkedlist.sz = 1;
						} else {
							sortedlLinkedlist.tail.next = node2;
							sortedlLinkedlist.tail = node2;
							sortedlLinkedlist.sz += 1;
						}
						testNode1 = testNode1.next;
					}
					while (testNode2 != null) {
						PEP150_Node node2 = new PEP150_Node();
						node2.data = testNode2.data;
						node2.next = null;
						if (sortedlLinkedlist.head == null) {
							sortedlLinkedlist.head = node2;
							sortedlLinkedlist.tail = node2;
							sortedlLinkedlist.sz = 1;
						} else {
							sortedlLinkedlist.tail.next = node2;
							sortedlLinkedlist.tail = node2;
							sortedlLinkedlist.sz += 1;
						}
						testNode2 = testNode2.next;
					}

				default :
					System.out.println("Your Input is incorrect, pls check");
			}

		}
	}
}
