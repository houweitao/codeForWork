package hou.leetcode.medium;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @author houweitao
 * @date 2015年12月14日 下午2:21:48
 * https://leetcode.com/problems/super-ugly-number/
 */

public class SuperUglyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SuperUglyNumber ugly = new SuperUglyNumber();
		int[] primes = { 2, 7, 13, 19 };
		ugly.nthSuperUglyNumber(44, primes);
	}

	public int nthSuperUglyNumber(int n, int[] primes) {
		LinkedList<Integer> list = new LinkedList<>();
		LinkedList<Integer> list2 = new LinkedList<>();
		LinkedList<Integer> tmp = new LinkedList<>();
		list.add(1);
		list2.add(1);
		for (int i = 0; i < primes.length; i++) {
			list.add(primes[i]);
			list2.add(primes[i]);
		}

		for (int i = 1; i < list.size(); i++) {
			for (int j = i; j < list.size(); j++) {
				list.add(list.get(i) * list.get(j));
				System.out.println(list.get(i) * list.get(j));
				Collections.sort(list);

				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return n;

	}
}
