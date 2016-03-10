package hou.leetcode.single;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import hou.leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2015年11月12日 下午2:23:17
 * https://leetcode.com/discuss/55451/clean-solution-accepted-without-helper-recursive-function
 */

public class BinaryTreePaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.right = new TreeNode(3);
		root.right = new TreeNode(4);

		BinaryTreePaths btp = new BinaryTreePaths();
		List<String> res = btp.binaryTreePathsMe(root);
		for (String s : res)
			System.out.println(s);
	}

	public List<String> binaryTreePaths(TreeNode root) {
		List<String> paths = new LinkedList<>();

		if (root == null)
			return paths;

		if (root.left == null && root.right == null) {
			paths.add(root.val + "");
			return paths;
		}

		for (String path : binaryTreePaths(root.left)) {
			paths.add(root.val + "->" + path);
		}

		for (String path : binaryTreePaths(root.right)) {
			paths.add(root.val + "->" + path);
		}

		return paths;
	}

	public List<String> binaryTreePathsMe(TreeNode root) {
		List<String> res = new LinkedList<String>();

		if (root == null)
			return res;
		if (root.left == null && root.right == null) {
			res.add(root.val + "");
			return res;
		}

		if (root.left != null) {
			List<String> left = binaryTreePaths(root.left);
			for (String s : left) {
				res.add(root.val + "->" + s);
			}
		}

		if (root.right != null) {
			List<String> right = binaryTreePaths(root.right);
			for (String s : right) {
				res.add(root.val + "->" + s);
			}
		}

//		System.out.println(res);

		return res;
	}
}
