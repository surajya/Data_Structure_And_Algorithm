package com.pepaf.binarytree;

import java.util.Stack;

public class PEP316_MultiSolverBT {

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

	public static int size(Node node) {
		if (node == null) {
			return 0;
		}
		int leftSize = size(node.leftNode);
		int rightSize = size(node.rightNode);
		return leftSize + rightSize + 1;
	}

	public static int sum(Node node) {
		if (node == null) {
			return 0;
		}
		int leftSum = sum(node.leftNode);
		int rightSum = sum(node.rightNode);
		return leftSum + rightSum + node.data;
	}

	public static int maxValue(Node node) {
		if (node == null) {
			return 0;
		}
		int leftMaxValue = maxValue(node.leftNode);
		int rightMaxValue = maxValue(node.rightNode);
		int maxNodeValue = leftMaxValue > rightMaxValue
				? leftMaxValue > node.data ? leftMaxValue : node.data
				: rightMaxValue > node.data ? rightMaxValue : node.data;
		return maxNodeValue;
	}

	public static int height(Node node) {
		if (node == null) {
			return 0;
		}
		int leftHeight = height(node.leftNode);
		int rightHeight = height(node.rightNode);
		int maxHeight = Integer.max(leftHeight, rightHeight);
		return maxHeight + 1;
	}

	public static void main(String[] args) {
		int[] arr = {50, 25, 12, -1, -1, 37, 30, -1, -1, -1, 75, 62, -1, 70, -1, -1, 87, -1, -1};
		Node root = constructBT(arr);
		//display(root);

		System.out.println("size of BT: " + size(root));

		System.out.println("sum of BT: " + sum(root));

		System.out.println("max node value of BT: " + maxValue(root));

		System.out.println("height of BT: " + height(root));
	}
}
