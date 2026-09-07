package com.pepak.bst;

public class PEP0449_RemoveNodeInBST{
	
	public static void display(TreeNode root) {
		if(root == null) return;
		
		System.out.print("root->"+root.val+" ");
		if(root.left != null) System.out.print("left->"+root.left.val+" ");
		if(root.right != null) System.out.print("right->"+root.right.val+" ");
		System.out.println();
		display(root.left);
		display(root.right);
	}
	
	public static TreeNode removeNode(TreeNode root, int value) {
		if(root == null) return null;
		if(root.val > value) {
			root.left = removeNode(root.left, value);
		}
		else if(root.val < value) {
			root.right = removeNode(root.right, value);
		}else {
			if(root.left==null && root.right==null) return null;
			else if(root.left==null && root.right!=null) return root.right;
			else if(root.left!=null && root.right==null) return root.left;
			else {
				root.val = minVal(root.right);
				root.right = removeNode( root.right, root.val);
			}
		}
		return root;
	}
	
	public static int minVal(TreeNode root) {
		if(root.left==null) return root.val;
		return minVal(root.left);
	}

	public static void main(String[] args) {
		int[] arr = {10,20,30,40,50,60,70};
		TreeNode root = TreeNode.createBinarySearchTree(arr, 0, arr.length-1);
		display(root);
		removeNode(root, 40);
		System.out.println("Node Remove Successfully........");
		display(root);
		
	}
}
