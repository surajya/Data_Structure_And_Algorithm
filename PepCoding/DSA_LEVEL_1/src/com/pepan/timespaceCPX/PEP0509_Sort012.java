package com.pepan.timespaceCPX;

public class PEP0509_Sort012 {

    public static void main(String[] args) {
        int[] array = {2,0,2,1,1,0,1,2,0,2,0,1,0,2,0,1,1,2};
        sortZeroOneTwo(array, 1);
        for(int a : array){
            System.out.print(a+", ");
        }
    }

    private static void sortZeroOneTwo(int[] array, int pivot) {
        int i=0, j=0, k=array.length-1;
        while(i<array.length && i<k){
            if(array[i]==0){
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j++;
            }else if(array[i] == 1) i++;
            else{
                int temp = array[i];
                array[i] = array[k];
                array[k] = temp;
                k--;
            }
        }
    }
}
