package com.pepaj.dynamicProgramming;

import java.util.Arrays;

public class PEP0443_PathWithMaximumGold {

    public static void main(String[] args){
        int[][] arr = {{2,3, 0, 5}, {4, 3, 8, 6}, {2, 1, 5, 3}, {3, 1, 2, 4}};
        Integer[][] dp = new Integer[arr.length][arr[0].length];
        Arrays.fill(dp[0],null);
        Integer maxCost = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            maxCost = Integer.max(maxCost, findCostOfPath(arr, dp, i, 0, 0));
        }
        System.out.println("Maximum Gold in the Path: "+maxCost);
    }

    private static Integer findCostOfPath(int[][] arr, Integer[][] dp, int i, int j, int cost) {
        if(checkPathInvalid(arr, i, j)) return null;
        if(dp[i][j]!=null) return dp[i][j];
        if(j==arr[0].length-1) return cost+arr[i][j];

        Integer hu = findCostOfPath(arr, dp, i-1, j+1, cost);
        Integer h = findCostOfPath(arr, dp, i, j+1, cost);
        Integer hd = findCostOfPath(arr, dp, i+1, j+1, cost);
        Integer maxGold = 0 ;
        if(hu != null) maxGold =Math.max(maxGold, hu);
        if(h != null) maxGold =Math.max(maxGold, h);
        if(hd != null) maxGold =Math.max(maxGold, hd);

        dp[i][j] = maxGold + arr[i][j];
        return maxGold + arr[i][j];
    }

    private static boolean checkPathInvalid(int[][] arr, int i, int j) {
        if(i>arr.length-1 || i < 0 || j > arr[0].length-1 || j < 0) return true;
        return false;
    }

}
