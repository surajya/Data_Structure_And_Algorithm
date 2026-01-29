package com.GenericTreeThreeHundred;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class PEP243_LevelOrderLinewiseTraversalsOfGT_REVISE {

	static private class Node {

		int data;
		List<Node> children = new ArrayList<>();
	}

	static void displayGT(Node node) {
		String str = node.data + " -> ";
		for (Node child : node.children) {
			str += child.data + ", ";
		}
		str += ".";
		System.out.println(str);

		for (Node child : node.children) {
			displayGT(child);
		}
	}

	static int sizeOfGT(Node root) {

		int totalNode = 0;
		for (Node childNode : root.children) {
			totalNode += sizeOfGT(childNode);
		}
		return totalNode + 1;
	}

	static int maxValueNode(Node root) {

		int maxValue = root.data;
		for (Node childNode : root.children) {
			int childMaxValue = maxValueNode(childNode);
			maxValue = maxValue >= childMaxValue ? maxValue : childMaxValue;
		}
		return maxValue;
	}

	static int heightOfGT(Node root) {

		int maxValue = -1;
		for (Node childNode : root.children) {
			int childMaxValue = heightOfGT(childNode);
			maxValue = maxValue >= childMaxValue ? maxValue : childMaxValue;
		}
		return maxValue + 1;
	}

	static void traversalOfGT(Node root) {
		System.out.println("Node pre : " + root.data);
		for (Node childNode : root.children) {
			System.out.println("Edge Pre : " + root.data + " - " + childNode.data);
			traversalOfGT(childNode);
			System.out.println("Edge post : " + root.data + " - " + childNode.data);
		}
		System.out.println("Node post : " + root.data);
		return;
	}
	
	static void levelOrderTraversalOfGT(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		
		while (true) {
			Node node = queue.poll();
			if (node == null && queue.size() != 0) {
				queue.add(null);
				System.out.println();
			} else if (node != null) {
				System.out.print(node.data + " ");
			}

			if (node != null) {
				for (Node childNode : node.children) {
					queue.add(childNode);
				}
			}

			if (queue.isEmpty()) {
				break;
			}
		}
		return;
	}

	static Node root;
	public static void main(String[] args) {

		int[] eularGT =
				{10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
		Stack<Node> bucket = new Stack<>();

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

		displayGT(root);
		System.out.println("\nsize of generic tree :" + sizeOfGT(root));

		System.out.println("\nmaximum value of node is : " + maxValueNode(root));

		System.out.println("\nHeight of generic tree at edge level : " + heightOfGT(root));

		System.out.println("\ntraversal of Generic Tree : ");
		traversalOfGT(root);
		
		System.out.println("\nLevel Order traversal of Generic Tree : ");
		levelOrderTraversalOfGT(root);
	}

}
