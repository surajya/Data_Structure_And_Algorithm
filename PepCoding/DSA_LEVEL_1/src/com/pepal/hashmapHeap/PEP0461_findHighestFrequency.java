package com.pepal.hashmapHeap;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class PEP0461_findHighestFrequency {

	public static void main(String[] args) {
		HashMap<Character, Integer> hm = new HashMap<>();
		String str = "abakadabararrrrrrrr";
		int maxFreq = Integer.MIN_VALUE;
		char freqChar = 'a';
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if(hm.containsKey(c)) {
				int freq = hm.get(c);
				hm.put(c, freq+1);
				if(maxFreq < freq+1) {
					maxFreq = freq+1;
					freqChar = c;
				}
			}else {
				hm.put(c, 1);
				if(maxFreq<1) {
					freqChar = c;
				}
			}
		}
		System.out.println("mostfreqent character is :"+ freqChar);
		
		//using stream API and lambda expression
		Map<Character, Long> mapp= str.chars()
		        .mapToObj(c -> (char) c)
		        .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		
		char cc = mapp.entrySet()
		.stream()
		.max(Map.Entry.comparingByValue())
		.map(Map.Entry::getKey)
		.orElseThrow(null);
		
		Map<Character, Long> ans1 = str.chars()
		.mapToObj(c -> (char)c)
		.collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		
		System.out.println(ans1);
		
		char ans2 = ans1.entrySet()
		.stream()
		.max(Map.Entry.comparingByValue())
		.map(Map.Entry::getKey)
		.orElseThrow(null);
		
		System.out.println("find the most frequent character -> "+ ans2);
	}

}
