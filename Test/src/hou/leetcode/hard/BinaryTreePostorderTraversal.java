package hou.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

import hou.leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2015年12月7日 下午4:11:32
 * @end 2015年12月7日16:18:51
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 */

public class BinaryTreePostorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> ret = new ArrayList<>();
		if(root==null)
			return ret;
		if (root.left != null)
			ret.addAll(postorderTraversal(root.left));
		if (root.right != null)
			ret.addAll(postorderTraversal(root.right));
		if (root != null)
			ret.add(root.val);

		return ret;

	}
}
