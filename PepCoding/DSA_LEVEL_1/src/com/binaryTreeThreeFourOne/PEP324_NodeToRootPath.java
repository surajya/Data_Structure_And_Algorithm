package com.binaryTreeThreeFourOne;

import java.util.Stack;

public class PEP324_NodeToRootPath {

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

	public static int nodeToRoot(Node node, int element) {
		if (node == null) {
			return 0;
		}
		if (node.data == element) {
			System.out.println(node.data);
			return 1;
		}
		int left = nodeToRoot(node.leftNode, element);
		int right = nodeToRoot(node.rightNode, element);
		if (left == 1) {
			System.out.println(node.data);
			return 1;
		}
		if (right == 1) {
			System.out.println(node.data);
			return 1;
		}
		return 0;
	}

	public static void main(String[] args) {
		int[] arr = {50, 25, 12, -1, -1, 37, 30, -1, -1, -1, 75, 62, -1, 70, -1, -1, 87, -1, -1};
		Node root = constructBT(arr);
		//display(root);
		System.out.println("print node to root path of 70");
		nodeToRoot(root, 70);

	}
}
