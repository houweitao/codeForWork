package hou.leetcode.medium;

import java.util.LinkedList;
import java.util.List;

import hou.leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2015年12月16日 上午11:05:47
 * @postscript 昨天写完的。
 * https://leetcode.com/problems/unique-binary-search-trees-ii/
 */

public class UniqueBinarySearchTreesII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<TreeNode> generateTrees(int n) {
		if (n == 0)
			return new LinkedList<>();

		int[] nums = new int[n];
		for (int i = 0; i < n; i++)
			nums[i] = i + 1;

		return makeTree(nums, 0, n - 1);
	}

	List<TreeNode> makeTree(int[] nums, int begin, int end) {
		List<TreeNode> list = new LinkedList<>();
		if (begin > end)
			return null;
		else if (begin == end) {
			list.add(new TreeNode(nums[begin]));
			return list;
		} else {
			for (int i = begin; i <= end; i++) {
				List<TreeNode> left = makeTree(nums, begin, i - 1);
				List<TreeNode> right = makeTree(nums, i + 1, end);

				if (left == null) {
					for (int j = 0; j < right.size(); j++) {
						TreeNode node = new TreeNode(nums[i]);
						node.right = right.get(j);
						list.add(node);
					}
				} else {
					for (int k = 0; k < left.size(); k++) {
						if (right != null)
							for (int j = 0; j < right.size(); j++) {
								TreeNode node = new TreeNode(nums[i]);
								node.right = right.get(j);
								node.left = left.get(k);
								list.add(node);
							}
						else {
							TreeNode node = new TreeNode(nums[i]);
							node.left = left.get(k);
							list.add(node);
						}

					}
				}
			}

			return list;
		}
	}
}
