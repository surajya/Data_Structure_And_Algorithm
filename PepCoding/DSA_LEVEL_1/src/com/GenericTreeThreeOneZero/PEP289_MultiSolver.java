package com.GenericTreeThreeOneZero;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PEP289_MultiSolver {

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

	static int size;
	static int min;
	static int max;
	static int height;

	private static void multiPurposeSolver(Node root, int depth) {
		size = size + 1;
		min = Integer.min(min, root.data);
		max = Integer.max(max, root.data);
		height = Integer.max(height, depth);
		for (Node childNode : root.children) {
			multiPurposeSolver(childNode, depth + 1);
		}
	}

	public static void main(String[] args) {
		int[] eularGT =
				{10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
		size = 0;
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		height = 0;
		Node rootNode = constructGT(eularGT);
		multiPurposeSolver(rootNode, 0);
		System.out.println("size : " + size);
		System.out.println("min : " + min);
		System.out.println("max : " + max);
		System.out.println("height : " + height);

	}

}
