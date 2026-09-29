package com.pepan.timespaceCPX;

public class PEP0512_PivotOfSortedArray {

    public static void main(String[] args) {
        int[] array = {30,40,50,10,20,22,23,24,25};
        int targetSum = 160;
        int ans  = findPivot(array, 0, array.length-1);
        System.out.println("Pivot value is: "+ans);
    }

    private static int findPivot(int[] arr, int i, int j) {
        while(i<j){
            int mid = (i+j)/2;
            if(arr[mid]<arr[j]) j=mid;
            else i=mid+1;
        }
        return arr[j];
    }
}
