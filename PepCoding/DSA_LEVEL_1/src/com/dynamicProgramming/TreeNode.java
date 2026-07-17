package com.dynamicProgramming;

public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }

      public static TreeNode createTree(int[] arr, int i){
          if(i >= arr.length || arr[i] == -1) return null;

          TreeNode rootNode = new TreeNode(arr[i]);
          rootNode.left = createTree(arr,2*i+1);
          rootNode.right = createTree(arr,2*i+2);
          return rootNode;
      }
  }
