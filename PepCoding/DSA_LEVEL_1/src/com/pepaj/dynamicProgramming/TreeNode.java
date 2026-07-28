package com.pepaj.dynamicProgramming;

import java.util.LinkedList;
import java.util.Queue;

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

      public static TreeNode createBinaryTree(Integer[] arr, int i){
          Queue<TreeNode> queue = new LinkedList<TreeNode>();
          TreeNode root = new TreeNode(arr[i]);
          queue.offer(root);
          for(int j=1; j<arr.length; j++){
              TreeNode cur = queue.poll();
              Integer val = arr[j++];
              if(val != null){
                  TreeNode temp = new TreeNode(val);
                  cur.left = temp;
                  queue.offer(temp);
              }
              if(j<arr.length && arr[j] != null){
                  TreeNode temp = new TreeNode(arr[j]);
                  cur.right = temp;
                  queue.offer(temp);
              }
          }

          return root;
      }
  }
