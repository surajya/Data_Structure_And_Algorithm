package com.array.nintyToOneThirty;

import java.util.Stack;

public class PEP111_StockSpan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {2,3,5,2,4,1,2,3,7,5,2,3,4,6,3};
		Stack<Integer> stack=new Stack<>();
		
		for(int i=arr.length-1; i>=0; i--) {
			if(stack.isEmpty()) {
				stack.push(i);
			}else {
				while(stack.size()>0 && arr[i]>arr[stack.peek()]) {
					arr[stack.peek()]=i;
					stack.pop();
				}
				stack.push(i);
			}
		}
		while(stack.size()>0) {
			arr[stack.peek()]=-1;
			stack.pop();
		}
		for(int i=0; i<arr.length; i++) {
			if(arr[i]==-1) arr[i]=i+1;
			else arr[i]=i-arr[i];
		}
		for(int x:arr) System.out.print(x+" ");
	}

}
