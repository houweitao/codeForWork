package hou.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houweitao
 * @date 2015年11月16日 下午4:06:29
 * @end 2015年11月16日16:56:50
 * https://leetcode.com/problems/combinations/
 */

public class Combinations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Combinations c = new Combinations();
		List<List<Integer>> list = c.combine(20, 3);

		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.get(i).size(); j++)
				System.out.print(list.get(i).get(j) + ",");
			System.out.println();
		}
		System.out.println(list.size());
	}

	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<Integer>();

		if (k > n || n == 0 || k == 0)
			return null;
		else if (k == n) {
			for (int i = 1; i <= n; i++)
				tmp.add(i);
			list.add(tmp);
			return list;
		} else {

			if (k == 1) {
				for (int index = 1; index <= n; index++) {
					List<Integer> tmp2 = new ArrayList<Integer>();
					tmp2.add(index);
					list.add(tmp2);
				}
				return list;
			}

			list.addAll(combine(n - 1, k));
			List<List<Integer>> l = combine(n - 1, k - 1);
			if (l != null) {
				for (int m = 0; m < l.size(); m++) {
					l.get(m).add(n);
				}
				list.addAll(l);
			}
			return list;
		}

//		for (int i = 0; i < n; i++) {
//			int j = 0;
//			while (j < k) {
//				list.addAll(combine(n - 1, k));
//				List<List<Integer>> l = combine(n - 1, k - 1);
//				for (int m = 0; m < l.size(); m++) {
//					l.get(m).add(n);
//				}
//				list.addAll(l);
//			}
//		}
//
//		return list;
	}
}
