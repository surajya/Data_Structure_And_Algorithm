package com.pepad.stackqueuelinkedlist;

import java.util.Scanner;

public class PEP152_AddLastInLinkedList {
	static Scanner sc = new Scanner(System.in);
	static PEP151_LinkedList linkedlist;

	static void initLinkedList() {
		linkedlist= new PEP151_LinkedList();
		linkedlist.head=null;
		linkedlist.tail=null;
		linkedlist.sz=0;
	}
	
	public static void main(String[] args) {
		initLinkedList();
		while (true) {
			System.out.println(
					"PLZ select the operation ->  1 : SIZE \t 2 : DISPLAY \t 3 : ADD \t 4 : REMOVE \t 5 : PEEK \t 0 : EXIT");

			int index = Integer.parseInt(sc.nextLine());

			switch (index) {
				
			case 0:
				System.out.println("We will meet again, Good By !!!");
				System.exit(0);
				break;
				
			case 1:
				System.out.println("Size of linkedlist: " + linkedlist.sz + "\n");
				break;
				
			case 2:
				
				PEP150_Node test = linkedlist.head;
				if(test==null) {
					System.out.println("linkedlist is empty!! \n");
					break;
				}
				System.out.print("Element of linkedlist: ");
				while(test!=null) {
					System.out.print(test.data+" ");
					test=test.next;
				}
				System.out.println();
				break;
				
			case 3:
				System.out.println("Enter the element to add at End: ");
				int a = Integer.parseInt(sc.nextLine());
				PEP150_Node node = new PEP150_Node();
				node.data=a;
				node.next = null;
				
				if(linkedlist.sz == 0) {
					linkedlist.head=node;
					linkedlist.tail = node;
					linkedlist.sz=1;
				}else {
					linkedlist.tail.next = node;
					linkedlist.tail = node;
					linkedlist.sz += 1;
				}
				break;
			}
		}
	}

}
