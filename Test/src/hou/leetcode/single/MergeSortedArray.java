package hou.leetcode.single;

/**
 * @author houweitao
 * @date 2015年11月10日 下午2:43:12
 * https://leetcode.com/problems/merge-sorted-array/
 */

public class MergeSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeSortedArray ma = new MergeSortedArray();
		int[] a = { 1, 3, 5, 6, 7, 8 };
		int[] b = { 2, 3, 10, 15 };
		ma.arrayPrint(ma.merge(a, b));
	}

	public int[] merge(int[] nums1, int[] nums2) {
		int i = 0, j = 0;
		int k = 0;
		int[] nums = new int[nums1.length + nums2.length];
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] > nums2[j]) {
				nums[k] = nums2[j];
				j++;
				k++;
			} else if (nums1[i] < nums2[j]) {
				nums[k] = nums1[i];
				i++;
				k++;
			} else {
				nums[k++] = nums1[i];
				nums[k++] = nums1[i];
				i++;
				j++;
			}
		}
//		if(i==nums1.length &&j==nums2.length)

		if (i == nums1.length) {
			for (; j < nums2.length; j++)
				nums[k++] = nums2[j];
		} else
			for (; i < nums1.length; j++)
				nums[k++] = nums1[i];

		return nums;
	}

	void arrayPrint(int[] a) {
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + ",");
		System.out.println();
	}
}
