package hou.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

import hou.leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2015年11月18日 下午4:34:14
 * @end 2015年11月18日16:35:49
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 */

public class BinaryTreeInorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	ArrayList<Integer> al = new ArrayList<>();

	public List<Integer> inorderTraversal(TreeNode root) {
		if (root == null)
			return al;
		else {
			inorderTraversal(root.left);
			al.add(root.val);
			inorderTraversal(root.right);
			return al;
		}
	}
}
