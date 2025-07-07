package com.array.nintyToOneThirty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PEP127_MergeOverlapping {

	public static void main(String[] args) {
		
		int[][] arr= {{22,28}, {1,8}, {25, 27}, {14, 19}, {27, 30}, {5, 12}};
		
		Arrays.sort(arr, (a,b)->a[0]-b[0]);
		
		Stack<Integer> stack=new Stack<>();
		
		List<List<Integer>> list=new ArrayList<>();
		
		for(int i=0; i<arr.length; i++) {
			int a=arr[i][0], b=arr[i][1];
			if(stack.isEmpty()) {
				stack.push(a); stack.push(b);
			}else {
				if(a<=stack.peek()) {
					stack.pop();
					stack.push(b);
				}else {
					int c=stack.pop(), d=stack.pop();
					List<Integer> list1=Arrays.asList(d,c);
					list.add(list1);
					stack.push(a); stack.push(b);
				}
			}
		}
		if(!stack.isEmpty()) {
			int c=stack.pop(), d=stack.pop();
			List<Integer> list1=Arrays.asList(d,c);
			list.add(list1);
		}
		
		System.out.println(list);
	}

}
