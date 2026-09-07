package com.pepak.bst;

public class PEP0448_AddNodeInBST{
	
	public static void display(TreeNode root) {
		if(root == null) return;
		
		System.out.print("root->"+root.val+" ");
		if(root.left != null) System.out.print("left->"+root.left.val+" ");
		if(root.right != null) System.out.print("right->"+root.right.val+" ");
		System.out.println();
		display(root.left);
		display(root.right);
	}
	
	public static TreeNode addNode(TreeNode root, int value) {
		if(root == null) return new TreeNode(value);
		if(root.val > value) {
			root.left = addNode(root.left, value);
		}
		else {
			root.right = addNode(root.right, value);
		}
		return root;
	}

	public static void main(String[] args) {
		int[] arr = {10,20,30,40,50,60,70};
		TreeNode root = TreeNode.createBinarySearchTree(arr, 0, arr.length-1);
		display(root);
		addNode(root, 65);
		System.out.println("Node add Successfully........");
		display(root);
		
	}
}
