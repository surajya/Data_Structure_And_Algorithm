package com.pepaj.dynamicProgramming;

import java.util.Arrays;

public class PEP0440_MinimumCostPath {

    public static void main(String[] args){
        int[][] arr = {{2,3, -1, 5}, {4, -3, 8, 6}, {2, 1, 5, 3}, {3, 1, 2, 4}};
        Integer[][] dp = new Integer[arr.length][arr[0].length];
        Arrays.fill(dp[0],null);
        System.out.println("Minimum Cost of the Path: "+findCostOfPath(arr, dp,0, 0, 0));
    }

    private static Integer findCostOfPath(int[][] arr, Integer[][] dp, int i, int j, int cost) {
        if(checkPathInvalid(arr, i, j)) return null;
        if(dp[i][j]!=null) return dp[i][j];
        if(i==arr.length-1 && j==arr[0].length-1) return cost+arr[i][j];

        Integer h = findCostOfPath(arr, dp, i, j+1, cost);
        Integer w = findCostOfPath(arr, dp, i+1, j, cost);
        Integer minCost = 0 ;
        if(h!=null && w!=null) minCost = Math.min(h,w);
        else if (h != null) minCost = h;
        else if (w != null) minCost = w;
        dp[i][j] = minCost + arr[i][j];
        return minCost + arr[i][j];
    }

    private static boolean checkPathInvalid(int[][] arr, int i, int j) {
        if(i>arr.length-1 || i < 0 || j > arr[0].length-1 || j < 0) return true;
        return false;
    }

}
