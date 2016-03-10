package hou.text;

import java.util.LinkedList;
import java.util.List;

import hou.leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2015年12月15日 下午4:49:01
 * @end 2015年12月15日17:11:45
 * got it！！！！！
 */

public class MakeTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MakeTree makeTree = new MakeTree();
		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 7, 9, 10 };
		List<TreeNode> ret = makeTree.makeTree(nums, 0, 9);
		System.out.println(ret.size());
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
