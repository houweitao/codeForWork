package hou.leetcode.hard;

/**
 * @author houweitao
 * @date 2016年2月10日上午12:44:37
 * @end 2016年02月10日01:10:36
 * @source https://leetcode.com/problems/median-of-two-sorted-arrays/
 */

public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = { 1 };
		int[] nums2 = { 1 };

		MedianOfTwoSortedArrays median = new MedianOfTwoSortedArrays();
		System.out.println(median.findMedianSortedArrays(nums1, nums2));
	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if (nums1.length == 0)
			return singleSum(nums2);
		else if (nums2.length == 0)
			return singleSum(nums1);
		else {
			int len = nums1.length + nums2.length;

			int i = 0, j = 0, count = 0;

			if (len % 2 == 0) {
				double first = 0, second = 0;
				// boolean fir = false, sec = false;
				while (i < nums1.length || j < nums2.length) {
					int cur = -1;

					if (i < nums1.length && j < nums2.length) {
						if (nums1[i] < nums2[j])
							cur = nums1[i++];
						else
							cur = nums2[j++];
					} else if (i >= nums1.length) {
						cur = nums2[j++];
					} else {
						cur = nums1[i++];
					}

					if (count == len / 2 - 1)
						first = (double) cur;

					if (count == len / 2) {
						second = (double) cur;
						return (first + second) / 2;
					}

					count++;
				}
			} else {
				double ret = 0;
				while (i < nums1.length || j < nums2.length) {
					int cur = -1;

					if (i < nums1.length && j < nums2.length) {
						if (nums1[i] < nums2[j])
							cur = nums1[i++];
						else
							cur = nums2[j++];
					} else if (i >= nums1.length) {
						cur = nums2[j++];
					} else {
						cur = nums1[i++];
					}

					if (count == (len - 1) / 2) {
						ret = (double) cur;
						return ret;
					}
					count++;

				}
			}
		}
		return 0;
	}

	private double singleSum(int[] nums) {
		if (nums.length % 2 == 0)
			return ((double) nums[nums.length / 2] + (double) nums[nums.length / 2 - 1]) / 2;
		else
			return (double) nums[(nums.length - 1) / 2];
	}
}
