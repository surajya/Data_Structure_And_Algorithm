package com.GenericTreeThreeOneZero;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PEP303_DiameterOfGT {

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

	static int diameterOfGT;

	private static int findDiameterOfGT(Node rootNode) {
		// TODO Auto-generated method stub

		int largest = 0;
		int secondLargest = 0;
		for (Node childNode : rootNode.children) {
			int maxEdge = findDiameterOfGT(childNode);
			if (maxEdge > largest) {
				secondLargest = largest;
				largest = maxEdge;
			} else if (maxEdge > secondLargest) {
				secondLargest = maxEdge;
			}
		}

		int diameterOfSubGT = largest + secondLargest + 1;
		if (diameterOfSubGT > diameterOfGT) {
			diameterOfGT = diameterOfSubGT;
		}
		int maxEdge = Integer.max(largest, secondLargest);
		return maxEdge + 1;
	}

	public static void main(String[] args) {
		int[] eularGT =
				{10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, 130, -1, -1, -1, 90, -1, -1, 40, 100, -1, -1,
						-1};
		Node rootNode = constructGT(eularGT);

		diameterOfGT = Integer.MIN_VALUE;
		findDiameterOfGT(rootNode);
		System.out.println("Diameter of GT is : " + (diameterOfGT - 1));
	}

}
