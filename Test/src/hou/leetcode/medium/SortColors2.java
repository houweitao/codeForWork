package hou.leetcode.medium;

/**
 * @author houweitao
 * @date 2015年11月30日 下午11:45:23
 * @end 2015年11月30日23:52:04
 * https://leetcode.com/problems/sort-colors/
 */

public class SortColors2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortColors2 sc = new SortColors2();
		int[] nums = { 0, 0, 1, 1, 2, 1, 2, 1, 0, 0 };
		sc.print(nums);
		sc.sortColors(nums);
		sc.print(nums);
	}

	private void print(int[] nums) {
		// TODO Auto-generated method stub
		for (Integer i : nums)
			System.out.print(i + ",");
		System.out.println();
	}

	public void sortColors(int[] nums) {
		if (nums.length == 0)
			return;
		int i = -1, j = nums.length;

		for (int p = 0; p < nums.length; p++) {
			if (nums[p] == 0) {
				i++;
			} else if (nums[p] == 2) {
				j--;
			}
		}

		for (int p = 0; p < nums.length; p++) {
			if (p <= i)
				nums[p] = 0;
			else if (p >= j)
				nums[p] = 2;
			else
				nums[p] = 1;
		}
	}
}
