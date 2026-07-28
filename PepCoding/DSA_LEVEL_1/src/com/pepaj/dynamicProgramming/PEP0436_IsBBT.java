package com.pepaj.dynamicProgramming;

public class PEP0436_IsBBT {

    public static void main(String[] args){
        Integer[] nodeArray = {0,1,1,2,1,3,1,4,1,5,1,6,1,7,1,8,1,9,1,0,1,1,1,2,1,3,1,4,1,5,1,6,1,7,1,8,1,9,1,0,1,1,1,2};
                TreeNode rootNode = TreeNode.createBinaryTree(nodeArray, 0);
        System.out.println("Is this Binary Tree is balance binary Tree: "+isBalanced(rootNode));
    }

    public static boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        if(isBalanced(root.left) &&  isBalanced(root.right)){
            int lefth =0; int righth =  0;
            if(root.left != null ) lefth = root.left.val;
            if(root.right != null) righth = root.right.val;
            root.val = (Integer.max(lefth, righth))+1;

            if(Math.abs(lefth - righth) < 2) return true;
            else return false;
        }
        return false;
    }

}
