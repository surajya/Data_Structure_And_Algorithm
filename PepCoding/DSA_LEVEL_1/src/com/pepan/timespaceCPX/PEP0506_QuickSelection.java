package com.pepan.timespaceCPX;

public class PEP0506_QuickSelection {

    public static void main(String[] args) {
       //non-sorted array
//        int[] array = {9,6,3,8,4,7,2,11,1};
//        int pivot = 5;
        int[] array = {3,8,3,1,2,4,5,5,6};
        int largest = 4;
        int ans = quickSort(array, 0, array.length-1, array.length-largest);
        System.out.println(largest +" largest element is: "+ans);
    }

    public static int quickSort(int[] array,int start, int end, int target){
        if (start > end) {
            return -1;
        }
        if (start == end) {
            return array[start];
        }
        int pivotIndx = partition(array,start,end);
        if(pivotIndx==target) return array[pivotIndx];
        else if(pivotIndx>target){
            return quickSort(array,start,pivotIndx-1, target);
        }else return quickSort(array,pivotIndx+1,end, target);
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
