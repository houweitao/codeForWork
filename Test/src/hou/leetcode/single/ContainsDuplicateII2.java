package hou.leetcode.single;

import java.util.HashMap;

/**
 * @author houweitao
 * @date 2015年12月1日 下午5:19:40
 * @end 2015年12月1日17:33:36
 * 边界..审题很重要！k=1的意思是坐标差1！
 * https://leetcode.com/problems/contains-duplicate-ii/
 */

public class ContainsDuplicateII2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContainsDuplicateII2 cd = new ContainsDuplicateII2();
		int[] nums = { 1, 2, 1 };
		System.out.println(cd.containsNearbyDuplicate(nums, 1));
	}

	public boolean containsNearbyDuplicate(int[] nums, int k) {
		if (nums.length < 2 || k <= 0)
			return false;
		else {
			if (k < nums.length) {
				HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
				for (int i = 0; i <= k; i++) {
					if (hs.containsKey(nums[i]))
						return true;
					else
						hs.put(nums[i], 1);
				}

				for (int i = k + 1; i < nums.length; i++) {
					hs.remove(nums[i - k - 1]);
					if (hs.containsKey(nums[i]))
						return true;
					else
						hs.put(nums[i], 1);
				}
			} else {
				HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
				for (int i = 0; i < nums.length; i++) {
					if (hs.containsKey(nums[i]))
						return true;
					else
						hs.put(nums[i], 1);
				}
			}
			return false;
		}
	}
}
