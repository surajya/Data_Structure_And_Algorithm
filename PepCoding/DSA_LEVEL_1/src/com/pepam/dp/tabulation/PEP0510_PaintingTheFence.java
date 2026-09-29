package com.pepam.dp.tabulation;

public class PEP0510_PaintingTheFence {

    public static void main(String[] args){
        int n=4, k=3;
        int[] dp = new int[n];
        int prevValue =6;
        dp[1] = 9;

        for(int i=2;i<n;i++){
            int same = prevValue;
            int diff = dp[i-1] * (k-1);
            dp[i] = same + diff;
            prevValue = diff;
        }

        System.out.println("total way to paint the fenses -> "+dp[n-1]);
    }
}
