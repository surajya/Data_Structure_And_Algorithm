package com.pepak.bst;

public class PEP0450_ReplaceSumOfLargerInBST{
	public static int sum = 0;
	
	public static void display(TreeNode root) {
		if(root == null) return;
		
		System.out.print("root->"+root.val+" ");
		if(root.left != null) System.out.print("left->"+root.left.val+" ");
		if(root.right != null) System.out.print("right->"+root.right.val+" ");
		System.out.println();
		display(root.left);
		display(root.right);
	}
	
	public static void replace(TreeNode root) {
		if(root == null) return ;
		
		replace(root.right);
		int rval=root.val;
		root.val = sum;
		sum += rval;
		replace(root.left);
		return;
	}
	
	public static void main(String[] args) {
		int[] arr = {10,20,30,40,50,60,70};
		TreeNode root = TreeNode.createBinarySearchTree(arr, 0, arr.length-1);
		display(root);
		replace(root);
		System.out.println("Replace sum of larger Successfully........");
		display(root);
		
	}
}
