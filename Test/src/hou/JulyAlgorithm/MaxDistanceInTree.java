package hou.JulyAlgorithm;

import hou.leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年1月18日 上午1:12:55
 * @end 2016年1月18日01:29:31
 * p116
 */

public class MaxDistanceInTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.left.left = new TreeNode(6);
		root.left.left.left.left = new TreeNode(7);

		root.left.right.left = new TreeNode(8);
		root.left.right.left.left = new TreeNode(9);
		root.left.right.left.left.right = new TreeNode(10);

		MaxDistanceInTree tree = new MaxDistanceInTree();
		System.out.println(tree.maxDis(root));
	}

	int maxDis(TreeNode root) {
		if (root == null || (root.left == null && root.right == null))
			return 0;
		return help(root, 0);
	}

	private int help(TreeNode root, int dis) {
		if (root == null || (root.left == null && root.right == null))
			return 0;

		int now = depth(root.left) + depth(root.right);// 以当前节点为拐点的最大值。

		int left = help(root.left, dis);
		int right = help(root.right, dis);

		return Math.max(now, Math.max(dis, Math.max(left, right)));
	}

	private int depth(TreeNode root) {
		// TODO Auto-generated method stub
		if (root == null)
			return 0;

		int left = 1 + depth(root.left);
		int right = 1 + depth(root.right);

		return Math.max(left, right);
	}
}
