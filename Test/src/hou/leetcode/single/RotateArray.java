package hou.leetcode.single;

/**
 * @author houweitao
 * @date 2015年11月12日 上午9:58:08
 * 循环移位。大四面试过..
 */

public class RotateArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		RotateArray ra = new RotateArray();
		ra.rotate(nums, 3);

		for (int i = 0; i < nums.length; i++)
			System.out.print(nums[i] + ",");
	}

	public void rotate(int[] nums, int k) {
		if (nums.length == 1 || nums.length == 1 || k % nums.length == 0) {
		} else {
			if (k > nums.length)
				k = k % nums.length;

			reverseArray(nums, 0, nums.length - 1);
			reverseArray(nums, 0, k - 1);
			reverseArray(nums, k, nums.length - 1);
		}
	}

	void reverseArray(int[] nums) {
		int[] tmp = new int[nums.length];
		for (int i = nums.length - 1; i >= 0; i--)
			tmp[nums.length - i - 1] = nums[i];
		nums = tmp;
	}

	void reverseArray(int[] nums, int begin, int end) {
		while (begin <= end) {
			int tmp = nums[end];
			nums[end] = nums[begin];
			nums[begin] = tmp;

			begin++;
			end--;
		}
	}
}
