package com.pepac.array;

import java.util.ArrayDeque;
import java.util.Deque;

public class PEP113_LargestAreaHistogram2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] heights= {6,2,5,4,5,1,6};
		int n = heights.length;
        int maxArea = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i=0; i<=n; i++) {
            int currH = (i==n) ? 0 : heights[i];
            while ( !stack.isEmpty() && currH < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i-stack.peek()-1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
	}
}
