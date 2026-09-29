package com.pepan.timespaceCPX;

public class PEP0505_QuickSortInArray {

    public static void main(String[] args) {
       //non-sorted array
        int[] array = {99,6,35,82,4,77,2,11,12,77,12,12,1};
//        int pivot = 5;
//        int[] array = {3,8,4,7,6};
//        int pivot = 6;
        int[] array1=quickSort(array, 0, array.length-1);
        for(int a:array1){
            System.out.print(a+" ");
        }
    }

    public static int[] quickSort(int[] array,int start, int end){
        if(start>end) return array;
        int pivotIndx = partition(array,start,end);
        quickSort(array,start,pivotIndx-1);
        quickSort(array,pivotIndx+1,end);
        return array;
    }

    public static int partition(int[] array,int start, int end){
        int i = start, j=start;
        int pivot = array[end];
        while(i<=end){
            if(array[i] <= pivot){
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j++;
            }else i++;
        }
        return j-1;
    }
}
