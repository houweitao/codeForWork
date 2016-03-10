package hou.leetcode.medium;

/**
 * @author houweitao
 * @date 2015年11月16日 上午10:19:59
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 * much better: https://leetcode.com/discuss/7327/a-simple-accepted-solution
 */

public class PopulatingNextRightPointersInEachNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//超时...
	public void connect(TreeLinkNode root) {
		if (root == null) {
		} else {
			if (root.left != null)
				root.left.next = root.right;
			if (root.right != null && root.next != null)
				root.right.next = root.next.left;
			connect(root.next);
//		root.next.left.next=root.next.right;
			connect(root.left);
//		connect(root.right);
		}
	}
}
