package hou.leetcode.medium;

/**
 * @author houweitao
 * @date 2015年11月16日 上午11:54:39
 */

class ListNode {
	int val;
	ListNode next;

	ListNode() {

	}

	ListNode(int x) {
		val = x;
		next = null;
	}

	ListNode BuildList(String s) {

		ListNode listNode = new ListNode(0);
		ListNode p = listNode;
		p.val = Integer.valueOf(s.charAt(0) + "");
		for (int i = 1; i < s.length(); i++) {
			ListNode tmp = new ListNode(Integer.valueOf(s.charAt(i) + ""));
			listNode.next = tmp;
			listNode = tmp;
		}
		return p;
	}

	void nodePrint() {
		ListNode node = next;
		System.out.print(val + ",");
		while (node != null) {
			System.out.print(node.val + ",");
			node = node.next;
		}
		System.out.println();
	}
}