package com.pepan.timespaceCPX;

public class PEP0518_BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        int[] stock = {23, 11,54,22,65,11,98,34,59,80};
        int maxProfit=0, minValue = stock[0];

        for(int i=1; i<stock.length; i++){
            if(stock[i]>maxProfit){
                maxProfit=stock[i] -  minValue;
            }else if(stock[i]<minValue){
                minValue=stock[i];
            }
        }
        System.out.println(maxProfit);
    }
}
