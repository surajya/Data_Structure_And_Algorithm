package com.pepan.timespaceCPX;

public class PEP0504_PartiioningInArray {

    public static void main(String[] args) {
       //non-sorted array
//        int[] array = {9,6,3,8,4,7,2,11,1};
//        int pivot = 5;
        int[] array = {3,8,4,7,6};
        int pivot = 6;
        int i = 0, j=0;
        while(i<array.length){
            if(i==j || array[i]>pivot) i++;
            else if(array[j]<pivot) j++;
            else if(array[i] <= pivot){
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j++;
            }
        }

        for(int a:array){
            System.out.print(a+" ");
        }
    }
}
