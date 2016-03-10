package hou.mianjing.me;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年3月4日 上午10:06:58
 */

public class AllPossibleResults {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 2, 3, 4, 5 };
		AllPossibleResults possible = new AllPossibleResults();
		System.out.println(possible.getResult(nums));
	}

	List<Integer> getResult(int[] nums) {
		List<Integer> ret = new LinkedList<>();
		if (nums == null)
			return ret;
		else if (nums.length == 1) {
			ret.add(nums[0]);
			return ret;
		} else if (nums.length == 2) {
			ret.add(nums[0]);
			ret.add(nums[1]);
			ret.add(nums[0] * nums[1]);
			return ret;
		} else {
			int[] newNums = getNewNum(nums, 0);
			List<Integer> next = getResult(newNums);
			for (int num : next) {
				int toAdd = num * nums[0];
				if (!ret.contains(toAdd))
					ret.add(toAdd);
			}
			ret.addAll(next);

			int all = 1;
			for (int n : nums)
				all = all * n;
			if (!ret.contains(all))
				ret.add(all);
			if (!ret.contains(nums[0]))
				ret.add(nums[0]);

			Collections.sort(ret);

			return ret;
		}
	}

	private int[] getNewNum(int[] nums, int pos) {
		int[] n = new int[nums.length - 1];
		for (int i = 0, j = 0; i < nums.length; i++) {
			if (i > pos) {
				n[j++] = nums[i];
			}
		}
		return n;
	}
}
