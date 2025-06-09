package com.pep.zeroToFifty;

import java.util.Scanner;

public class PEP071_Pattern19 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows (recommended odd number): ");
        int totalRows = Integer.parseInt(sc.nextLine());
        sc.close();

        int mid=totalRows/2+1;
        for (int i = 1; i <= totalRows; i++) {
        	
            for (int j = 1; j <= totalRows; j++) {
//            	if((j==mid || i==mid || i==1 || i==totalRows || j==1 || j==totalRows) ) System.out.print("* ");
//            	else System.out.print("  ");
            	
            	if(i==1) {
            		if(j<=mid || j==totalRows) System.out.print("* ");
            		else System.out.print("  ");
            		
            	}else if(i<mid) {
            		if(j==mid || j==totalRows) System.out.print("* ");
            		else System.out.print("  ");
            		
            	}else if(i==mid) {
            		System.out.print("* ");
       
            		
            	}else if(i<totalRows) {
            		if(j==1 || j==mid) System.out.print("* ");
            		else System.out.print("  ");
            		
            	}else if(i==totalRows){
            		if(j>=mid || j==1) System.out.print("* ");
            		else System.out.print("  ");
            	}
            	
            }
            
            
            System.out.println();
        }
    }
}
