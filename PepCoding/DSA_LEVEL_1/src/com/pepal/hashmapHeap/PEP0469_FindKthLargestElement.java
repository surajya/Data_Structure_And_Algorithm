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

public class PEP0469_FindKthLargestElement {

	public static void main(String[] args) {
		
		int[] arr = {12,34,1,3,54,32,23};
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		
		for(int a:arr) {
			pq.add(a);
		}
		int a =3;
		while(a-->1) pq.remove();
		if(pq.size()>0) System.out.println("Kth largest element is : "+pq.remove());
		else System.out.println("Kth element is out of array");
	}
}
