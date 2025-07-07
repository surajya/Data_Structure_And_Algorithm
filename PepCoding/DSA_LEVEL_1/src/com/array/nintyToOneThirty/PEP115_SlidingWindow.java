package com.array.nintyToOneThirty;

import java.util.Stack;

public class PEP115_SlidingWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] histogram= {2,9,3,8,1,7,12,6,14,4,32,0,7,19,8,12,6};
		int[] histogram= {1,3,-1,-3,5,3,6,7};
		int slide=3;
		int len=histogram.length;
		int[] rb=new int[len];
		
		findRightBoundary(histogram, rb);
		
		int j=0;
		for(int i=0; i<=len-slide; i++) {
			j=i;
			while(rb[j]<i+slide && histogram[j]<histogram[rb[j]]) {
				j=rb[j];
			}
			histogram[i]=histogram[j];
		}
		for(int i=0; i<=len-slide; i++) System.out.print(histogram[i]+"  ");
	}
	 
	public static void findRightBoundary(int[] arr, int[] rb) {
		
		Stack<Integer> stack=new Stack<Integer>();
		
		for(int i=0; i<rb.length; i++) {
			
				while(stack.size()>0 && arr[i]>arr[stack.peek()]) {
					rb[stack.peek()]=i;
					stack.pop();
				}
				stack.push(i);
			
		}
		while(stack.isEmpty()==false) {
			rb[stack.peek()]=stack.pop();
		}
	}
	
}
