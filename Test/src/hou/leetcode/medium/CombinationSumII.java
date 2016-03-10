package hou.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author houweitao
 * @date 2015年12月4日 下午4:58:36
 * @end 2015年12月4日17:47:49
 * 一直在写边边角角。。太难看了写的！！回去看！！
 * https://leetcode.com/problems/combination-sum-ii/
 */
public class CombinationSumII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CombinationSumII cs = new CombinationSumII();
		int[] candidates = { 1 };
		List<List<Integer>> ret = cs.combinationSum2(candidates, 1);
		cs.print(ret);
	}

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		if (candidates.length == 1 && candidates[0] == target) {
			List<List<Integer>> ret2 = new ArrayList<List<Integer>>();
			ArrayList<Integer> record = new ArrayList<>();
			record.add(candidates[0]);
			ret2.add(record);
			return ret2;
		}

		return removeRepeat(help(candidates, target, -1));
		//算了再加个去重吧。。给跪。。
	}

	private List<List<Integer>> removeRepeat(List<List<Integer>> ret) {
		List<List<Integer>> ret2 = new ArrayList<List<Integer>>();
		ArrayList<Integer> record = new ArrayList<>();
		for (int i = 0; i < ret.size() - 1; i++) {
			for (int j = i + 1; j < ret.size(); j++) {
				if (!record.contains(j))
					if (judge(ret.get(i), ret.get(j))) {
						record.add(j);
					}
			}
		}

		for (int i = 0; i < record.size(); i++) {
			if (!record.contains(i)) {
				ret2.add(ret.get(i));
			}
		}

		return ret2;
	}

	private boolean judge(List<Integer> list1, List<Integer> list2) {
		// TODO Auto-generated method stub
		if (list1.size() != list2.size())
			return false;
		else {
			for (int i = 0; i < list1.size(); i++) {
				if (list1.get(i) != list2.get(i))
					return false;
			}
			return true;
		}
	}

	public List<List<Integer>> help(int[] candidates, int target, int last) {
		boolean alreadyHave = false;
		Arrays.sort(candidates);
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		for (int i = 0; i < candidates.length; i++) {
			List<Integer> list = new ArrayList<>();
			if (i < candidates.length - 2)
				if (candidates[i] == candidates[i + 1])
					i++;
			if (candidates[i] >= last)
				if (candidates[i] == target && !alreadyHave) {
					list.add(candidates[i]);
					ret.add(list);
					alreadyHave = true;
				} else if (target > candidates[i]) {

					int[] helpSum = new int[candidates.length - 1];
					int k = 0;
					for (int j = 0; j < candidates.length; j++) {
						if (j != i) {
							helpSum[k] = candidates[j];
							k++;
						}
					}

					List<List<Integer>> next = help(helpSum, target - candidates[i], candidates[i]);
					if (next.size() != 0) {

						for (int m = 0; m < next.size(); m++) {
							List<Integer> list2 = new ArrayList<>();
							list2.add(candidates[i]);
							list2.addAll(next.get(m));
							ret.add(list2);
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
