package com.pepal.hashmapHeap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Pair implements Comparable<Pair> {

	int lli;
	int li;
	int val;

	public Pair(int lli, int li, int val) {
		this.lli = lli;
		this.li = li;
		this.val = val;
	}

	@Override
	public int compareTo(Pair o) {
		return this.val - o.val;
	}

}

public class PEP0475_MergeKSortedList {

	public static void main(String[] args) {

		ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(5, 7, 9, 15, 37));
		ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(3, 6, 10, 12, 18, 45));
		ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(4, 8, 11, 14, 20, 25));
		PriorityQueue<Integer> pq1 = new PriorityQueue<>();
		PriorityQueue<Pair> pq = new PriorityQueue<>();

		ArrayList<Integer> ans = new ArrayList<>();
		ArrayList<ArrayList<Integer>> listoflist = new ArrayList<>();
		listoflist.add(list1);
		listoflist.add(list2);
		listoflist.add(list3);

		// this is deprecated method
		// mergeSortedList(pq1, ans, listoflist);

		advMergeSortedList(pq, ans, listoflist);
	}

	private static void advMergeSortedList(PriorityQueue<Pair> pq, ArrayList<Integer> ans,
			ArrayList<ArrayList<Integer>> listoflist) {
		int x = 0;
		for (List<Integer> list : listoflist) {
			int lli = x++;
			int li = 0;
			int val = list.get(0);
			pq.add(new Pair(lli, li, val));
		}

		while (!pq.isEmpty()) {
			Pair pair = pq.remove();
			ans.add(pair.val);
			int lli = pair.lli;
			int li = pair.li;

			if (listoflist.get(lli).size() > li + 1) {
				pq.add(new Pair(lli, li + 1, listoflist.get(lli).get(li + 1)));
			}
		}

		System.out.println(ans);
	}

	private static void mergeSortedList(PriorityQueue<Integer> pq, ArrayList<Integer> ans,
			ArrayList<ArrayList<Integer>> listoflist) {
		int bigSize = 6;
		for (int i = 0; i < bigSize; i++) {
			for (List<Integer> list : listoflist) {
				if (i < list.size())
					pq.add(list.get(i));
			}
			ans.add(pq.remove());
		}

		while (!pq.isEmpty())
			ans.add(pq.remove());

		System.out.println(ans);
	}

}
