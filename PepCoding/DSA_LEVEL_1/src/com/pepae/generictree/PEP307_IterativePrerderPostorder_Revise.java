package com.pepae.generictree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PEP307_IterativePrerderPostorder_Revise {

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

	public static void iterativePreorder(Node root) {
		Stack<Node> bucket = new Stack<>();
		bucket.push(root);
		while (!bucket.isEmpty()) {
			Node node = bucket.pop();
			System.out.print(node.data + " ");
			for (int i = node.children.size() - 1; i >= 0; i--) {
				bucket.push(node.children.get(i));
			}
		}
	}

	public static void iterativePostorder(Node root) {
		Stack<Node> bucket1 = new Stack<>();
		Stack<Node> bucket2 = new Stack<>();
		bucket1.push(root);
		while (!bucket1.isEmpty()) {
			Node node = bucket1.pop();
			bucket2.push(node);
			for (Node chilNode : node.children) {
				bucket1.push(chilNode);
			}
		}
		while (!bucket2.isEmpty()) {
			System.out.print(bucket2.pop().data + " ");
		}
	}

	public static void main(String[] args) {
		int[] eularGT =
				{10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1,
						-1};
		Node rootNode = constructGT(eularGT);

		System.out.println("PreOrder Traversal : ");
		iterativePreorder(rootNode);
		System.out.println("\nPostOrder Traversal : ");
		iterativePostorder(rootNode);
	}

}
