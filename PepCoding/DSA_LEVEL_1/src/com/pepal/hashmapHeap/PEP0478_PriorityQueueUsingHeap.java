package com.pepal.hashmapHeap;

import java.util.ArrayList;
import java.util.Scanner;

public class PEP0478_PriorityQueueUsingHeap {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int exit = 1;
		while (exit == 1) {
			System.out.println("enter 0:exit 1:add  2:remove  3:peek  4:size 5:display");
			System.out.print("choice : ");
			int choice = Integer.parseInt(sc.nextLine());

			switch (choice) {
			case 0:
				exit = 0;
				break;
			case 1:
				System.out.println("enter the element: ");
				add(Integer.parseInt(sc.nextLine()), list);
				break;
			case 2:
				remove(list);
				break;
			case 3:
				System.out.println("peek value is : " + peek(list));
				break;
			case 4:
				System.out.println("size of queue is : " + size(list));
				break;
			case 5:
				display(list, 0, "");
				break;
			default:
				System.out.println("please enter correct choice");
			}

		}
		sc.close();
	}

	private static void display(ArrayList<Integer> list, int i, String side) {
		if (list.isEmpty()) {
			System.out.println("OH, LIST IS EMPTY !!!!");
			return;
		}
		if (i >= list.size())
			return;

		if (side.isEmpty())
			System.out.println("Root ->" + list.get(i));
		else if (side.equals("l"))
			System.out.println("left-> " + list.get((i - 1) / 2) + " : " + list.get(i));
		else if (side.equals("r"))
			System.out.println("right-> " + list.get((i - 1) / 2) + " : " + list.get(i));

		display(list, 2 * i + 1, "l");
		display(list, 2 * i + 2, "r");
	}

	private static int size(ArrayList<Integer> list) {
		return list.size();
	}

	private static int peek(ArrayList<Integer> list) {
		if (list.isEmpty()) {
			System.out.println("OH, LIST IS EMPTY !!!!");
			return 0;
		}
		return list.get(0);
	}

	private static void remove(ArrayList<Integer> list) {
		if (list.isEmpty()) {
			System.out.println("OH, LIST IS EMPTY !!!!");
			return;
		}
		int a = list.get(0);
		int b = list.get(size(list) - 1);
		list.set(0, b);
		list.set(size(list) - 1, a);
		System.out.println("remove element is: " + list.remove(size(list) - 1));
		downStreamHeapify(list);
	}

	private static void add(int nextInt, ArrayList<Integer> list) {
		list.add(nextInt);
		upStreamHeapify(list);
	}

	private static void upStreamHeapify(ArrayList<Integer> list) {
		int ci = list.size() - 1;
		while (ci > 0) {
			int pi = (ci - 1) / 2;
			int a = list.get(ci);
			int b = list.get(pi);
			if (a > b)
				break;
			list.set(pi, a);
			list.set(ci, b);
			ci = pi;
		}
	}

	private static void downStreamHeapify(ArrayList<Integer> list) {
		int pi = 0;
		while ((2 * pi + 2) < list.size()) {
			int left = 2 * pi + 1;
			int right = 2 * pi + 2;
			int ci = list.get(left) < list.get(right) ? left : right;
			int a = list.get(ci);
			int b = list.get(pi);
			if (a > b)
				break;
			list.set(pi, a);
			list.set(ci, b);
			pi = ci;
		}
	}

}
