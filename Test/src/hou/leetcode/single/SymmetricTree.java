package hou.leetcode.single;

import hou.leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2015年10月30日 上午11:39:02
 * https://leetcode.com/problems/symmetric-tree/
 * https://leetcode.com/discuss/18354/recursive-and-non-recursive-solutions-in-java
 */

public class SymmetricTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SymmetricTree st = new SymmetricTree();
		TreeNode tn = st.buildTree();
		System.out.println(st.isSymmetric(tn));
	}

	boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
//		if (root.left.val != root.right.val)
//			return false;

		return isSymmetricHelp(root.left, root.right);
	}

	boolean isSymmetricHelp(TreeNode left, TreeNode right) {
		if (left == null || right == null)
			return left == right;
		if (left.val != right.val)
			return false;
		return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
	}

	TreeNode buildTree() {
		TreeNode tn = new TreeNode(1);
		tn.left = new TreeNode(2);
		tn.left.left = new TreeNode(3);
		tn.left.right = new TreeNode(4);
		tn.right = new TreeNode(2);
		tn.right.left = new TreeNode(4);
		tn.right.right = new TreeNode(3);

		return tn;
	}
}
