package hou.leetcode.medium;

/**
 * @author houweitao
 * @date 2015年11月13日 上午11:54:05
 * https://leetcode.com/problems/sort-colors/
 */

public class SortColors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortColors sc = new SortColors();
		int[] nums = { 1, 2, 0 };
		sc.sortColors(nums);
		sc.print(nums);
//		System.out.println("6"+3);System.out.println("6"+3);
	}

	public void sortColors(int[] nums) {
		int left = 0, end = nums.length - 1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0 && i>left)
				swap(nums, i, left++);
			if (nums[i] == 2 && i<end)
				swap(nums, i, end--);
		}

//		int second = nums.length - 1, zero = 0;
//		for (int i = 0; i <= second; i++) {
//			while (nums[i] == 2 && i < second)
//				swap(nums, i, second--);
//			while (nums[i] == 0 && i > zero)
//				swap(nums, i, zero++);
//		}
	}

	private void swap(int[] nums, int i, int j) {
		// TODO Auto-generated method stub
		int tmp = nums[j];
		nums[j] = nums[i];
		nums[i] = tmp;

		System.out.println(nums[i] + "," + nums[j]);

	}

	void print(int[] nums) {
		for (int i = 0; i < nums.length; i++)
			System.out.print(nums[i] + " ");
	}
}
