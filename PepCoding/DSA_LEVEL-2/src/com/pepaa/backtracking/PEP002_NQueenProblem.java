package com.pepaa.backtracking;

public class PEP002_NQueenProblem {

    public static void main(String[] args) {
        int rows = 10, cols = 10;
        boolean[] colRest =  new boolean[cols];
        boolean[] diagRest =  new boolean[2 * (rows-1)+1];
        boolean[] revDiagRest =  new boolean[2 * (rows-1)+1];
        findWayToQueenSit(0, rows, cols, colRest, diagRest, revDiagRest, "");
    }

    private static void findWayToQueenSit(int i, int rows, int cols, boolean[] colRest, boolean[] diagRest, boolean[] revDiagRest, String path) {

        for(int j=0; j<cols; j++){
            if(checkPosition(i,j, rows, colRest, diagRest, revDiagRest)){
                String newPath = path + i + "_" + j +", ";
                colRest[j] = true;
                diagRest[i+j] = true;
                revDiagRest[i-j + rows -1] = true;
                if(i==rows-1) System.out.println(newPath);
                else findWayToQueenSit(i+1, rows, cols, colRest, diagRest, revDiagRest, newPath);
                colRest[j] = false;
                diagRest[i+j] = false;
                revDiagRest[i-j + rows -1] = false;
            }
        }
    }

    private static boolean checkPosition(int i, int j, int rows, boolean[] colRest, boolean[] diagRest, boolean[] revDiagRest) {
        if(colRest[j] || diagRest[i+j] || revDiagRest[i-j + rows -1]) return false;
        return true;
    }
}
