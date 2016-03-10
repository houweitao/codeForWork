package hou.leetcode.medium;

import java.util.Stack;

import hou.leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2015年12月15日 下午4:15:23
 * @end 2015年12月15日16:31:07 超时..
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 * https://leetcode.com/discuss/27643/straightforward-java-solution
 */

public class FlattenBinaryTreeToLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void flatten(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		if (root == null)
			return;
		else {
			TreeNode node = root;

			while (node != null) {
				if (node.right != null)
					stack.push(node.right);
				if (node.left != null) {
					node.right = node.left;
					node = node.right;
				} else {
					if (!stack.isEmpty()) {
						node.right = stack.pop();
						node = node.right;
					} else
						return;
				}
			}
		}
	}

	//https://leetcode.com/discuss/27643/straightforward-java-solution
	//操作对象是树的时候一定记得用这种一致性的方式。不用考虑具体怎么做，只是宏观上解决问题。
	void flatten2(TreeNode root) {
		if (root == null)
			return;

		TreeNode left = root.left;
		TreeNode right = root.right;

		root.left = null;

		flatten2(left);
		flatten2(right);

		root.right = left;
		TreeNode cur = root;
		while (cur.right != null)
			cur = cur.right;
		cur.right = right;
	}
}
