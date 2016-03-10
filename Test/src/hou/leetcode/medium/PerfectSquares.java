package hou.leetcode.medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author houweitao
 * @date 2015年11月4日 上午11:26:04
 * https://leetcode.com/problems/perfect-squares/
 */

public class PerfectSquares {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int test = (int) Math.sqrt(2);
//		System.out.println(test);

		PerfectSquares ps = new PerfectSquares();
//		int result = ps.numSquares(12);
//		System.out.println(result);

		List<String> l = ps.numSquares(1, 1000);
		for (String s : l) {
			System.out.println(s);
		}
		System.out.println(l.size());

//		for(int test=1;test<200;test++){
//			l = ps.numSquares(test, 1000);
//			System.out.println(test+" , "+l.size());
//		}

		List<Integer> lString = ps.numSquares2(12, 300);
		for (Integer s : lString) {
			System.out.println(s);
		}
		System.out.println(lString.size());
	}

	List<String> numSquares(int n, int max) {
		List<String> numList = new ArrayList<String>();
		if (n == 0)
			return numList;
		else {
			int top = (int) Math.sqrt(n);
			if (top > max)
				top = max;
//			System.out.println(top);
			int next = 0;
			for (int i = top; i >= 1; i--) {
				next = n - i * i;
//				System.out.println(n + " - " + i + "^2 = "+next);
				if (next == 0) {
					numList.add(i + "^2");
//					break;
				} else {
					List<String> list = numSquares(next, i);

					if (list.size() != 0)
						for (Iterator<String> it = list.iterator(); it.hasNext();) {
							String tmp = it.next();
							numList.add(i + "^2 + " + tmp);
						}
				}
			}

		}
//		System.out.println(num);
		return numList;
	}

	//wrong
	List<Integer> numSquares2(int n, int max) {
		List<Integer> numList = new ArrayList<Integer>();
		if (n == 0)
			return numList;
		else {
			int top = (int) Math.sqrt(n);
			if (top > max)
				top = max;
//			System.out.println(top);
			int next = 0;
			for (int i = top; i >= 1; i--) {
				next = n - i * i;
//				System.out.println(n + " - " + i + "^2 = "+next);
				if (next == 0) {
					numList.add(i);
//					break;
				} else {
					List<Integer> list = numSquares2(next, i);
					numList.add(i);
//					if (list.size() != 0)
//						for (Iterator<Integer> it = list.iterator(); it.hasNext();) {
//							Integer tmp = it.next();
//							numList.addAll(list);
//						}
					if (list.size() != 0) {
						numList.addAll(list);
					}
				}
			}

		}
//		System.out.println(num);
		return numList;
	}
}
