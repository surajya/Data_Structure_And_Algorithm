package com.pepae.generictree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class PEP310_IteratorAndIterable {

	static private class GenericTree implements Iterable<Integer> {
		public Node node;
		public GenericTree(Node root) {
			this.node = root;
		}

		@Override
		public Iterator<Integer> iterator() {
			Iterator<Integer> preOrderIterator = new PreorderGT(node);
			return preOrderIterator;
		}
	}

	private static class PreorderGT implements Iterator<Integer> {
		Integer frInteger;
		Stack<Node> bucket;
		public PreorderGT(Node root) {
			frInteger = null;
			bucket = new Stack<>();
			bucket.push(root);
			next();
		}
		@Override
		public boolean hasNext() {
			if (frInteger != null) {
				return true;
			}
			return false;
		}
		@Override
		public Integer next() {
			if (!bucket.isEmpty()) {
			Node node = bucket.pop();
			frInteger = node.data;
			for (int i = node.children.size() - 1; i >= 0; i--) {
				bucket.push(node.children.get(i));
			}
		} else {
				frInteger = null;
			}
			return frInteger;
		}
	}


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

		GenericTree gt = new GenericTree(rootNode);
		Iterator<Integer> iterator = gt.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

}
