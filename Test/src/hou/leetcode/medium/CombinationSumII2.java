package hou.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年1月4日 下午3:41:41
 * @end 2016年1月4日16:16:12
 * 没找到个更好的方法。哎。
 * 以后再做吧。。2016年1月4日17:18:10
 */

public class CombinationSumII2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CombinationSumII2 cs = new CombinationSumII2();
		int[] candidates = { 3, 1, 3, 5, 1, 1 };
		List<List<Integer>> ret = cs.combinationSum2(candidates, 8);
		System.out.println();
		cs.printList(ret);
	}

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		if (candidates.length == 0)
			return null;
		else {
			Arrays.sort(candidates);
			HashMap<Integer, Integer> hm = new HashMap<>();
			for (int i = 0; i < candidates.length; i++) {
				if (hm.containsKey(candidates[i]))
					hm.put(candidates[i], hm.get(candidates[i]) + 1);
				else
					hm.put(candidates[i], 1);
			}

			return help(candidates, target, -1, hm);
		}
	}

	public List<List<Integer>> help(int[] candidates, int target, int last, HashMap<Integer, Integer> hm) {

		List<List<Integer>> ret = new LinkedList<>();
		if (target < 0)
			return ret;
		if (last == candidates.length - 1)
			return ret;
		if (last >= candidates.length - 1)
			return ret;
		if (target < candidates[last + 1]) {
			return ret;
		} else {

			int time = hm.get(candidates[last + 1]);
//			System.out.println(time);
			for (int k = 1; k <= time; k++) {
				if (target == candidates[last + 1]) {
					List<Integer> tmp = new LinkedList<>();
					tmp.add(target);
					ret.add(tmp);
					break;
				} else {
					if (target - k * candidates[last + 1] > 0) {
						List<List<Integer>> next = help(candidates, target - k * candidates[last + 1], last + time, hm);
						if (next.size() > 0) {
							for (int j = 0; j < next.size(); j++) {
								List<Integer> tmp = new LinkedList<>();
								for (int m = 0; m < k; m++)
									tmp.add(candidates[last + 1]);
								tmp.addAll(next.get(j));

								ret.add(tmp);
							}
						}
					} else if (target - k * candidates[last + 1] == 0) {
						List<Integer> tmp = new LinkedList<>();
						for (int m = 0; m < k; m++)
							tmp.add(candidates[last + 1]);
						ret.add(tmp);
					}
				}
			}

			for (int i = last + time + 1; i < candidates.length; i++) {
				if (target == candidates[i]) {
					List<Integer> tmp = new LinkedList<>();
					tmp.add(target);
					ret.add(tmp);
				}
				if (target > candidates[i]) {

					int lastNum = -1;
					if (last != -1)
						lastNum = candidates[last];

					if (judge(candidates, i, lastNum)) {
						List<List<Integer>> next = help(candidates, target - candidates[i], i, hm);

						if (next.size() > 0) {
							for (int j = 0; j < next.size(); j++) {
								List<Integer> tmp = new LinkedList<>();
								tmp.add(candidates[i]);
								tmp.addAll(next.get(j));

								ret.add(tmp);
							}
						}
					}

				} else
					break;
			}

			return ret;
		}
	}

	private boolean judge(int[] candidates, int i, int tar) {
		// TODO Auto-generated method stub
		if (i == 0)
			return true;
		else if (candidates[i] != candidates[i - 1])
			return true;
//		else if (candidates[i] == tar)
//			return true;
		else
			return false;
	}

	private void printList(List<List<Integer>> list) {
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.get(i).size(); j++) {
				System.out.print(list.get(i).get(j) + ",");
			}
			System.out.println();
		}
	}
}
