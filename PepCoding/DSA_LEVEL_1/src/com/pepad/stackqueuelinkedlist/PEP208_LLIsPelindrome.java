package com.pepad.stackqueuelinkedlist;

import java.util.Scanner;

public class PEP208_LLIsPelindrome {
	static Scanner sc = new Scanner(System.in);
	static PEP151_LinkedList linkedlist;
	static PEP151_LinkedList linkedlist1;
	static PEP151_LinkedList linkedlist2;
	static PEP151_LinkedList sortedlLinkedlist;
	static PEP150_Node testHead;

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

	public static void displayLinkedList(PEP151_LinkedList linkedlist) {
		PEP150_Node test = linkedlist.head;
		if (test == null) {
			System.out.println("linkedlist is empty!! \n");
			return;
		}
		System.out.print("Element of LinkedList: ");
		while (test != null) {
			if (test.next == null) {
				System.out.print(test.data);
			} else {
				System.out.print(test.data + " -> ");
			}
			test = test.next;
		}
		System.out.println();
	}

	public static void addElement(PEP151_LinkedList linkedlist, int a) {
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
	}

	public static void findKthElement(PEP151_LinkedList linkedlist) {
		System.out.println("Enter the Kth Index from end: ");
		int aa = Integer.parseInt(sc.nextLine());
		if (linkedlist.head == null) {
			System.out.println(
					"linkedlist has no element, before deletion pls add some data");
		} else if (aa > linkedlist.sz) {
			System.out.println("index is out of bound of linkedlist");
		} else {
			PEP150_Node testNode = linkedlist.head;
			while (linkedlist.sz - aa != 0) {
				aa++;
				testNode = testNode.next;
			}
			System.out
					.println(aa + "th Element From The End Of LInkedList is : "
							+ testNode.data);
		}
	}

	public static PEP150_Node MiddleOfLInkedList(PEP151_LinkedList linkedlist) {
		if (linkedlist.head == null) {
			System.out.println("linkedlist has no element");
			return null;
		} else if (linkedlist.head.next == null) {
			return linkedlist.head;
		} else {
			PEP150_Node slow = linkedlist.head;
			PEP150_Node fast = linkedlist.head;
			while (fast.next != null && fast.next.next != null) {
				slow = slow.next;
				fast = fast.next.next;
			}
			return slow;
		}
	}

	public static PEP151_LinkedList mergeTwoSortedLinkedList(PEP151_LinkedList linkedlist1,
			PEP151_LinkedList linkedlist2) {
		PEP150_Node testNode1 = linkedlist1.head;
		PEP150_Node testNode2 = linkedlist2.head;
		sortedlLinkedlist = new PEP151_LinkedList();
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
		return sortedlLinkedlist;
	}

	private static PEP151_LinkedList mergeSortLinkedlist(PEP151_LinkedList list) {

		if (list.head == null || list.head.next == null) {
			return list;
		}

		PEP150_Node mid = MiddleOfLInkedList(list);

		PEP151_LinkedList left = new PEP151_LinkedList();
		left.head = list.head;

		PEP151_LinkedList right = new PEP151_LinkedList();
		right.head = mid.next;

		mid.next = null; // IMPORTANT: break the list

		PEP151_LinkedList l1 = mergeSortLinkedlist(left);
		PEP151_LinkedList l2 = mergeSortLinkedlist(right);

		return mergeTwoSortedLinkedList(l1, l2);
	}

	private static PEP151_LinkedList removeDuplicateElementSortedLinkedlist(PEP151_LinkedList list) {
		if (list.head == null || list.head.next == null) {
			return list;
		}

		PEP150_Node traverseNode = list.head;

		while (traverseNode != null && traverseNode.next != null) {

			if (traverseNode.data == traverseNode.next.data) {
				traverseNode.next = traverseNode.next.next;
			} else {
				traverseNode = traverseNode.next;
			}
		}

		return list;
	}

	private static PEP151_LinkedList filterOddEventLinkedlist(PEP151_LinkedList list) {

		PEP150_Node testNode = list.head;
		PEP151_LinkedList oddList = new PEP151_LinkedList();
		PEP151_LinkedList evenList = new PEP151_LinkedList();

		while (testNode != null) {
			int testdata = testNode.data;
			if (testdata % 2 != 0) {
				addElement(oddList, testdata);
			} else {
				addElement(evenList, testdata);
			}
			testNode = testNode.next;

		}
		oddList.tail.next = evenList.head;
		oddList.tail = evenList.tail;
		return oddList;
	}

	public static PEP151_LinkedList KthReverseLinkedList(PEP151_LinkedList linkedlist) {
		System.out.println("Enter how many element you want to reverse : ");
		int number = Integer.parseInt(sc.nextLine());
		PEP151_LinkedList kthReverseLinkedList = new PEP151_LinkedList();
		PEP150_Node testNode = linkedlist.head;
		PEP150_Node testhead = null;
		PEP150_Node testtail = null;

		int flag = 1;
		while (testNode != null) {
			for (int i = 0; i < number; i++) {
				if (testNode == null) {
					break;
				}
				if (flag != 0 && kthReverseLinkedList.head == null) {
					PEP150_Node addNode = new PEP150_Node();
					addNode.data = testNode.data;
					kthReverseLinkedList.head = addNode;
					kthReverseLinkedList.tail = addNode;
					kthReverseLinkedList.sz = 1;
				} else if (flag != 0) {
					PEP150_Node addNode = new PEP150_Node();
					addNode.data = testNode.data;
					addNode.next = kthReverseLinkedList.head;
					kthReverseLinkedList.head = addNode;
					kthReverseLinkedList.sz += 1;
				}
				if (flag == 0) {
					PEP150_Node addNode = new PEP150_Node();
					addNode.data = testNode.data;
					if (testhead == null) {
						kthReverseLinkedList.tail.next = addNode;
						testhead = addNode;
						testtail = addNode;
					} else {
						kthReverseLinkedList.tail.next = addNode;
						addNode.next = testhead;
						testhead = addNode;
					}
					kthReverseLinkedList.sz += 1;
				}
				testNode = testNode.next;
			}
			if (flag == 0) {
				kthReverseLinkedList.tail = testtail;
			}
			testhead = null;
			testtail = null;
			flag = 0;
		}

		return kthReverseLinkedList;
	}

