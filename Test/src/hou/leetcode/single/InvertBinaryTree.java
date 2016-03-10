package hou.leetcode.single;

import hou.leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2015年11月23日 下午2:35:45
 * https://leetcode.com/problems/invert-binary-tree/
 * @end 2015年11月23日14:46:07
 */

public class InvertBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode invertTree(TreeNode root) {
		if (root == null || (root.left == null && root.right == null))
			return root;
		else if(root.left==null)
		{
			root.left=root.right;
			root.right=null;
			invertTree(root.left);
		}
		else if(root.right==null){
			root.right=root.left;
			root.left=null;
			invertTree(root.right);
		}else{
			TreeNode tmp=root.left;
			root.left=root.right;
			root.right=tmp;
			invertTree(root.left);
			invertTree(root.right);
		}
		return root;
	}
}
