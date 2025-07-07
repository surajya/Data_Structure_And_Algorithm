package com.array.nintyToOneThirty;

import java.util.Stack;

public class PEP109_NextGreaterElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {2,5,9,3,1,12,6,8,7};
		Stack<Integer> stack=new Stack<>();
		
		for(int i=arr.length-1; i>=0; i--) {
			int num=arr[i];
			if(stack.isEmpty()) {
				arr[i]=-1;
				stack.push(num);
			}else {
				while(stack.size()>0 && stack.peek()<num) stack.pop();
				if(stack.isEmpty()) {
					arr[i]=-1;
					stack.push(num);
				}else {
					arr[i]=stack.peek();
					stack.push(num);
				}
				
			}
		}
		for(int num:arr) System.out.print(num+" ");
		System.out.println();
		
		secondSol();
	}
	public static void secondSol() {
		int[] arr= {2,5,9,3,1,12,6,8,7};
		Stack<Integer> stack=new Stack<>();
		
		for(int i=0; i<arr.length; i++) {
			if(stack.size()==0) {
				arr[i]=-1;
				stack.push(i);
			}else {
				while(stack.size()>0 && arr[stack.peek()]<arr[i]) {
					arr[stack.peek()]=arr[i];
					stack.pop();
				}
				stack.push(i);
			}
		}
		while(stack.size()>0) {
			arr[stack.peek()]=-1;
			stack.pop();
		}
		for(int x:arr) System.out.print(x+" ");
	}

}
