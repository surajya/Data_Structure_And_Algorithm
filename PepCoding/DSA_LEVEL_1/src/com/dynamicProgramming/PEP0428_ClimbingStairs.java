package com.dynamicProgramming;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PEP0428_ClimbingStairs {

    public static void main(String[] args) {
        int[] stairs = new int[11];
        LocalDateTime t1 = LocalDateTime.now();
        System.out.println("Total way to climb : "+findWay(stairs, 0));
        LocalDateTime t2 = LocalDateTime.now();
        System.out.println("Seconds: " + (Duration.between(t2, t1).getSeconds()));
    }

    private static int findWay(int[] stairs, int i) {
        if(i>=stairs.length) return 0;
        if(i == stairs.length-1) return 1;

        if(stairs[i]!=0) return stairs[i];
        int total = 0;
        for(int j=1; j<4; j++){
            total += findWay(stairs, i+j);
        }
        stairs[i] = total;
        return total;
    }
}
