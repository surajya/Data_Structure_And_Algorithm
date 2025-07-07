package com.array.nintyToOneThirty;

import java.util.*;

public class PEP129_SmallestNumberFollowingPattern {

    public static void main(String[] args) {
        String str = "ddiiiddi";

        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        int num = 1;

        for (int i = 0; i <= str.length(); i++) {
            stack.push(num);
            num++;

            // If end of pattern OR current char is 'i', pop the stack
            if (i == str.length() || str.charAt(i) == 'i') {
                while (!stack.isEmpty()) {
                    list.add(stack.pop());
                }
            }
        }

        // Print the resulting smallest number sequence
        for (int val : list) {
            System.out.print(val);
        }
    }
}
