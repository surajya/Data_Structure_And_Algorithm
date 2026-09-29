package com.pepan.timespaceCPX;

public class PEP0502_mergeTwoSortedArray {

    public static void main(String[] args){
        int[] arr1 = {1,2,3,4,9,11,34,54};
        int[] arr2 = {5,6,7,8,10,12,13,36};
        int[] mergeArray = new int[arr1.length+arr2.length];
        int i=0, j=0, k=0;
        while(i<arr1.length && j<arr2.length){
            if(arr1[i]>=arr2[j])mergeArray[k++]=arr2[j++];
            else mergeArray[k++]=arr1[i++];
        }

        while(i<arr1.length){
            mergeArray[k++]=arr1[i++];
        }
        while(j<arr2.length){
            mergeArray[k++]=arr2[j++];
        }
        for(int a:mergeArray){
            System.out.print(a+" ");
        }
    }
}
