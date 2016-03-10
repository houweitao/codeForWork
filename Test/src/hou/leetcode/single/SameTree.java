package hou.leetcode.single;

import hou.leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2015年10月28日 下午3:11:01
 */

public class SameTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		if (p != null && q != null)
			if (p.val == q.val)
				return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		return false;
	}
}
