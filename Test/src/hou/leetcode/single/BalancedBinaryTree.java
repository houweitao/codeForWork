//package hou.leetcode.single;
//
//import hou.leetcode.structure.TreeNode;
//
///**
// * @author houweitao
// * @date 2015年11月17日 下午3:52:10
// */
//
//public class BalancedBinaryTree {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
//	public boolean isBalanced(TreeNode root) {
//		if(root==null)
//			return false;
//		
//		if (depth(root.left) - depth(root.right) <= 1 && depth(root.left) - depth(root.right) >= -1
//				&& isBalanced(root.left) && isBalanced(root.right))
//			return true;
//		else
//			return false;
//	}
//
//	int depth(TreeNode root) {
//		if (root == null)
//			return 0;
//		else {
//			return 1 + Math.max(depth(root.left), depth(root.right));
//		}
//	}
//}
