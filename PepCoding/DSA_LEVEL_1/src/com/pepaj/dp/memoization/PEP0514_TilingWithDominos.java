package com.pepaj.dp.memoization;

public class PEP0514_TilingWithDominos {

    public static void main(String[] args) {
        int tile = 1;
        int floor = 8;
        int height = 3;

        int[] dp = new int[floor+1];

        System.out.println("Total way for tiling : "+ wayToTilingFloor(dp, 1, height));
    }

    private static int wayToTilingFloor(int[] dp, int floor, int height) {

        if(floor >= dp.length) return 0;
        if(floor + height > dp.length) return 1;
        if(floor + height == dp.length) return 2;

        if(dp[floor] != 0) return dp[floor];
        int vertical =  wayToTilingFloor(dp, floor + 1,  height);
        int horizontal =  wayToTilingFloor(dp, floor + height, height);
        int totalWay = vertical + horizontal;
        dp[floor] = totalWay;
        return totalWay;
    }
}
