package hou.leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年2月26日 下午2:41:52
 * @end 2016年2月26日15:16:12
 * https://leetcode.com/problems/subsets-ii/
 */

public class SubsetsII2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 4, 1, 0 };
		SubsetsII2 ss = new SubsetsII2();
		List<List<Integer>> ret = ss.subsetsWithDup(nums);
		System.out.println(ret);
	}

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		
		Arrays.sort(nums);
		
		List<List<Integer>> ret = new LinkedList<>();
		if (nums == null)
			return null;
		else if (nums.length == 1) {
			List<Integer> nullList = new LinkedList<>();
			List<Integer> tmp = new LinkedList<>();
			tmp.add(nums[0]);
			ret.add(nullList);
			ret.add(tmp);

			return ret;
		} else {
			List<Integer> nullList = new LinkedList<>();
			ret.add(nullList);
			ret.addAll(help(nums, 0));
			return ret;
		}
	}

	public List<List<Integer>> help(int[] nums, int pos) {
		List<List<Integer>> ret = new LinkedList<>();
		for (int i = pos; i < nums.length; i++) {
			if (i == pos) {
				List<List<Integer>> next = help(nums, pos + 1);
//				ret.addAll(next);

				List<Integer> cur = new LinkedList<>();
				cur.add(nums[pos]);
				ret.add(cur);

				for (int j = 0; j < next.size(); j++) {
					List<Integer> tmp = new LinkedList<>();
					tmp.add(nums[pos]);
					tmp.addAll(next.get(j));
					ret.add(tmp);
				}

			} else {
				if (nums[i] != nums[i - 1]) {
					List<Integer> cur = new LinkedList<>();
					cur.add(nums[i]);
					ret.add(cur);

					if (i + 1 < nums.length) {
						List<List<Integer>> next = help(nums, i + 1);
//						ret.addAll(next);

						for (int j = 0; j < next.size(); j++) {
							List<Integer> tmp = new LinkedList<>();
							tmp.add(nums[i]);
							tmp.addAll(next.get(j));
							ret.add(tmp);
						}
					}
				}
			}

		}
		return ret;
	}

}
