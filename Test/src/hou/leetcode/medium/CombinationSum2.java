package hou.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houweitao
 * @date 2015年12月4日 下午4:35:23
 * @end 2015年12月4日16:48:51
 * https://leetcode.com/problems/combination-sum/
 */

// 要点 是：每次都从最小的开始减。直到减不动了，看有没有合适的解。如果没有，则减去大一点的。？？是不是从大往小减好一点？？


public class CombinationSum2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CombinationSum2 cs = new CombinationSum2();
		int[] candidates = { 2, 3, 6, 7 };
		List<List<Integer>> ret = cs.combinationSum(candidates, 7);
		cs.print(ret);
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		return help(candidates, target, -1);
	}

	public List<List<Integer>> help(int[] candidates, int target, int last) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		for (int candi : candidates) {
			if (candi >= last) {
				if (target == candi) {
					List<Integer> list = new ArrayList<>();
					list.add(candi);
					ret.add(list);
				} else if (target > candi) {
					List<List<Integer>> next = help(candidates, target - candi, candi);
					if (next.size() != 0) {

						for (int i = 0; i < next.size(); i++) {
							List<Integer> list = new ArrayList<>();
							list.add(candi);
							list.addAll(next.get(i));
							ret.add(list);
						}
					}

				}
			}
		}
		return ret;
	}

	private void print(List<List<Integer>> ret) {
		// TODO Auto-generated method stub
		for (int i = 0; i < ret.size(); i++) {
			for (int j = 0; j < ret.get(i).size(); j++) {
				System.out.print(ret.get(i).get(j) + ",");
			}
			System.out.println();
		}
	}
}
