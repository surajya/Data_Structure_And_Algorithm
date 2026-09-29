package com.pepan.timespaceCPX;

public class PEP0508_Sort01 {

    public static void main(String[] args) {
        int[] array = {0,0,1,1,0,0,1,0,0,1,1};
        sortZeroOne(array, 0);
        for(int a : array){
            System.out.print(a+", ");
        }
    }

    private static void sortZeroOne(int[] array, int pivot) {
        int i=0, j=0;
        while(i<array.length){
            if(array[i]<=pivot){
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j++;
            }else i++;
        }
    }


}
