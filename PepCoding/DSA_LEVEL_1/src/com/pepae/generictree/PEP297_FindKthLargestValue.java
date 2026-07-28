package com.pepae.generictree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PEP297_FindKthLargestValue {

	static private class Node {

		int data;
		List<Node> children = new ArrayList<>();
	}

	private static Node constructGT(int[] eularGT) {
		Stack<Node> bucket = new Stack<>();
		Node root = new Node();
		for (int x : eularGT) {
			if (x == -1) {
				bucket.pop();
			} else {
				Node childNode = new Node();
				childNode.data = x;
				if (bucket.isEmpty()) {
					bucket.push(childNode);
					root = childNode;
				} else {
					bucket.peek().children.add(childNode);
					bucket.push(childNode);
				}
			}
		}
		return root;
	}

	static int ceil;
	static int floor;
	static int element;

	private static void findCeilAndFloor(Node root) {

		if (root.data > floor && root.data < element) {
			floor = root.data;
		} else if (root.data < ceil && root.data > element) {
			ceil = root.data;
		}

		for (Node childNode : root.children) {
			//if(childNode)
			findCeilAndFloor(childNode);
		}
	}

	private static int findKthLargestValue(Node rootNode, int kth) {
		// TODO Auto-generated method stub
		int floorValue = Integer.MAX_VALUE;
		for (int i = 0; i < kth; i++) {
			element = floorValue;
			findCeilAndFloor(rootNode);
			floorValue = floor;
			ceil = Integer.MAX_VALUE;
			floor = Integer.MIN_VALUE;
		}
		return floorValue;

	}

	public static void main(String[] args) {
		int[] eularGT =
				{10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
		Node rootNode = constructGT(eularGT);
		ceil = Integer.MAX_VALUE;
		floor = Integer.MIN_VALUE;
		//		element = 80;
		//		findCeilAndFloor(rootNode);
		//		if (floor != Integer.MIN_VALUE) {
		//			System.out.println("floor: " + floor);
		//		} else {
		//			System.out.println("floor: null");
		//		}
		//		if (element != 0) {
		//			System.out.println("element : " + element);
		//		} else {
		//			System.out.println("element : null");
		//		}
		//		if (ceil != Integer.MAX_VALUE) {
		//			System.out.println("ceil : " + ceil);
		//		} else {
		//			System.out.println("ceil : null");
		//		}


		System.out.println(3 + " largest value : " + findKthLargestValue(rootNode, 8));
	}

}
