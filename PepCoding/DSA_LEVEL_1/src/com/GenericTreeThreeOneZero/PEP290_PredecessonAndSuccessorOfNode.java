package com.GenericTreeThreeOneZero;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PEP290_PredecessonAndSuccessorOfNode {

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

	static Node predecessor;
	static Node successor;
	static Node element;

	private static void findPreAndSucc(Node root, int ele) {

		if (root.data == ele) {
			element = root;
		} else if (element != null) {
			successor = root;
			return;
		}
		if (element == null) {
			predecessor = root;
		}

		for (Node childNode : root.children) {
			findPreAndSucc(childNode, ele);
			if (successor != null) {
				return;
			}
		}
	}

	public static void main(String[] args) {
		int[] eularGT =
				{10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
		Node rootNode = constructGT(eularGT);
		predecessor = null;
		successor = null;
		element = null;
		findPreAndSucc(rootNode, 100);
		if (predecessor != null) {
			System.out.println("predesessor: " + predecessor.data);
		} else {
			System.out.println("predesessor: null");
		}
		if (element != null) {
			System.out.println("element : " + element.data);
		} else {
			System.out.println("element : null");
		}
		if (successor != null) {
			System.out.println("successor : " + successor.data);
		} else {
			System.out.println("successor : null");
		}
	}

}
