package com.GenericTreeThreeOneZero;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PEP278_TreesSimilerInShape{

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

	static boolean findElementInGT(Node root, int num) {
		if (root.data == num) {
			return true;
		}

		for (Node childNode : root.children) {
			boolean present = findElementInGT(childNode, num);
			if (present) {
				return present;
			}
		}
		return false;
	}

	static List<Integer> findPathOfNodeToRoot(Node root, int num) {
		if (root.data == num) {
			List<Integer> list = new ArrayList<>();
			list.add(root.data);
			return list;
		}

		for (Node childNode : root.children) {
			List<Integer> list = findPathOfNodeToRoot(childNode, num);
			if (list.size() > 0) {
				list.add(root.data);
				return list;
			}
		}
		return new ArrayList<>();
	}


	static int findLowestCommonAncestorOfNodes(Node root, int num1, int num2) {

		boolean isTargetNode = (root.data == num1 || root.data == num2);


		if (root.children.isEmpty() && isTargetNode) {
			return 1;
		}

		int count = 0;
		for (Node childNode : root.children) {
			int a = findLowestCommonAncestorOfNodes(childNode, num1, num2);
			if (a == 1) {
				count++;
			}
			if (a != 1 && a != 0) {
				return a;
			}
		}
		if (count == 2) {
			return root.data;
		} else if (count == 1) {
			return isTargetNode ? root.data : 1;
		} else if (count == 0 && isTargetNode) {
			return 1;
		}

		return 0;
	}

	static int findDistanceBetweenNode(Node root, int num1, int num2) {
		return findDistance(root, findLowestCommonAncestorOfNodes(root, num1, num2), num1, num2);
	}

	private static int findDistance(Node root, int lowestCommonAncestorOfNodes, int num1, int num2) {
		// TODO Auto-generated method stub
		if (root.data == lowestCommonAncestorOfNodes) {
			return calculateDistance(root, root, num1, num2);
		}
		int totoalValue = 0;
		for (Node childNode : root.children) {
			totoalValue = findDistance(childNode, lowestCommonAncestorOfNodes, num1, num2);
			if (totoalValue != 0) {
				return totoalValue;
			}
		}
		return 0;
	}

	private static int calculateDistance(Node root, Node rootRoot, int num1, int num2) {
		// TODO Auto-generated method stub
		int totalValue = 0;
		for (Node childNode : root.children) {
			int value = calculateDistance(childNode, rootRoot, num1, num2);
			totalValue = totalValue + value;
		}
		if (root.data == num1 || root.data == num2) {
			return 1;
		}
		if (totalValue != 0 && root != rootRoot) {
			return ++totalValue;
		}
		return totalValue;
	}

	private static boolean checkTreeSimiler(Node root3, Node root22) {
		// TODO Auto-generated method stub
		if (root3.children.size() != root22.children.size()) {
			return false;
		}

		for (int i = 0; i < root3.children.size(); i++) {
			if (!checkTreeSimiler(root3.children.get(i), root22.children.get(i))) {
				return false;
			}
		}
		return true;
	}

	static Node root;
	static Node root2;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] eularGT =
				{10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, 200, -1, -1,
						-1};
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

		int[] eularGT2 =
				{10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
		Stack<Node> bucket2 = new Stack<>();

		for (int x : eularGT2) {
			if (x == -1) {
				bucket2.pop();
			} else {
				Node childNode = new Node();
				childNode.data = x;
				if (bucket2.isEmpty()) {
					bucket2.push(childNode);
					root2 = childNode;
				} else {
					bucket2.peek().children.add(childNode);
					bucket2.push(childNode);
				}
			}
		}

		//displayGT(root);
		System.out.println(90 + " present in generic tree :" + findElementInGT(root, 90));
		List<Integer> list = findPathOfNodeToRoot(root, 120);
		if (list.size() < 1) {
			System.out.println("element is not present");
		} else {
			System.out.println("Path of " + 120 + " from node to root is" + list);
		}

		System.out.println("ancestor of 40 and 100 is :" + findLowestCommonAncestorOfNodes(root, 40, 100));

		System.out.println("Distance between two nodes : " + findDistanceBetweenNode(root, 120, 110));

		System.out.println("Tree are similer: " + checkTreeSimiler(root, root2));

	}


}
