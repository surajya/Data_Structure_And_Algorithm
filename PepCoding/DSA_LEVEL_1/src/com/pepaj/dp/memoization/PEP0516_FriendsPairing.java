package com.pepaj.dp.memoization;

public class PEP0516_FriendsPairing {

    public static void main(String[] args) {
        int[] dp = new int[6];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<dp.length; i++){
            dp[i] = dp[i-1] + dp[i-2]*(i-1);
        }

        System.out.println("total pairing between "+(dp.length-1)+" is : "+dp[dp.length-1]);
    }
}