	public static void reverseLLRecursive(PEP150_Node node) {
		if (node == null) {
			return;
		}
		reverseLLRecursive(node.next);
		System.out.print(node.data + " -> ");

	}

	public static void reverseLLPointerRecursive(PEP151_LinkedList list, PEP150_Node slowNode, PEP150_Node fastNode) {
		if (fastNode == null) {
			return;
		}
		reverseLLPointerRecursive(list, slowNode.next, fastNode.next);
		fastNode.next = slowNode;
		slowNode.next = null;
	}

	public static void reverseLLdataRecursive(PEP150_Node head, int floor) {
		if (head == null) {
			return;
		}
		reverseLLdataRecursive(head.next, floor + 1);
		if (floor > linkedlist.sz / 2) {
			int testdata = head.data;
			head.data = testHead.data;
			testHead.data = testdata;
			testHead = testHead.next;
		}
	}

	public static boolean checkPalindrom(PEP150_Node head, int floor) {
		if (head == null) {
			return true;
		}
		reverseLLdataRecursive(head.next, floor + 1);
		if (floor > linkedlist.sz / 2) {
			if (head.data != testHead.data) {
				return false;
			}
			testHead = testHead.next;
		}
		return true;
	}

	public static void main(String[] args) {
		initLinkedList();
		while (true) {
			System.out.println(
					"PLZ select the operation ->  1 : SIZE \t 2 : DISPLAY \t 3 : CreateLinkedList \t 4 : FindTheKthElementFromTheEndOfLInkedList \t 5 : MiddleOfLInkedList \t 6 : MergeTwoSortedLinkedList \t 7 : MergeSortLinkedList \t 8 : RemoveDuplicateElementFromSortedLinkedList \t 9 : FilterOddEventLinkedList \t 10 : KthReverseLinkedList \t 11 : Display Reverse LinkedList Using Recursive \t 12 : Display Reverse Linked List Using pointer Reverse \t 13 : Display Reverse Linked List Using Data swapping Reverse \t 14 : check Linked List is palindrome \t 0 : EXIT");

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
					displayLinkedList(linkedlist);
					break;

				case 3 :
					System.out.println("Enter the element to add at End: ");
					int a = Integer.parseInt(sc.nextLine());
					addElement(linkedlist, a);
					break;

				case 4 :
					findKthElement(linkedlist);
					break;

				case 5 :
					PEP150_Node middleNode = MiddleOfLInkedList(linkedlist);
					if (middleNode != null) {
						System.out.println(
								"Middle Element Of LInkedList is : " + middleNode.data);
					}
					break;

				case 6 :
					initBothLinkedList();
					PEP151_LinkedList sortedTwolinkedlist = mergeTwoSortedLinkedList(linkedlist1, linkedlist2);
					displayLinkedList(sortedTwolinkedlist);
					break;

				case 7 :
					PEP151_LinkedList sortedlinkedlist = mergeSortLinkedlist(linkedlist);
					displayLinkedList(sortedlinkedlist);
					break;

				case 8:
					PEP151_LinkedList uniqueLinkedList = removeDuplicateElementSortedLinkedlist(linkedlist);
					System.out.println("unique value linkedlist: ");
					displayLinkedList(uniqueLinkedList);
					break;

				case 9:
					PEP151_LinkedList filteredLinkedList = filterOddEventLinkedlist(linkedlist);
					System.out.println("Filter Odd Event linkedlist: ");
					displayLinkedList(filteredLinkedList);
					break;

				case 10:
					PEP151_LinkedList reverseLinkedList = KthReverseLinkedList(linkedlist);
					displayLinkedList(reverseLinkedList);
					break;

				case 11:
					System.out.print("LinkedList in Reverse order: ");
					PEP150_Node testNode = linkedlist.head;
					reverseLLRecursive(testNode);
					System.out.println();
					break;

				case 12:
					reverseLLPointerRecursive(linkedlist, linkedlist.head, linkedlist.head.next);
					PEP150_Node testNode2 = linkedlist.head;
					linkedlist.head = linkedlist.tail;
					linkedlist.tail = testNode2;
					displayLinkedList(linkedlist);
					break;

				case 13:
					testHead = linkedlist.head;
					reverseLLdataRecursive(linkedlist.head, 1);
					displayLinkedList(linkedlist);
					break;

				case 14:
					testHead = linkedlist.head;
					if (checkPalindrom(linkedlist.head, 1)) {
						System.out.println("linkedlist is a palindeome TYPE");
					} else {
						System.out.println("ohohoh linkedlist is not a palindeome type");
					}
					break;

				default :
					System.out.println("Your Input is incorrect, pls check");
			}

		}
	}
}
