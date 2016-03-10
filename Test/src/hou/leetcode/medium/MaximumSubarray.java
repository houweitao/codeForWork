package hou.leetcode.medium;

/**
 * @author houweitao
 * @date 2015年11月13日 上午10:24:56
 * https://leetcode.com/problems/maximum-subarray/
 */

public class MaximumSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { -11, -7, 2, -2, -3 };
		MaximumSubarray ms = new MaximumSubarray();
		System.out.println(ms.maxSubArray(nums));
	}

	public int maxSubArray(int[] nums) {
		if (nums.length == 1)
			return nums[0];

		int maxSofar = -10000000;
		int maxEndHere = 0;
		int mark = nums[0];

		for (int i = 0; i < nums.length; i++) {
			maxEndHere = Math.max(0, maxEndHere + nums[i]);
			if (nums[i] > mark)
				mark = nums[i];
			maxSofar = Math.max(maxEndHere, maxSofar);
		}
		if (maxSofar == 0)
			return mark;
		return maxSofar;
	}

	// https://leetcode.com/discuss/15805/accepted-o-n-solution-in-java
	int maxSubArray2(int[] A) {
		int maxSoFar = A[0], maxEndingHere = A[0];
		for (int i = 1; i < A.length; ++i) {
			maxEndingHere = Math.max(maxEndingHere + A[i], A[i]);
			maxSoFar = Math.max(maxSoFar, maxEndingHere);
		}
		return maxSoFar;
	}
}
