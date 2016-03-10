package hou.leetcode.single;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houweitao 2015年9月2日 上午10:49:36
 *         http://blog.csdn.net/sbitswc/article/details/48173241
 */

public class MajorityElement2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 7, 2 };
		MajorityElement2 me = new MajorityElement2();
		List<Integer> result = me.majorityElement(nums);

		for (Integer a : result)
			System.out.println(a);

	}

	public List<Integer> majorityElement(int[] nums) {
		List<Integer> result = new ArrayList<>();
		if (nums.length == 0)
			return result;
		int n1 = nums[0];
		int n2 = 0;
		int count1 = 1;
		int count2 = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == n1) {
				count1++;
			} else if (nums[i] == n2) {
				count2++;
			} else {
				if (count1 == 0) {
					n1 = nums[i];
					count1++;
				} else if (count2 == 0) {
					n2 = nums[i];
					count2++;
				} else {
					count1--;
					count2--;
				}
			}
		}
		count1 = 0;
		count2 = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == n1)
				count1++;
			if (nums[i] == n2)
				count2++;
		}
		if (count1 > nums.length / 3)
			result.add(n1);
		if (n1 == n2)
			return result;
		if (count2 > nums.length / 3)
			result.add(n2);
		return result;
	}
}
