package com.pep.zeroToFifty;

import java.util.Scanner;

public class PEP073_Pattern20 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows (recommended odd number): ");
        int totalRows = Integer.parseInt(sc.nextLine());
        sc.close();

        
        int mid=totalRows/2+1, lastrow=totalRows-1;
        int after=mid, before=mid;
        for (int i = 1; i <= totalRows; i++) {
        	
            for (int j = 1; j <= totalRows; j++) {
            	if(j==1 || j==totalRows) System.out.print("* ");
            	else if(i>=mid && (j==before || j==after)) System.out.print("* ");
            	else System.out.print("  ");
            	
            }
            if(i>=mid) {before--; after ++;}
            if(i>mid) lastrow--;
            System.out.println();
        }
    }
}
