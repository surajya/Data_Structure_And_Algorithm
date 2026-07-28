package com.pepad.stackqueuelinkedlist;

import java.util.Scanner;

public class PEP182_ChatGPTMergeSortLinkedList {
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

	public static void main(String[] args) {
		initLinkedList();
		while (true) {
			System.out.println(
					"PLZ select the operation ->  1 : SIZE \t 2 : DISPLAY \t 3 : CreateLinkedList \t 4 : Merge Sort Linked List \t 0 : EXIT");

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

				default :
					sortedlLinkedlist = mergeSort(linkedlist);
					System.out.println(
							"Merge Sort Linked List done successfully! \n");
					break;
			}

		}
	}

	private static PEP151_LinkedList mergeSort(PEP151_LinkedList linkedlist3) {
		// TODO Auto-generated method stub
		if (linkedlist3.sz <= 1) {
			return linkedlist3;
		}
		PEP150_Node midNode = midNode(linkedlist3.head);
		PEP151_LinkedList leftLinkedList = new PEP151_LinkedList();
		leftLinkedList.head = linkedlist3.head;
		leftLinkedList.tail = midNode;
		leftLinkedList.sz = (linkedlist3.sz + 1) / 2;
		PEP151_LinkedList rightLinkedList = new PEP151_LinkedList();
		rightLinkedList.head = midNode.next;
		rightLinkedList.tail = linkedlist3.tail;
		rightLinkedList.sz = linkedlist3.sz / 2;
		midNode.next = null;
		leftLinkedList = mergeSort(leftLinkedList);
		rightLinkedList = mergeSort(rightLinkedList);
		return mergeTwoSortedLinkedList(leftLinkedList, rightLinkedList);
	}

	private static PEP151_LinkedList mergeTwoSortedLinkedList(
			PEP151_LinkedList leftLinkedList,
			PEP151_LinkedList rightLinkedList) {
		// TODO Auto-generated method stub
		PEP151_LinkedList mergedLinkedList = new PEP151_LinkedList();
		PEP150_Node leftNode = leftLinkedList.head;
		PEP150_Node rightNode = rightLinkedList.head;
		while (leftNode != null && rightNode != null) {
			if (leftNode.data <= rightNode.data) {
				PEP150_Node newNode = new PEP150_Node();
				newNode.data = leftNode.data;
				newNode.next = null;
				if (mergedLinkedList.head == null) {
					mergedLinkedList.head = newNode;
					mergedLinkedList.tail = newNode;
					mergedLinkedList.sz = 1;
				} else {
					mergedLinkedList.tail.next = newNode;
					mergedLinkedList.tail = newNode;
					mergedLinkedList.sz += 1;
				}
				leftNode = leftNode.next;
			} else {
				PEP150_Node newNode = new PEP150_Node();
				newNode.data = rightNode.data;
				newNode.next = null;
				if (mergedLinkedList.head == null) {
					mergedLinkedList.head = newNode;
					mergedLinkedList.tail = newNode;
					mergedLinkedList.sz = 1;
				} else {
					mergedLinkedList.tail.next = newNode;
					mergedLinkedList.tail = newNode;
					mergedLinkedList.sz += 1;
				}
				rightNode = rightNode.next;
			}
		}
		while (leftNode != null) {
			PEP150_Node newNode = new PEP150_Node();
			newNode.data = leftNode.data;
			newNode.next = null;
			if (mergedLinkedList.head == null) {
				mergedLinkedList.head = newNode;
				mergedLinkedList.tail = newNode;
				mergedLinkedList.sz = 1;
			} else {
				mergedLinkedList.tail.next = newNode;
				mergedLinkedList.tail = newNode;
				mergedLinkedList.sz += 1;
			}
			leftNode = leftNode.next;
		}
		while (rightNode != null) {
			PEP150_Node newNode = new PEP150_Node();
			newNode.data = rightNode.data;
			newNode.next = null;
			if (mergedLinkedList.head == null) {
				mergedLinkedList.head = newNode;
				mergedLinkedList.tail = newNode;
				mergedLinkedList.sz = 1;
			} else {
				mergedLinkedList.tail.next = newNode;
				mergedLinkedList.tail = newNode;
				mergedLinkedList.sz += 1;
			}
			rightNode = rightNode.next;
		}
		return mergedLinkedList;
	}

	private static PEP150_Node midNode(PEP150_Node head) {
		// TODO Auto-generated method stub
		PEP150_Node slow = head;
		PEP150_Node fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
}
