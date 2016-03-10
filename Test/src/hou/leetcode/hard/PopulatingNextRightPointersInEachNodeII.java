//package hou.leetcode.hard;
//
//import hou.leetcode.medium.TreeLinkNode;
//
///**
// * @author houweitao
// * @date 2015年12月7日 下午4:57:01
// * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
// */
//
//public class PopulatingNextRightPointersInEachNodeII {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
//	public void connect(TreeLinkNode root) {
//		if (root != null) {
//			root.next = null;
//			help(root);
//		}
//	}
//
//	private void help(TreeLinkNode root) {
//		if (root == null)
//			return;
//
//		TreeLinkNode father = root;
//		if (root.left != null) {
//			if (root.right != null)
//				root.left.next = root.right;
//			else if (root.next != null) {
//				if (root.next.left != null)
//					root.left.next = root.next.left;
//				else
//					root.left.next = root.next.right;
//			}
//		}
//		if (root.right != null && father.next != null) {
//			if (father.next.left != null)
//				root.right.next = father.next.left;
//			else {
//				root.right.next = father.next.right;
//			}
//		}
//
//		help(root.left);
//		help(root.right);
//	}
//}
