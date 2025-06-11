package com.array.nintyToOneThirty;

import java.util.Stack;

public class PEP106_BalanceBracket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="[(a+b)+{c+(d+e)}]";
		System.out.println("given string have balance bracket: "+isValid(str));
	}
	
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
