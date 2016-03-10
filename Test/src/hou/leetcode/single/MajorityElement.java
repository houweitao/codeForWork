package hou.leetcode.single;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * @author houweitao 2015年8月2日 下午5:09:37
 */

public class MajorityElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int majorityElement(int[] nums) {
		HashMap<Integer, Integer> majority = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums.length; i++) {
			if (!majority.containsKey(nums[i]))
				majority.put(nums[i], 1);
			// else
			// majority.r

			
			int major = nums[0], count = 1;
			for (int j = 1; j < nums.length; j++) {
				if (count == 0) {
					count++;
					major = nums[j];
				} else if (major == nums[j]) {
					count++;
				} else
					count--;

			}
			return major;
		}

		return 0;
	}
}
