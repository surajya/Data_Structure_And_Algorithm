package com.pepal.hashmapHeap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PEP0473_MedianPriorityQueue {

	private static int removeMed(PriorityQueue<Integer> pqLeft, PriorityQueue<Integer> pqRight) {
		int removedValue = 0;
		if(pqLeft.size()+pqRight.size()==0) {
			System.out.println("Sorry, QUEUE is empty!!!");
			return -1;
		}
		if(pqLeft.size() == 0) return pqRight.remove();
		else if(pqRight.size() == 0) return pqLeft.remove();
		else if((pqLeft.size()+pqRight.size())%2 == 0) removedValue = pqLeft.remove();
		else removedValue = pqRight.remove();
		checkSize(pqLeft, pqRight);
		return removedValue;
	}
	
	private static int peekMed(PriorityQueue<Integer> pqLeft, PriorityQueue<Integer> pqRight) {
		if(pqLeft.size()+pqRight.size()==0) {
			System.out.println("Sorry, QUEUE is empty!!!");
			return -1;
		}
		if(pqLeft.isEmpty()) return pqRight.peek();
		else if(pqRight.isEmpty()) return pqLeft.peek();
		else if((pqLeft.size()+pqRight.size())%2 == 0) return pqLeft.peek();
		else if(pqLeft.size() < pqRight.size()) return pqRight.peek();
		else return pqLeft.peek();
	}
	
	private static void insertValue(PriorityQueue<Integer> pqLeft, PriorityQueue<Integer> pqRight, int num) {
		if(pqLeft.isEmpty()) pqLeft.add(num);
		else if(pqLeft.peek() >= num) pqLeft.add(num);
		else pqRight.add(num);
		checkSize(pqLeft, pqRight);
	}
	
	private static void checkSize(PriorityQueue<Integer> pqLeft, PriorityQueue<Integer> pqRight) {
		int leftPQSize = pqLeft.size();
		int rightPQSize = pqRight.size();
		if(Math.abs(rightPQSize - leftPQSize)>1) {
			if(rightPQSize > leftPQSize) {
				int val = pqRight.remove();
				pqLeft.add(val);
			}else {
				int val = pqLeft.remove();
				pqRight.add(val);
			}
		}
	}
	
	public static void main(String[] args) {
		
		int[] arr = {10,20,1,50,60,0,90,1,40};
		PriorityQueue<Integer> pqLeft = new PriorityQueue<>(Comparator.reverseOrder());
		PriorityQueue<Integer> pqRight = new PriorityQueue<>();
		
		for(int num : arr) {
			if(num == 0) {
				System.out.println("median remove value is: "+removeMed(pqLeft, pqRight));
			}else if(num == 1) {
				System.out.println("median peek value is: "+ peekMed(pqLeft, pqRight));
			}else {
				insertValue(pqLeft, pqRight, num);
			}
		}
	}

}
