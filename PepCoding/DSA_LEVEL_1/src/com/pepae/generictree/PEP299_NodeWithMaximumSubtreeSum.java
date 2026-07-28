package com.pepae.generictree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PEP299_NodeWithMaximumSubtreeSum {

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

	static int subTreeNode;
	static int subTreeMaxSum;

	private static int findMaxSubTreeSum(Node rootNode) {
		// TODO Auto-generated method stub

		int childNodeValueSum = 0;
		for (Node childNode : rootNode.children) {
			childNodeValueSum += findMaxSubTreeSum(childNode);
		}

		int totalSubTreeValue = childNodeValueSum + rootNode.data;
		if (totalSubTreeValue > subTreeMaxSum) {
			subTreeMaxSum = totalSubTreeValue;
			subTreeNode = rootNode.data;
		}
		return totalSubTreeValue;
	}

	public static void main(String[] args) {
		int[] eularGT =
				{10, -20, 50, -1, -60, -1, -1, -300, 70, -1, -80, 110, -1, 120, -1, -1, 90, -1, -1, -40, -100, -1, -1,
						-1};
		Node rootNode = constructGT(eularGT);

		subTreeMaxSum = Integer.MIN_VALUE;
		findMaxSubTreeSum(rootNode);
		System.out.println("Sub tree is : " + subTreeNode + " \n And its value is: " + subTreeMaxSum);
	}

}
