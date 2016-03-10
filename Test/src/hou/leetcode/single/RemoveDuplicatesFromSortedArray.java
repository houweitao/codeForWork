package hou.leetcode.single;

import java.util.HashMap;

/**
 * @author houweitao
 * @date 2015年12月15日 上午11:22:38
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */

public class RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 1, 2 };
		RemoveDuplicatesFromSortedArray rd = new RemoveDuplicatesFromSortedArray();
		int count=rd.removeDuplicates(nums);
		System.out.println(count);
		rd.print(nums);
	}

	private void print(int[] nums) {
		// TODO Auto-generated method stub
		for(Integer i:nums)
			System.out.print(i+",");
	}

	public int removeDuplicates(int[] nums) {
		int j = 0;
		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (!hm.containsKey(nums[i])) {
				hm.put(nums[i], 1);
				nums[j] = nums[i];
				j++;
			}
		}

		return j;
	}
}
