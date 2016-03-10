package hou.leetcode.single;

import hou.leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2015年11月10日 下午2:22:08
 * @end 2015年11月10日14:39:33
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 */

public class MinimumDepthOfBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode treeNode = new TreeNode(1);
		treeNode.left = new TreeNode(2);
		treeNode.right = new TreeNode(3);
		treeNode.right.left = new TreeNode(4);
		treeNode.right.left.left = new TreeNode(5);

		MinimumDepthOfBinaryTree md = new MinimumDepthOfBinaryTree();
		System.out.println(md.minDepth(treeNode, 0));

		System.out.println(md.minDepth(treeNode));
	}

	public int minDepth(TreeNode root, int dep) {
		if (root == null)
			return dep;
		else if (root.left == null || root.right == null)
			return 1 + dep;//需要修改。如果只有一个或多个叶子节点，则两个节点较大的那个继续进行..舍弃空的子节点
		else
			return min(minDepth(root.left, dep), minDepth(root.right, dep)) + 1;
	}

	private int min(int a, int b) {
		// TODO Auto-generated method stub
		if (a < b)
			return a;
		else
			return b;
	}

	private int max(int a, int b) {
		// TODO Auto-generated method stub
		if (a > b)
			return a;
		else
			return b;
	}

	// oh yeah!
	// same idea: https://leetcode.com/discuss/25060/my-4-line-java-solution
	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		else if (root.left == null || root.right == null)
			return max(minDepth(root.left), minDepth(root.right)) + 1;
		else
			return min(minDepth(root.left), minDepth(root.right)) + 1;
	}
}
