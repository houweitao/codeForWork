package hou.leetcode.hard;

/**
 * @author houweitao
 * @date 2015年12月1日 下午4:52:00
 * @end 2015年12月1日17:09:04
 * 边界问题的小把戏..
 * https://leetcode.com/problems/sliding-window-maximum/
 */

public class SlidingWindowMaximum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SlidingWindowMaximum swm = new SlidingWindowMaximum();
		int[] nums = {};
		int[] ret = swm.maxSlidingWindow(nums, 0);
		for (int i = 0; i < ret.length; i++)
			System.out.print(ret[i] + ",");
	}

	public int[] maxSlidingWindow(int[] nums, int k) {
		if (k >= nums.length) {
			int[] ret;
			if (nums.length != 0) {
				ret = new int[1];
				ret[0] = getMax(nums, 0, nums.length - 1);
			} else {
				ret = new int[0];
			}
			return ret;
		} else {
			int[] ret = new int[nums.length - k + 1];
			for (int i = 0; i <= nums.length - k; i++) {
				ret[i] = getMax(nums, i, i + k - 1);
			}

			return ret;
		}
	}

	int getMax(int[] nums, int begin, int end) {
		if (nums.length == 0)
			return 0;
		int max = Integer.MIN_VALUE;
		for (int i = begin; i <= end; i++)
			if (nums[i] > max)
				max = nums[i];
		return max;
	}
}
