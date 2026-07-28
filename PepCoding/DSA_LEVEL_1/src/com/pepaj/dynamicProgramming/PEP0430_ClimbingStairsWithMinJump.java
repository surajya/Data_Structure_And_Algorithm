package com.pepaj.dynamicProgramming;

import java.time.Duration;
import java.time.LocalDateTime;

public class PEP0430_ClimbingStairsWithMinJump {

    public static void main(String[] args) {
        int[] stairs = new int[11];
        LocalDateTime t1 = LocalDateTime.now();
        System.out.println("Min Move to climb stairs : "+(findWay(stairs, 0)));
        LocalDateTime t2 = LocalDateTime.now();
        System.out.println("Seconds: " + (Duration.between(t2, t1).getSeconds()));
    }

    private static int findWay(int[] stairs, int i) {
        if(i>=stairs.length) return Integer.MAX_VALUE;
        if(i == stairs.length-1) return 0;

        if(stairs[i]!=0) return stairs[i]+1;

        int minMove= Integer.MAX_VALUE;
        for(int j=1; j<4; j++){
            minMove = Integer.min(minMove, findWay(stairs, i+j));
        }
        stairs[i] = minMove;
        return minMove+1;
    }
}
