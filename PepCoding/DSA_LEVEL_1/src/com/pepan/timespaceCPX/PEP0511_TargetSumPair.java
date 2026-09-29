package com.pepan.timespaceCPX;

public class PEP0511_TargetSumPair {

    public static void main(String[] args) {
        int[] array = {9, -48, 100, 43, 84, 74, 86, 34, -37, 60, -29, 44};
        int targetSum = 160;
        array = mergeSort(array, 0, array.length-1);
        int i=0, j= array.length-1;
        while(i<j){
            if(array[i]+array[j]==targetSum){
                System.out.println("160 is sum of -> "+array[i]+":"+array[j]);
                i++; j--;
            }else if(array[i]+array[j]>targetSum) j--;
            else i++;
        }
    }

    private static int[] mergeSort(int[] arr, int i1, int j1) {
        if(i1==j1)  return new int[]{arr[i1]};

        int mid = (i1+j1)/2;
        int[] leftArray = mergeSort(arr,i1,mid);
        int[] rightArray = mergeSort(arr,mid+1,j1);
        int[] mergeArray = new int[leftArray.length+rightArray.length];
        int i=0, j=0, k=0;
        while(i<leftArray.length && j<rightArray.length){
            if(leftArray[i]>=rightArray[j])mergeArray[k++]=rightArray[j++];
            else mergeArray[k++]=leftArray[i++];
        }

        while(i<leftArray.length){
            mergeArray[k++]=leftArray[i++];
        }
        while(j<rightArray.length){
            mergeArray[k++]=rightArray[j++];
        }

        return mergeArray;
    }
}
