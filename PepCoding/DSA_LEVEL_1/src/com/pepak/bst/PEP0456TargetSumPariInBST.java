package com.pepak.bst;

public class PEP0456TargetSumPariInBST{
	
	public static void display(TreeNode root) {
		if(root == null) return;
		
		System.out.print("root->"+root.val+" ");
		if(root.left != null) System.out.print("left->"+root.left.val+" ");
		if(root.right != null) System.out.print("right->"+root.right.val+" ");
		System.out.println();
		display(root.left);
		display(root.right);
	}
	
	public static void  targetSumPair(TreeNode root, TreeNode rRoot, int target) {
		if(root == null) return;
		
		if(root.val < (target-root.val) && findRemaining(rRoot, target-root.val)) {
			System.out.println(root.val+" <-> "+(target-root.val));
		}
		targetSumPair(root.left, rRoot, target);
		targetSumPair(root.right, rRoot, target);
	}
	
	public static boolean findRemaining(TreeNode root, int pending) {
		if(root == null) return false;
		
		if(root.val > pending) return findRemaining(root.left, pending);
		else if(root.val < pending) return findRemaining(root.right, pending);
		return true;
	}
	
	public static void main(String[] args) {
		int[] arr = {10,20,30,40,50,60,70};
		TreeNode root = TreeNode.createBinarySearchTree(arr, 0, arr.length-1);
		display(root);
		System.out.println("Paired Valued are........");
		targetSumPair(root, root, 80);
	}
}
