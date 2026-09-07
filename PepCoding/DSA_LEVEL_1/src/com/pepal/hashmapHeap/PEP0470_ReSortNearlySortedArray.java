package com.pepal.hashmapHeap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class PEP0470_ReSortNearlySortedArray {

	public static void main(String[] args) {
		
		int[] arr = {3,4,1,2,5,8,9,6,7};
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i=0; i<3; i++) {
			pq.add(arr[i]);
		}
		int x=0;
		for(int i=3; i<arr.length; i++) {
			arr[x++] = pq.remove();
			pq.add(arr[i]);
		}
		
		while(!pq.isEmpty()) {
			arr[x++] = pq.remove();
		}
		
		for(int a:arr) {
			System.out.print(a+" ");
		}
	}
}
