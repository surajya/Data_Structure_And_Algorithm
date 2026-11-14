package com.pepaa.backtracking;

import java.util.Arrays;

public class PEP004_GameExecutionJosephusProblem {

    public static void main(String[] args) {
        boolean[] people = new boolean[7];
        Arrays.fill(people,true);
        int k =3;
        int totalLive = people.length;
        int currentPosition = -1;
        while(totalLive > 1){
            int dummyk = k;
            while(dummyk>0){
                currentPosition = (currentPosition+1) % people.length;
                if(people[currentPosition]) dummyk--;

            }
            people[currentPosition] = false;
            totalLive--;
        }

        for(int i=0;i< people.length;i++){
            if(people[i]){
                System.out.println(i+" : IS LIVE ");
            }
        }

        System.out.println(findSolution(7, 3)+": is live by recursion");
    }

    private static int findSolution(int n, int k){
        if(n==1) return 0;
        int livePeople = findSolution(n-1, k);
        return (livePeople+k) % n;
    }
}
