package hou.leetcode.medium;

import hou.leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2015年11月18日 下午4:39:32
 * @end 2015年11月18日16:52:33
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */

public class ConvertSortedArrayToBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode sortedArrayToBST(int[] nums) {
		return help(nums, 0, nums.length - 1);
	}

	private TreeNode help(int[] nums, int i, int j) {
		// TODO Auto-generated method stub
		if (i > j)
			return null;
		if (i == j)
			return new TreeNode(nums[i]);

		int mid = (i + j) / 2;

		TreeNode root = new TreeNode(nums[mid]);
		root.left = help(nums, i, mid - 1);
		root.right = help(nums, mid + 1, j);
		return root;
	}
}
