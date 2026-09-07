package com.pepal.hashmapHeap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PEP0465_findCommonElement2 {

	public static void main(String[] args) {
		int[] arr1 = {1,1,2,2,2,3,5};
		int[] arr2 = {1,1,1,2,2,4,5};
		
		Map<Integer, Long> map = Arrays.stream(arr1)
		.boxed()
		.collect(Collectors.groupingBy(num -> num, Collectors.counting()));
		System.out.println(map);
		
		List<Integer> list = Arrays.stream(arr2)
	            .boxed()
	            .filter(num -> map.getOrDefault(num, 0L) > 0)
	            .peek(num -> map.put(num, map.get(num) - 1))
	            .collect(Collectors.toList());
		
		System.out.println(list);
	}
}
