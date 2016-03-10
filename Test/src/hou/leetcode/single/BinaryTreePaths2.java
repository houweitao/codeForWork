package hou.leetcode.single;

import java.util.ArrayList;
import java.util.List;

import hou.leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2015年11月24日 上午11:42:35
 * @end 2015年11月24日12:01:18
 * https://leetcode.com/problems/binary-tree-paths/
 */

public class BinaryTreePaths2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreePaths2 btp = new BinaryTreePaths2();
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.left.left = new TreeNode(4);
		node.left.right = new TreeNode(5);
		node.right = new TreeNode(3);

		List<String> ret = btp.binaryTreePaths(node);
		for (String s : ret) {
			System.out.println(s);
		}
	}

	public List<String> binaryTreePaths(TreeNode root) {
		if (root == null)
			return new ArrayList<>();
		else if (root.left == null && root.right == null) {
			List<String> ret = new ArrayList<>();
			ret.add(root.val + "");
			return ret;
		} else {
			List<String> ret = new ArrayList<>();

			if (root.left != null) {
				List<String> leftPath = binaryTreePaths(root.left);
				if (leftPath.size() > 0) {
					for (String s : leftPath) {
						String tmp = root.val + "";
						tmp = tmp + "->" + s;
						ret.add(tmp);
					}
				}
			}
			if (root.right != null) {
				List<String> rightPath = binaryTreePaths(root.right);
				if (rightPath.size() > 0) {
					for (String s : rightPath) {
						String tmp = root.val + "";
						tmp = tmp + "->" + s;
						ret.add(tmp);
					}
				}
			}
			return ret;
		}
	}
}
