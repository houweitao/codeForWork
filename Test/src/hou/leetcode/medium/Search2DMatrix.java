package hou.leetcode.medium;

/**
 * @author houweitao
 * @date 2015年11月16日 下午2:39:26
 * @end 2015年11月16日15:09:42
 * https://leetcode.com/problems/search-a-2d-matrix/
 */

public class Search2DMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Search2DMatrix sm = new Search2DMatrix();
		int[] nums = { 1, 2, 3, 4, 7 };
		int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
//		System.out.println(sm.binerySearch(nums, 6));
		System.out.println(sm.searchMatrix(matrix, 3));
	}

	public boolean searchMatrix(int[][] matrix, int target) {

		if (matrix.length == 0)
			return false;

		int[] nums = new int[matrix.length];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = matrix[i][0];
		}

		int res = binerySearch(nums, target);
		System.out.println(res);
		if (res == -1)
			return true;
		else if (res == -2) {
			if (target > matrix[matrix.length - 1][matrix[matrix.length - 1].length - 1])
				return false;
			else {
				if (binerySearch(matrix[matrix.length - 1], target) == -1)
					return true;
				else
					return false;
			}
		} else {
			if (binerySearch(matrix[res], target) == -1)
				return true;
			else
				return false;
		}
	}

	int binerySearch(int[] nums, int tar) {
		if (tar < nums[0] || tar > nums[nums.length - 1])
			return -2;
		else {
			int begin = 0, end = nums.length - 1;
			if (begin == end)
				if (nums[begin] == tar)
					return -1;
				else
					return 0;
			while (begin < end) {
				if (begin + 1 == end) {
					if (nums[begin] == tar || nums[end] == tar)
						return -1;
					else
						return begin;
				}

				int mid = (begin + end) / 2;
				if (nums[mid] == tar)
					return -1;
				else if (nums[mid] < tar) {
					begin = mid;
				} else {
					end = mid;
				}
			}
		}
		return 0;
	}
}
