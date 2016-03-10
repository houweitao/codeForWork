package hou.text;

/**
 * @author houweitao
 * @date 2016年2月29日 下午4:20:31
 * @end 2016年2月29日16:38:20
 * 貌似不对
 */

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 5, 1, 2, 6, 3, 8, 4, 9, 5 };

		QuickSort qs = new QuickSort();
		qs.quickSort(nums, 0, nums.length - 1);

		for (int i : nums) {
			System.out.print(i + " ");
		}
	}

	void swap(int[] nums, int left, int right) {
		int swap = nums[left];
		nums[left] = nums[right];
		nums[right] = swap;
	}

	void quickSort(int[] nums, int begin, int end) {
		if (begin + 1 > end)
			return;
		else if (begin + 1 == end) {
			if (nums[begin] > nums[end]) {
				swap(nums, begin, end);
			}
		} else {

			int left = begin;
			int right = end;

			while (right > left) {
				while (nums[right] > nums[begin]) {
					right--;
				}
				swap(nums, right, left);

				while (nums[left] <= nums[begin]) {
					left++;
				}
				swap(nums, left, right);
			}

			quickSort(nums, begin, left - 1);
			quickSort(nums, right + 1, end);

		}
	}
}
