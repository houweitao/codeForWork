package hou.leetcode.medium;

import hou.leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年2月26日 下午4:00:30
 * @notend 2016年2月26日16:36:09
 * https://leetcode.com/problems/validate-binary-search-tree/
 * 坑爹题
 * 换成long就成功了 尼玛 浪费我这么长时间！
 * https://leetcode.com/discuss/21411/my-simple-java-solution-in-3-lines
 */

public class ValidateBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Integer.MIN_VALUE + " , " + Integer.MAX_VALUE);
		System.out.println(true && false);
	}

	public boolean isValidBST(TreeNode root) {
		if (root == null || (root.left == null && root.right == null))
			return true;
		else {

			return helpBefore(root,Long.MIN_VALUE,Long.MAX_VALUE);
			
//			boolean left = true, right = true;
//			if (root.left != null)
//				left = help(root.left, Integer.MIN_VALUE, root.val, root.val);
//			if (root.right != null)
//				left = help(root.right, root.val, Integer.MAX_VALUE, root.val);
//
//			return left && right;
		}
	}

	private boolean help(TreeNode root, int min, int max, int last) {
		// TODO Auto-generated method stub

		if (root.val <= min || root.val >= max || root.val == last)
			return false;

		if (root.left != null) {
			if (!help(root.left, min, Math.min(max, root.val), root.val))
				return false;
		}

		if (root.right != null) {
			if (!help(root.right, Math.max(min, root.val), max, root.val))
				return false;
		}

		return true;
	}
	private boolean helpBefore(TreeNode root, Long min, Long max) {
		// TODO Auto-generated method stub

		if (root.val <= min || root.val >= max)
			return false;

		if (root.left != null) {
			if (!helpBefore(root.left, min, Math.min(max, root.val)))
				return false;
		}

		if (root.right != null) {
			if (!helpBefore(root.right, Math.max(min, root.val), max))
				return false;
		}

		return true;
	}
}
