package hou.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houweitao
 * @date 2015年11月30日 下午3:34:01
 * https://leetcode.com/problems/combination-sum/
 * @tobecontinued 理解错了 2015年11月30日15:42:04
 */

public class CombinationSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();

		if (candidates.length == 0)
			return null;

		int i = 0, j = 0;
		while (i <= j && j < candidates.length) {
			if (i == j) {
				if (candidates[i] == target) {
					ArrayList<Integer> al = new ArrayList<>();
					al.add(candidates[i]);
					ret.add(al);
				} else {
					j++;
				}
			} else {
				int sum = 0;
				for (int k = i; k <= j; k++) {
					sum = sum + candidates[k];
				}
				if (sum == target) {
					ArrayList<Integer> al = new ArrayList<>();
					for (int k = i; k <= j; k++)
						al.add(candidates[k]);
					ret.add(al);
				} else if (sum > target)
					i++;
				else
					j++;
			}
		}

		return ret;
	}
}
