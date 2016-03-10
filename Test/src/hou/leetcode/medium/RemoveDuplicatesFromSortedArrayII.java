package hou.leetcode.medium;

/**
 * @author houweitao
 * @date 2015年12月15日 下午3:17:33
 * @end 2015年12月15日15:28:45
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 */

public class RemoveDuplicatesFromSortedArrayII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 1, 1, 2, 2, 3 };
		RemoveDuplicatesFromSortedArrayII rd = new RemoveDuplicatesFromSortedArrayII();
		System.out.println(rd.removeDuplicates(nums));
	}

	public int removeDuplicates(int[] nums) {
		int low = 1;
		boolean first = true;
		for (int fast = 1; fast < nums.length; fast++) {
			if (nums[fast] == nums[fast - 1]) {
				if (first) {
					first = false;
					nums[low++] = nums[fast];
				} else {

				}
			} else {
				first = true;
				nums[low++] = nums[fast];
			}
		}
		print(nums);
		return low;
	}

	private void print(int[] nums) {
		// TODO Auto-generated method stub
		for(Integer i:nums)
			System.out.print(i+",");
		System.out.println();
	}
}
