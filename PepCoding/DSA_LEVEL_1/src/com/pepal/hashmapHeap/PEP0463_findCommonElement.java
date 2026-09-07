package com.pepal.hashmapHeap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PEP0463_findCommonElement {

	public static void main(String[] args) {
		int[] arr1 = {1,1,2,2,2,3,5};
		int[] arr2 = {1,1,1,2,2,4,5};
		
		Map<Integer, Long> map = Arrays.stream(arr1)
		.mapToObj(num -> (int)num)
		.collect(Collectors.groupingBy(num -> num, Collectors.counting()));
		
		List<Integer> list= Arrays.stream(arr2)
		.mapToObj(num -> (int) num)
		.distinct()
		.filter(map::containsKey)
		.collect(Collectors.toList());
		
		System.out.println(list);
	}

}
