package com.leetcode75;

import java.util.Stack;

public class Dota2Senate {

	public String predictPartyVictory(String senate) {
		Stack<Character> bucketMain = new Stack<>();
		Stack<Character> bucketHelp = new Stack<>();
		int rt = 0, dt = 0;
		for (int i = senate.length() - 1; i >= 0; i--) {
			char c = senate.charAt(i);
			if (c == 'R') {
				rt++;
			} else {
				dt++;
			}
			bucketMain.push(senate.charAt(i));
		}
		int rp = 0, dp = 0;
		while (true) {
			if (rt == 0 || dt == 0) {
				break;
			}
			char c = bucketMain.pop();
			if (c == 'R') {
			if (!bucketMain.isEmpty()) {
				if (c != bucketMain.peek()) {
					if (rp == 0) {
						bucketMain.pop();
					}
					dt--;
				} else if (rp == 0) {
					dp++;
				}
			} else if (rp == 0) {
				dp++;
			}
			if (rp == 0) {
				bucketHelp.push(c);
			} else {
				rp --;
				rt--;
			}

		} else {
			if (!bucketMain.isEmpty()) {
				if (c != bucketMain.peek()) {
					if (dp == 0) {
						bucketMain.pop();
						rt--;
					}
				} else if (dp == 0) {
					rp++;
				}
			} else if (dp == 0) {
				rp++;
			}
			if (dp == 0) {
				bucketHelp.push(c);
			} else {
				dp --;
				dt--;
			}
		}
		if (bucketMain.isEmpty()) {
			while (!bucketHelp.isEmpty()) {
				char ch = bucketHelp.pop();
				if (ch == 'R') {
					if (rp != 0) {
						rp--;
						rt--;
					} else {
						bucketMain.push(ch);
					}
				} else {
					if (dp != 0) {
						dp--;
						dt--;
					} else {
						bucketMain.push(ch);
					}
				}
			}
		}
	}
	if (rt == 0) {
		return "Dire";
	}
	return "Radiant";
}

public static void main(String[] args) {
	Dota2Senate d = new Dota2Senate();
	System.out.println(d.predictPartyVictory("RRDRDDRDRRDDDDDRDRDR"));
	System.out.println(d.predictPartyVictory("DDRRR"));
	System.out.println(d.predictPartyVictory("RDDDRR"));
	System.out.println(d.predictPartyVictory(
			"DDDDDDRDRRDRRDRDRRRDDRRDDDRDRDDDRRRRDDDDRDRRRRDRRRDRDRDDRDRRRRDRDRRRDRDDDRRDDDRDRDRDRRDRDDRDDRDDDDRDRRR"));
	System.out.println(d.predictPartyVictory("DDRRR"));
	}
}
