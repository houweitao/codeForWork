package hou.leetcode.medium;

/**
 * @author houweitao
 * @date 2015年12月15日 下午3:35:34
 * @end 2015年12月15日16:14:31
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */

public class KthLargestElementInAnArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 3, 2, 1, 5, 6, 4 };
		KthLargestElementInAnArray kthMax = new KthLargestElementInAnArray();

		for (int i = 6; i > 0; i--) {
			int out = kthMax.findKthLargest(nums, i);
			out = kthMax.findKthLargestQuick(nums, 0, nums.length - 1, i);
			System.out.println(out);
		}

		int[] test = { 99, 99 };
		System.out.println("test: " + kthMax.findKthLargestQuick(test, 0, test.length - 1, 1));
	}

	public int findKthLargestQuick(int[] nums, int begin, int end, int k) {
		int standred = nums[begin];

		if (begin + 1 == end)
			return k > 1 ? Math.min(nums[begin], nums[end]) : Math.max(nums[begin], nums[end]);

		int i = begin;
		int j = end;

		while (i < j) {
			while (i < j && nums[j] >= standred) //加个等号用于很多元素相同的情况。减少运算
				j--;
			nums[i] = nums[j];

			while (i < j && nums[i] < standred)
				i++;
			nums[j] = nums[i];
		}
		nums[i] = standred;

		if (end - i + 1 == k)
			return standred;
		else if (end - i + 1 < k) {
			return findKthLargestQuick(nums, begin, i - 1, k - end + i - 1);
		} else {
			return findKthLargestQuick(nums, i + 1, end, k);
		}
	}

	public int findKthLargest(int[] nums, int k) {
		int ret = k;
		while (k > 0) {
			for (int i = 0; i < nums.length; i++) {
				int max = nums[i];
				for (int j = i + 1; j < nums.length; j++) {
					if (nums[j] > max) {
						max = nums[j];
						nums[j] = nums[i];
						nums[i] = max;
					}
				}
			}

			k--;
		}

		return nums[ret - 1];
	}
}
