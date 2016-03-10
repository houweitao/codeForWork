package hou.leetcode.medium;

/**
 * @author houweitao
 * @date 2015年12月13日 下午3:30:11
 * https://leetcode.com/problems/linked-list-cycle-ii/
 */

public class LinkedListCycleII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null)
			return null;
		else {
			ListNode fast = head.next.next;
			ListNode low = head;

			boolean first = false;
			boolean second = false;
			int circleSize = 0;
			while (fast != null && fast.next != null) {
				if (low == fast) {
					if (!first)
						first = true;
					else {
						second = true;
					}
				}

				if (first && !second)
					circleSize++;

				if (second) {
					fast = head;
					low = head;
					for (int i = 0; i < circleSize; i++)
						fast = fast.next;
					while (fast != low) {
						fast = fast.next;
						low = low.next;
					}
					return low;
				}

				low = low.next;
				fast = fast.next.next;
			}

			return null;
		}

	}
}
