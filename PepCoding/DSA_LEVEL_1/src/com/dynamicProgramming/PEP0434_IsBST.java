package com.dynamicProgramming;

public class PEP0434_IsBST {

    public static void main(String[] args){
        int[] nodeArray = {50,25,75,12,26,62,87};
        TreeNode rootNode = TreeNode.createTree(nodeArray, 0);
        System.out.println("Is this Binary Tree is binary Search Tree: "+checkBST(rootNode, ""));
    }

    private static boolean checkBST(TreeNode rootNode, String side) {
        if(rootNode==null) return true;

        if(checkBST(rootNode.left, "left") && checkBST(rootNode.right, "right") ) {
            if(!checkNodeValue(rootNode)) return false;
            if("left".equalsIgnoreCase(side) && rootNode.right != null) rootNode.val = rootNode.right.val;
            if("right".equalsIgnoreCase(side) && rootNode.left != null) rootNode.val = rootNode.left.val;
            return true;
        }
        return false;
    }

    private static boolean checkNodeValue(TreeNode rootNode) {
        if(rootNode.left!=null && rootNode.right!=null &&  rootNode.val<rootNode.left.val && rootNode.val > rootNode.right.val) return false;
        if(rootNode.left!=null && rootNode.val<rootNode.left.val) return false;
        if(rootNode.right!=null && rootNode.val > rootNode.right.val) return false;
        return true;
    }

}
