package hou.leetcode.medium;

/**
 * @author houweitao
 * @date 2016年2月3日下午1:06:53
 * @end long way to go..2016年02月03日13:47:58
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 */

public class PopulatingNextRightPointersInEachNodeII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void connect(TreeLinkNode root) {
		if (root == null || (root.left == null && root.right == null))
			return;
		else {
			if (root.left != null) {
				if (root.right != null) {
					root.left.next = root.right;
					if (root.next != null) {
						if (root.next.left != null)
							root.right.next = root.next.left;
						else
							root.right.next = root.next.right;
					}
				} else {
					if (root.next != null) {
						if (root.next.left != null)
							root.left.next = root.next.left;
						else
							root.left.next = root.next.right;
					} else
						root.left.next = null;
				}
			} else {
				if (root.next != null) {
					if (root.next.left != null)
						root.right.next = root.next.left;
					else
						root.right.next = root.next.right;
				} else
					root.right.next = null;
			}
		}
		connect(root.left);
		connect(root.right);
	}

	void studyBetter(TreeLinkNode root) {
		TreeLinkNode help = new TreeLinkNode(0);
		TreeLinkNode first = help;

		while (root != null) {
			if (root.left != null) {
				first.next = root.left;
				first = first.next;
			}
			if (root.right != null) {
				first.next = root.right;
				first = first.next;
			}
			if (root.next == null) {
				first = help;
				root = help.next;
				help.next = null;

			} else
				root = root.next;
		}
	}

	public void betterConnect(TreeLinkNode root) {
		// https://leetcode.com/discuss/67291/java-solution-with-constant-space
		// 思想：每次都从最左边开始。

		TreeLinkNode dummyHead = new TreeLinkNode(0);
		TreeLinkNode pre = dummyHead;
		while (root != null) {
			if (root.left != null) {
				pre.next = root.left;
				pre = pre.next;
			}
			if (root.right != null) {
				pre.next = root.right;
				pre = pre.next;
			}
			root = root.next;
			if (root == null) {
				pre = dummyHead;
				root = dummyHead.next;
				dummyHead.next = null;
			}
		}

	}

	public void betterConnectMe(TreeLinkNode root) {
		TreeLinkNode dummyHead = new TreeLinkNode(0);
		TreeLinkNode pre = dummyHead;
		while (root != null) {
			if (root.left != null) {
				pre.next = root.left;
				pre = pre.next;
			}
			if (root.right != null) {
				pre.next = root.right;
				pre = pre.next;
			}
			root = root.next;
			if (root == null) {
				break;
			}
		}
		betterConnectMe(dummyHead.next);
	}
}
