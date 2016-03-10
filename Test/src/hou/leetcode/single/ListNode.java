package hou.leetcode.single;

/**
 * @author houweitao 2015年8月2日 下午4:43:11
 */

public class ListNode {
	public int val;
	public ListNode next;

	public ListNode() {

	}

	public ListNode(int x) {
		val = x;
		next = null;
	}

	public ListNode BuildList(String s) {

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

	public void nodePrint() {
		ListNode node = next;
		System.out.print(val + "->");
		while (node != null) {
			System.out.print(node.val + "->");
			node = node.next;
		}
		System.out.println();
	}
}
