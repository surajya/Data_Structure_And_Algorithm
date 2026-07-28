package com.pepaf.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PEP318_TraversalOfBT {

	private static class Node {

		int data;
		Node leftNode;
		Node rightNode;

		Node(int data, Node leftNode, Node rightNode) {
			this.data = data;
			this.leftNode = leftNode;
			this.rightNode = rightNode;
		}
	}

	private static class NodeWithIndex {

		Node node;
		int index;

		NodeWithIndex(Node node, int flag) {
			this.node = node;
			this.index = flag;
		}
	}

	private static Node constructBT(int[] arr) {
		Stack<NodeWithIndex> bucket = new Stack<>();
		Node rootNode = new Node(arr[0], null, null);
		bucket.push(new NodeWithIndex(rootNode, 1));
		int i = 1;
		while (!bucket.isEmpty() && i < arr.length) {
			int value = arr[i++];
			while (!bucket.isEmpty() && bucket.peek().index == 3) {
				bucket.pop();
			}
			if (!bucket.isEmpty()) {
			NodeWithIndex nwi = bucket.pop();
			int inx = nwi.index;
			if (inx == 1) {
				if (value != -1) {
					Node leftNode = new Node(value, null, null);
					nwi.node.leftNode = leftNode;
					nwi.index = 2;
					bucket.push(nwi);
					bucket.push(new NodeWithIndex(leftNode, 1));
				} else {
					nwi.index = 2;
					bucket.push(nwi);
				}
			} else if (inx == 2) {
				if (value != -1) {
					Node rightNode = new Node(value, null, null);
					nwi.node.rightNode = rightNode;
					nwi.index = 3;
					bucket.push(nwi);
					bucket.push(new NodeWithIndex(rightNode, 1));
				} else {
					nwi.index = 3;
					//bucket.push(nwi);
				}
			}
		}
	}
		return rootNode;
	}

	public static void display(Node node) {
		if (node == null) {
			return;
		}
		String str = "";
		str += node.leftNode != null ? node.leftNode.data : ".";
		str += " <- " + node.data + " -> ";
		str += node.rightNode != null ? node.rightNode.data : ".";
		System.out.println(str);
		display(node.leftNode);
		display(node.rightNode);
	}

	public static void traversal(Node node, List<Integer> preOrderList, List<Integer> inOrderList,
			List<Integer> postOrderList) {
		if (node == null) {
			return;
		}
		preOrderList.add(node.data);
		traversal(node.leftNode, preOrderList, inOrderList, postOrderList);
		inOrderList.add(node.data);
		traversal(node.rightNode, preOrderList, inOrderList, postOrderList);
		postOrderList.add(node.data);
	}

	public static void main(String[] args) {
		int[] arr = {50, 25, 12, -1, -1, 37, 30, -1, -1, -1, 75, 62, -1, 70, -1, -1, 87, -1, -1};
		Node root = constructBT(arr);
		//display(root);

		List<Integer> preOrderList = new ArrayList<>();
		List<Integer> inOrderList = new ArrayList<>();
		List<Integer> postOrderList = new ArrayList<>();
		traversal(root, preOrderList, inOrderList, postOrderList);
		System.out.println("inOrder Traversal of BT: ");
		for (int a : preOrderList) {
			System.out.print(a + " -> ");
		}
		System.out.println();

		System.out.println("inOrder Traversal of BT: ");
		for (int a : inOrderList) {
			System.out.print(a + " -> ");
		}
		System.out.println();

		System.out.println("inOrder Traversal of BT: ");
		for (int a : postOrderList) {
			System.out.print(a+" -> ");
		}

	}
}
