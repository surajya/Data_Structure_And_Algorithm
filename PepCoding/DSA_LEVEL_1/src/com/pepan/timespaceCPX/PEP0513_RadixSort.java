package com.pepan.timespaceCPX;

public class PEP0513_RadixSort {

    public static void main(String[] args) {
        int[] array = {109,3326,6543,55,983,874,543,6789,109876,654,256,195,928,439,65429};
        int max = Integer.MIN_VALUE;
        for(int i=0;i<array.length;i++) max = Math.max(max,array[i]);
        int exp = 1;
        while(max>0){
            array = radixSort(array,exp);
            exp *= 10;
            max /=10;
        }

        for(int a : array){
            System.out.print(a+", ");
        }
    }

    public static int[] radixSort(int[] arr, int exp){
        int[] ans = new int[arr.length];
        int[] freqArr = new int[10];
        for(int a : arr){
            freqArr[(a/exp)%10]++;
        }

        for(int i = 1;i < freqArr.length;i++){
            freqArr[i] += freqArr[i-1];
        }

        for(int i=0;i<freqArr.length;i++){
            freqArr[i] = freqArr[i]-1;
        }

        for(int i=arr.length-1;i>=0;i--){
            int value = arr[i];
            ans[freqArr[(value/exp)%10]] = value;
            freqArr[(value/exp)%10]--;
        }
        return ans;
    }
}
