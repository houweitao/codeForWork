package hou.leetcode.medium;

import hou.leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2015年12月15日 下午2:56:51
 * @end 2015年12月15日15:17:44
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 */

public class KthSmallestElementInBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(1);
		root.left.left.right = new TreeNode(2);

		root.left.right = new TreeNode(4);
		root.right = new TreeNode(7);

		KthSmallestElementInBST kthMin = new KthSmallestElementInBST();
		System.out.println(kthMin.kthSmallest(root, 6));
	}

	public int kthSmallest(TreeNode root, int k) {
		TreeNode node = root;
		while (k > 0) {
			node = root;
			TreeNode father = null;
			while (node.left != null) {
				father = node;
				node = node.left;
			}

			if (father != null)
				father.left = node.right;
			else
				root = root.right;

			k--;
		}

		return node.val;
	}
}
