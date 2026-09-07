package com.pepal.hashmapHeap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PEP0466_LongestConsecutiveSequence {

	public static void main(String[] args) {
		int[] arr = {10,5,9,1,11,8,6,15,3,12,2};
		
		HashMap<Integer, Boolean> hm = new HashMap<>();
		
		for(int i=0; i<arr.length; i++) {
			hm.put(arr[i], true);
		}
		
		for(int i=0; i<arr.length; i++) {
			if(hm.containsKey(arr[i]-1)) hm.put(arr[i], false);
		}
		
		ArrayList<Integer> ans = new ArrayList<>();
		for(int i=0; i<arr.length; i++) {
			int value = arr[i];
			if(hm.get(value)==true) {
				ArrayList<Integer> dummyAns = new ArrayList<>();
				while(hm.containsKey(value)) {
					dummyAns.add(value);
					value++;
				}
				ans = dummyAns.size() > ans.size() ? dummyAns : ans;
			}
		}
		System.out.print(ans);
	}
}
