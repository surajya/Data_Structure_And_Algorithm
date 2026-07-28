package com.pepai.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PEP0415_PrintPermutation {

	public static void main(String[] args) {
		String str = "abcd";
		System.out.println("All Permutation: "+findPermutation(str, ""));
	}

	private static List<String> findPermutation(String str, String ans) {
		if(str.isEmpty()) return Collections.singletonList(ans);

		List<String> ansList = new ArrayList<>();
		for(int i=0; i<str.length(); i++){
			String substr = str.substring(0,i) + str.substring(i+1);
			ansList.addAll(findPermutation(substr, ans+str.charAt(i)));
		}
		return ansList;
	}


}
