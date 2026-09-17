package com.pepam.dp.tabulation;

public class PEP0497_MaxSumNonAdjElement {

    public static void main(String[] args){
        int[] arr = {5,10,10,100,5,6};
        int[][] dp = new int[arr.length][2];
        for(int i=0;i<arr.length;i++){
            if(i==0) {
                dp[i][0]=arr[i];
                dp[i][1]=0;
            }else{
                dp[i][0]=dp[i-1][1]+arr[i];
                dp[i][1]=Integer.max(dp[i-1][0], dp[i-1][1]);
            }
        }

        System.out.println("MAX SUM of the non adjecent element -> "+dp[arr.length-1][0]);
    }
}
