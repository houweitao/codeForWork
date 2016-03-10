package hou.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @author houweitao
 * @date 2015年10月30日 下午2:53:56
 * https://leetcode.com/problems/single-number/
 * https://leetcode.com/discuss/15215/my-very-simple-solution-linear-time-no-extra-memory
 */

/*
	Given an array of integers, every element appears twice except for one. Find that single one.
	Note:
	Your algorithm should have a linear runtime complexity. 
	Could you implement it without using extra memory?
*/

public class SingleNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleNumber sn = new SingleNumber();
		int[] nums = { 2, 3, 11, 5, 8, 8, 5 };
		sn.singleNumber(nums);
		sn.singleNumber2(nums);
	}

	int singleNumber2(int A[]) {
		int n = A.length;
		for (int i = 1; i < n; ++i) {
			A[0] ^= A[i];
			System.out.println(A[0]);
		}
		return A[0];
	}

	int singleNumber(int[] nums) {
		int num = 0;
		HashMap<Integer, Integer> arrayList = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums.length; i++) {
			if (!arrayList.containsKey(nums[i]))
				arrayList.put(nums[i], 1);
			else
				arrayList.remove(nums[i]);
		}
//		num = arrayList.get(key);

		for (int tmp : arrayList.keySet())
			num = tmp;

		System.out.println(num);
		return num;
	}
}
