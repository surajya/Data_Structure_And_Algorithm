package com.pepan.timespaceCPX;

public class PEP0503_MergeSort {

    public static void main(String[] args){
        int[] arr = {1,33,22,5,12,19,17, 28,25,23,29};
        int[] sortedArray = mergeSort(arr,0, arr.length-1);
        for(int i=0;i<sortedArray.length;i++){
            System.out.print(sortedArray[i]+" ");
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
