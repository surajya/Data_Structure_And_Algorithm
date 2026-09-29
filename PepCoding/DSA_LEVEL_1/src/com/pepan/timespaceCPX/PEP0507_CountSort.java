package com.pepan.timespaceCPX;

public class PEP0507_CountSort {

    public static void main(String[] args) {
        int[] array = {9,6,3,5,3,4,3,9,6,4,6,5,8,9,9};
        int[] ans = countSort(array);
        for(int a : ans){
            System.out.print(a+", ");
        }
    }

    public static int[] countSort(int[] arr){
        int[] ans = new int[arr.length];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int a : arr){
            min = Math.min(a,min);
            max = Math.max(a,max);
        }
        int range = (max-min+1);

        int[] freqArr = new int[range];
        for(int a : arr){
            freqArr[a-min]++;
        }

        for(int i = 1;i < freqArr.length;i++){
            freqArr[i] += freqArr[i-1];
        }

        for(int i=0;i<freqArr.length;i++){
            freqArr[i] = freqArr[i]-1;
        }

        for(int i=arr.length-1;i>=0;i--){
            int value = arr[i];
            ans[freqArr[value-min]] = value;
            freqArr[value-min]--;
        }
        return ans;
    }
}
