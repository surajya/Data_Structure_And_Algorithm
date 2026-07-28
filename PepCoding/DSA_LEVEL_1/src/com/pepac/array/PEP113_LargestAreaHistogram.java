package com.pepac.array;

import java.util.Stack;

public class PEP113_LargestAreaHistogram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] histogram= {6,2,5,4,5,1,6};
		int len=histogram.length;
		int[] lb=new int[len];
		int[] rb=new int[len];
		
		findLeftBoundary(histogram, lb);
		
		findRightBoundary(histogram, rb);
		
		int maxArea=0, area=0;
		for(int i=0; i<len; i++) {
			if(lb[i]==-1 && rb[i]==-1) {
				area=len*histogram[i];
			}else if(lb[i]==-1) {
				area=rb[i]*histogram[i];
			}else if(rb[i]==-1) {
				area=(len-lb[i]-1)*histogram[i];
				
			}else {
				area=(rb[i]-lb[i]-1)*histogram[i];	
			}
			maxArea=Math.max(maxArea, area);
		}
		
		System.out.println("max area: "+maxArea);
	}
	 
	public static void findLeftBoundary(int[] arr, int[] lb) {
		
		Stack<Integer> stack=new Stack<Integer>();
		for(int i=lb.length-1; i>=0; i--) {
			if(stack.isEmpty()) {
				stack.push(i);
			}
			else {
				while(stack.size()>0 && arr[i]<arr[stack.peek()]) {
					lb[stack.peek()]=i;
					stack.pop();
				}
				stack.push(i);
			}
			
		}
		
		while(stack.isEmpty()==false) {
			lb[stack.pop()]=-1;
		}
	}
	
public static void findRightBoundary(int[] arr, int[] lb) {
		
		Stack<Integer> stack=new Stack<Integer>();
		for(int i=0; i<arr.length; i++) {
			if(stack.isEmpty()) {
				stack.push(i);
			}
			else {
				while(stack.size()>0 && arr[i]<arr[stack.peek()]) {
					lb[stack.peek()]=i;
					stack.pop();
				}
				stack.push(i);
			}
			
		}
		
		while(stack.isEmpty()==false) {
			lb[stack.pop()]=-1;
		}
	}



}
