package hou.leetcode.medium;

/**
 * @author houweitao
 * @date 2015年11月11日 下午5:18:05
 */

public class LinkedListCycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null)
			return false;
		ListNode low = head, fast = head;

		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			low = low.next;

			if (low == head || fast == low || fast == head)
				return true;
		}
		return false;
	}
}

