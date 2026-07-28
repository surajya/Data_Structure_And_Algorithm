package com.pepac.array;

import java.util.Stack;

public class PEP125_CelebrityProblem {

	public static void main(String[] args) {
		int[][] celebrity= {{0,1,1,1,1},{1,0,0,1,0},{1,1,0,1,0},{0,0,0,0,0},{0,1,0,1,0}};
		Stack<Integer> stack=new Stack<>();
		for(int i=0; i<celebrity.length; i++) {
			stack.push(i);
		}
		
		while(true) {
			int a=stack.pop(), b=stack.pop();
			if(celebrity[a][b]==0 && celebrity[b][a]==1) stack.push(a);
			else if(celebrity[b][a]==0 && celebrity[a][b]==1) stack.push(b);
			if(stack.size()==1) {
				System.out.println("celebrity is: "+stack.pop());
				break;
			}
			else if(stack.isEmpty()) {
				System.out.println("No celebrity found");
				break;
			}
		}
	}

}
