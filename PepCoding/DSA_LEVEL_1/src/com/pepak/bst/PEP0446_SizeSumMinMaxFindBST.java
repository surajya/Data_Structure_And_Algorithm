package com.pepak.bst;

public class PEP0446_SizeSumMinMaxFindBST{
	
	public static void display(TreeNode root) {
		if(root == null) return;
		
		System.out.print("root->"+root.val+" ");
		if(root.left != null) System.out.print("left->"+root.left.val+" ");
		if(root.right != null) System.out.print("right->"+root.right.val+" ");
		System.out.println();
		display(root.left);
		display(root.right);
	}
	
	public static int findMin(TreeNode root) {
		if(root == null) return Integer.MAX_VALUE;
		
		int leftVal = findMin(root.left);
		return Integer.min(leftVal, root.val);
	}
	
	public static int findMax(TreeNode root) {
		if(root == null) return Integer.MIN_VALUE;
		
		int rightVal = findMax(root.right);
		return Integer.max(rightVal, root.val);
	}
	
	public static int findSize(TreeNode root) {
		if(root == null) return 0;
		
		return findSize(root.left) + findSize(root.right)+1;
	}
	
	public static int sumTree(TreeNode root) {
		if(root == null) return 0;
		
		return sumTree(root.left) + sumTree(root.right)+root.val;
	}
	
	public static boolean findValue(TreeNode root, int value) {
		if(root == null) return false;
		
		if(root.val == value) return true;
		boolean left = findValue(root.left, value);
		boolean right = findValue(root.right, value);
		return left || right;
	}

	public static void main(String[] args) {
		int[] arr = {10,20,30,40,50,60,70};
		TreeNode root = TreeNode.createBinarySearchTree(arr, 0, arr.length-1);
		//display(root);
		System.out.println("Min value : "+ findMin(root));
		System.out.println("Max value : "+ findMax(root));
		System.out.println("Size of tree : "+ findSize(root));
		System.out.println("Sum of tree value : "+ sumTree(root));
		System.out.println("Is value present in tree: "+ findValue(root, 30));
	}
}
