package hou.leetcode.medium;

/**
 * @author houweitao
 * @date 2015年11月13日 上午10:48:41
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 */

public class FindMinimumInRotatedSortedArray {
	public static void main() {
		int[] nums = { 3, 4, 5, 1, 2 };
		FindMinimumInRotatedSortedArray fm = new FindMinimumInRotatedSortedArray();
		System.out.println(fm.findMin2(nums));
	}

	public int findMin2(int[] nums) {
		if (nums.length == 1)
			return nums[0];
		if (nums.length == 2)
			return Math.min(nums[0], nums[1]);
		else {
			if (nums[0] < nums[nums.length - 1])
				return nums[0];
			else {
				for (int i = 0; i < nums.length - 1; i++) {
					System.out.println(i);
					if (nums[i + 1] < nums[i]) {
						System.out.println(i + "," + nums[i]);
						return nums[i + 1];
					}
				}
			}
		}
		return 0;
	}

//	理解错了...
	public int findMin(int[] nums) {
//		四种情况，一直升，一直降，先升后降，先降后升
		if (nums.length == 1)
			return nums[0];
		if (nums.length == 2)
			return Math.min(nums[0], nums[1]);
		else {
			int a = nums[0];
			int b = nums[1];
			int c = nums[nums.length - 1];

			if (a > c && a < b)
				return c;
			else if (a > b) {
				for (int i = 0; i < nums.length; i++) {
					if (nums[i + 1] > nums[i])
						return nums[i];
				}
			} else if (a < c && a < b)
				return a;
		}
		return -1;
	}
}
