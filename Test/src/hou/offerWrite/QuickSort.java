package hou.offerWrite;

/**
 * @author houweitao
 * @date 2016年3月2日 上午10:39:33
 * @end 2016年3月2日10:47:09
 */

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 3, 1, 4, 2, 5, 3 };
		QuickSort qs = new QuickSort();
		qs.quickSort(nums, 0, nums.length - 1);
		for (int i : nums)
			System.out.println(i);
	}

	void quickSort(int[] nums, int begin, int end) {
		if (begin >= end)
			return;
		else {
			int stand = nums[begin];
			int left = begin, right = end;
			while (begin < end) {
				while (begin < end && nums[end] >= stand) {
					end--;
				}
				nums[begin] = nums[end];

				while (begin < end && nums[begin] < stand) {
					begin++;
				}
				nums[end] = nums[begin];
			}
			nums[begin] = stand;
			quickSort(nums, left, begin - 1);
			quickSort(nums, begin + 1, right);
		}
	}
}
