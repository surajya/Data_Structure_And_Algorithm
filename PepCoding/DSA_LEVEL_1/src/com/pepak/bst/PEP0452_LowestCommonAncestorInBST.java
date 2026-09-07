package com.pepak.bst;

public class PEP0452_LowestCommonAncestorInBST{
	
	public static void display(TreeNode root) {
		if(root == null) return;
		
		System.out.print("root->"+root.val+" ");
		if(root.left != null) System.out.print("left->"+root.left.val+" ");
		if(root.right != null) System.out.print("right->"+root.right.val+" ");
		System.out.println();
		display(root.left);
		display(root.right);
	}
	
	public static TreeNode  lca(TreeNode root, int first, int sec) {
		if(root.val>first && root.val < sec) return root;
		else if(root.val>first && root.val > sec) return lca(root.left, first, sec);
		else if(root.val<first && root.val < sec) return lca(root.right, first, sec);
		return root;
	}
	
	public static void main(String[] args) {
		int[] arr = {10,20,30,40,50,60,70};
		TreeNode root = TreeNode.createBinarySearchTree(arr, 0, arr.length-1);
		display(root);
		System.out.println("lowest common ancestor "+lca(root, 40, 70).val);
		
	}
}
