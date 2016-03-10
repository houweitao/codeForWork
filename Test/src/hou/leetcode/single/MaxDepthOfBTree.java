package hou.leetcode.single;

import hou.leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2015年10月28日 下午2:31:01
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * https://leetcode.com/discuss/13341/simple-solution-using-java
 * 
 * 两种不一样的递归..
 */

public class MaxDepthOfBTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int dep = 0;
		TreeNode treeNode = new TreeNode(1);
		treeNode.left = new TreeNode(2);
		treeNode.right = new TreeNode(3);
		treeNode.right.left = new TreeNode(4);
		treeNode.right.left.left = new TreeNode(5);

		MaxDepthOfBTree depth = new MaxDepthOfBTree();
		int d = depth.maxDepth(treeNode, 0);
		System.out.println(d);
		
		d=depth.maxDepth(treeNode);
		System.out.println(d);
		
		d=depth.maxDepth2(treeNode);
		System.out.println(d);
	}

	public int maxDepth(TreeNode root, int dep) {
		if (root == null)
			return dep;
		if (root.left == null && root.right == null)
			return dep + 1;
//		else if (root.left != null)
//			return maxDepth(root.left, dep+1);
//		else if (root.right != null)
//			return maxDepth(root.right, dep+1);
		else
			return (bigger(maxDepth(root.left, dep), maxDepth(root.right, dep))+1);
	}

	int bigger(int a, int b) {
		if (a >= b)
			return a;
		else
			return b;
	}
	
	public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
	
	
	public int maxDepth2(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;
//		else if (root.left != null)
//			return maxDepth2(root.left)+1;
//		else if (root.right != null)
//			return maxDepth2(root.right)+1;
		else
			return (bigger(maxDepth2(root.left), maxDepth2(root.right))+1);
	}
}
