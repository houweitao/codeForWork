package hou.leetcode.medium;

/**
 * @author houweitao
 * @date 2015年11月16日 上午10:02:06
 * @end 2015年11月16日10:15:32
 * https://leetcode.com/problems/search-insert-position/
 * better solution: https://leetcode.com/discuss/23076/my-8-line-java-solution
 */

public class SearchInsertPosition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchInsertPosition sip = new SearchInsertPosition();
		int[] nums = { 1, 2, 3, 6, 10 };
		int target = 3;
		int result = sip.searchInsert(nums, target);
		System.out.println(result);
		
		for(int i=0;i<20;i++)
			System.out.println(i+","+sip.searchInsert(nums, i));
	}

	public int searchInsert(int[] nums, int target) {
		if (nums.length == 0 || target <= nums[0])
			return 0;
		else if (target > nums[nums.length - 1])
			return nums.length;
		else {
			return getPos(nums, 0, nums.length - 1, target);
		}
	}

	private int getPos(int[] nums, int i, int j, int target) {
		// TODO Auto-generated method stub
		if (target <= nums[i])
			return i;
		else if (target > nums[j])
			return j + 1;
		else {
			if (i + 1 == j) {
				return j;
			} else if (i == j) {
				//貌似已经包含这种情况了..
			} else {
				int mid = (i + j) / 2;
				if (nums[mid] == target)
					return mid;
				else if (nums[mid] > target)
					return getPos(nums, i, mid - 1, target);
				else
					return getPos(nums, mid + 1, j, target);
			}
		}

		return 0;
	}
}
