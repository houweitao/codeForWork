package hou.leetcode.medium;

/**
 * @author houweitao
 * @date 2015年11月16日 下午3:17:33
 * @end 2015年11月16日15:21:35
 * https://leetcode.com/problems/find-peak-element
 */

public class FindPeakElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findPeakElement(int[] nums) {
		if (nums.length == 1)
			return 0;

		int min = Integer.MIN_VALUE;
		int pos = -1;
		for (int i = 0; i < nums.length; i++) {
			if (min < nums[i]) {
				min = nums[i];
				pos = i;
			}
		}
		return pos;
	}
}
