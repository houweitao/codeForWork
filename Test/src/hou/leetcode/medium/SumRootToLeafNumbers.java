package hou.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

import hou.leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2015年12月8日 上午12:32:54
 * @forget 2015年12月8日01:12:26
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 */

public class SumRootToLeafNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		node.left.left = new TreeNode(7);
		node.left.right = new TreeNode(4);
		node.left.right.left = new TreeNode(5);
		node.right.right = new TreeNode(6);

		SumRootToLeafNumbers sum = new SumRootToLeafNumbers();
		List<String> ret = sum.help(node);
		System.out.println(ret.size());
		sum.print(ret);

		System.out.println(sum.sumNumbers(node));
	}

	private void print(List<String> ret) {
		// TODO Auto-generated method stub
		for (int i = 0; i < ret.size(); i++) {
			System.out.println(ret.get(i));
		}
	}

	public int sumNumbers(TreeNode root) {
		List<String> ret = help(root);
		int sum = 0;
		for (int i = 0; i < ret.size(); i++) {
			sum = sum + Integer.valueOf(ret.get(i));
		}
		return sum;
	}

	List<String> help(TreeNode root) {
		List<String> ret = new ArrayList<String>();
		if (root == null)
			return ret;
		else {
			if (root.left == null && root.right == null) {
				ret.add(root.val + "");
				return ret;
			} else {
				if (root.left != null) {
					List<String> left = help(root.left);
					for (int i = 0; i < left.size(); i++) {
						ret.add(root.val + left.get(i));
					}
				}
				if (root.right != null) {
					List<String> right = help(root.right);
					for (int i = 0; i < right.size(); i++) {
						ret.add(root.val + right.get(i));
					}
				}

				return ret;
			}
		}
	}
}
