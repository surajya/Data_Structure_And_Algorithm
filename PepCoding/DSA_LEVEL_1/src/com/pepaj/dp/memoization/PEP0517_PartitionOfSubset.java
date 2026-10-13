package com.pepaj.dp.memoization;

public class PEP0517_PartitionOfSubset {

    public static void main(String[] args) {
        int[] dp = new int[5];
        int k=3;
        dp[k] = 1;
        for(int i=k+1; i<dp.length; i++){
            dp[i] = dp[i-1] + dp[i-i]*k;
        }

        System.out.println("total pairing between "+(dp.length-1)+" is : "+dp[dp.length-1]);
    }
}
