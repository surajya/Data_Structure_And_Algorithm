package com.pepaj.dynamicProgramming;

public class PEP0432_TiltOfBinaryTree {

    public static void main(String[] args){
        Integer[] nodeArray = {21,7,14,1,1,2,2,3,3};
        TreeNode rootNode = TreeNode.createBinaryTree(nodeArray, 0);
        displayBT(rootNode);
        System.out.println();
        System.out.print("Tilt value of BT : "+ findTiltBinaryTree(rootNode));
        System.out.println();
    }

    private static void displayBT(TreeNode rootNode) {
        if(rootNode == null) return;
        displayBT(rootNode.left);
        System.out.print(rootNode.val + " ");
        displayBT(rootNode.right);
    }

    public static int findTiltBinaryTree(TreeNode root){
        if(root == null) return 0;

        int leftTilt = findTiltBinaryTree(root.left);
        int rightTilt = findTiltBinaryTree(root.right);
        int rootTilt = Math.abs((root.left!=null ? root.left.val : 0) - (root.right!=null ? root.right.val : 0));
        root.val = root.val + (root.left!=null ? root.left.val : 0) + (root.right!=null ? root.right.val : 0);

        return (leftTilt + rightTilt + rootTilt);
    }

}
