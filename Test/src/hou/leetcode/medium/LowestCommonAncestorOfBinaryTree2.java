package hou.leetcode.medium;

import hou.leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2015年12月16日 下午3:33:38
 * @end 2015年12月16日15:41:05
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */

public class LowestCommonAncestorOfBinaryTree2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return null;
		else if (root == p || root == q)
			return root;
		else {
			TreeNode left = lowestCommonAncestor(root.left, p, q);
			TreeNode right = lowestCommonAncestor(root.right, p, q);

			if (left != null && right != null)
				return root;
			else {
				if (left != null)
					return left;
				if (right != null)
					return right;
				return null;
			}
		}
	}
}
