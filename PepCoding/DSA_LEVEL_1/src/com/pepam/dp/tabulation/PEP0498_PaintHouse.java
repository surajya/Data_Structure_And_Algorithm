package com.pepam.dp.tabulation;

public class PEP0498_PaintHouse {

    public static void main(String[] args){
        int[][] arr = {{3,5,7,4},{6,2,9,2},{4,8,1,7},{7,3,5,1}};
        int[][] dp = new int[arr.length][arr[0].length];
        for(int i=0;i<arr.length;i++){
            if(i==0) {
                for(int k=0; k<arr[0].length; k++){
                    dp[i][k]=arr[i][k];
                }
            }else{
                for(int j=0;j<arr[i-1].length;j++){
                    int value = Integer.MAX_VALUE;
                    for(int k=0;k<arr[i-1].length;k++){
                        if(j!=k) value = Integer.min(value,dp[i-1][k]);
                    }
                    dp[i][j]=value + arr[i][j];
                }
            }
        }
        int minValue = Integer.MAX_VALUE;
        for(int k=0; k<arr[0].length; k++){
            minValue = Integer.min(minValue,dp[arr.length-1][k]);
        }
        System.out.println("min cost to paint the house -> "+minValue);
    }
}
