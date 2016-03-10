package hou.leetcode.locked;

import java.util.HashMap;

import hou.leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年1月4日 上午11:01:30
 * @end 2016年1月4日11:32:10
 * http://codingmelon.com/2016/01/02/binary-tree-longest-consecutive-sequence-leetcode-298/
 * https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/
 */

public class BinaryTreeLongestConsecutiveSequence {

	static int max = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeLongestConsecutiveSequence lc = new BinaryTreeLongestConsecutiveSequence();
		TreeNode node = new TreeNode(0);
		node.right = new TreeNode(3);
		node.right.right = new TreeNode(2);
		node.right.right.right = new TreeNode(1);
		node.right.right.right.right = new TreeNode(4);
		node.right.right.right.right.right = new TreeNode(6);

		TreeNode first = new TreeNode(9);
		first.left = node;

		HashMap<TreeNode, Integer> record = new HashMap<>();
//		System.out.println(lc.longestConsecutive(node,record));
//		System.out.println(max);
		System.out.println(lc.longestConsecutive(first, record));
		System.out.println(max);
	}

	/*max是最大值
	record是记录每个节点的值，防止重复计算*/

	int longestConsecutive(TreeNode node, HashMap<TreeNode, Integer> record) {
		if (node == null)
			return 0;
		else if (node.left == null && node.right == null)
			return 1;
		else {
			int left = 0, right = 0;
			if (node.left != null)
				//这里根据题意应该是node.val+1==node.left.val 我写成了是增序。无伤大雅吧。
				if (node.val < node.left.val) {
					if (!record.containsKey(node.left))
						record.put(node.left, longestConsecutive(node.left, record));
					left = record.get(node.left) + 1;
				} else {
					left = 1;
					if (!record.containsKey(node.left))
						record.put(node.left, longestConsecutive(node.left, record));
				}
			if (node.right != null)
				if (node.val < node.right.val) {
					if (!record.containsKey(node.right))
						record.put(node.right, longestConsecutive(node.right, record));
					right = record.get(node.right) + 1;
				} else {
					right = 1;
					if (!record.containsKey(node.right))
						record.put(node.right, longestConsecutive(node.right, record));
				}
			max = Math.max(max, Math.max(left, right));
			System.out.println(node.val + ", " + Math.max(left, right));
			record.put(node, Math.max(left, right));

			System.out.println("size " + record.size());

			return Math.max(left, right);

		}
	}

	int anothere(TreeNode node) {
		if (node == null)
			return 0;
		else {
			dfs(node, 0, node.val - 1);
			return max;
		}
	}

	//从上到下计数比从下到上计数好多了。Nice...
	void dfs(TreeNode root, int curLen, int parentVal) {
		if (root == null)
			return;
		else {
			if (root.val == parentVal + 1) {
				curLen++;
			} else
				curLen = 1;
		}

		max = Math.max(max, curLen);

		dfs(root.left, curLen, root.val);
		dfs(root.right, curLen, root.val);
	}

}
