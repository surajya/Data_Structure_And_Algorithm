package com.pepai.recursion;

import java.util.Stack;

// 00:08:44

public class PEP0384_TowerOfHanoi {

	public static void main(String[] args) {
		Stack<Integer> source = new Stack<>();
		Stack<Integer> target = new Stack<>();
		Stack<Integer> support = new Stack<>();
		source.add(4);
		source.add(3);
		source.add(2);
		source.add(1);

		hanoiSolutionUsingRecursion(source.size(), source, target, support);
		System.out.println("Source: " + source);
		System.out.println("Target: " + target);
	}

	private static void hanoiSolutionUsingRecursion(int size, Stack<Integer> source, Stack<Integer> target,
			Stack<Integer> support) {
		if (size == 0) {
			return;
		}
		hanoiSolutionUsingRecursion(size - 1, source, support, target);
		System.out.println("Move " + source.peek() + " from " + source + " to " + target);
		target.push(source.pop());
		hanoiSolutionUsingRecursion(size - 1, support, target, source);

	}
}
