package hou.leetcode.medium;

import java.util.Arrays;

/**
 * @author houweitao
 * @date 2015年12月16日 下午2:43:44
 * @end 2015年12月16日15:03:02
 * https://leetcode.com/problems/3sum-closest/
 */

public class Three3SumClosest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 0, 2, 1, -3 };
		Three3SumClosest result = new Three3SumClosest();
		result.threeSumClosest(nums, 1);
	}

	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int close = Integer.MAX_VALUE;
		int ret = 0;

		for (int i = 0; i <= nums.length - 3; i++) {

			int m = i + 1, n = nums.length - 1;

			while (m < n) {
				int sum = nums[i] + nums[m] + nums[n];
				if (sum == target)
					return target;
				else if (sum < target) {
					if (close > Math.abs(sum - target)) {
						close = Math.abs(sum - target);
						ret = sum;
					}
					m++;
				}else{
					if (close > Math.abs(sum - target)) {
						close = Math.abs(sum - target);
						ret = sum;
					}
					n--;
				}
			}

		}
		System.out.println(ret);
		return ret;
	}
}
