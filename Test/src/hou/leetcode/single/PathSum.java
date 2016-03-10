package hou.leetcode.single;

import hou.leetcode.structure.TreeNode;

/**
 * @author houweitao 2015年8月27日 上午10:32:21
 *         https://leetcode.com/problems/path-sum/
 */

public class PathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();

	}

}

//class TreeNode {
//	int val;
//	TreeNode left;
//	TreeNode right;
//
//	TreeNode(int x) {
//		val = x;
//	}
//}

class Solution {
	private boolean stop = false; // 判断是否已经找到答案

	public boolean hasPathSum(TreeNode root, int sum) {
		calculate(root, 0, sum);
		return stop;
	}

	/**
	 * 计算根到叶子结点的和
	 * 
	 * @param node
	 *            当前处理的节点
	 * @param cur
	 *            从根节点到当前结点之前的所有节点和
	 * @param sum
	 *            要求的和
	 */
	private void calculate(TreeNode node, int cur, int sum) {
		if (!stop && node != null) { // 还没有找到答案，并且要处理的节点不为空

			// 如果是叶节点，就检查从根到当前叶节点的和是否为sum，如果是就说明已经找到，改变stop
			if (node.left == null && node.right == null && (node.val + cur == sum)) {
				stop = true;
			}

			// 如果是非叶节点，继续处理
			if (node.left != null) {
				calculate(node.left, cur + node.val, sum);
			}

			if (node.right != null) {
				calculate(node.right, cur + node.val, sum);
			}
		}
	}
}