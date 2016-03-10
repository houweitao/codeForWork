package hou.leetcode.medium;

/**
 * @author houweitao
 * @date 2015年12月7日 下午4:24:28
 * @end 2015年12月7日16:37:28
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 * https://leetcode.com/discuss/14045/my-accepted-java-code-used-recursion
 */

public class SwapNodesInPairs2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
//		head.next.next = new ListNode(3);
//		head.next.next.next = new ListNode(4);
//		head.next.next.next.next = new ListNode(5);

		SwapNodesInPairs2 sn = new SwapNodesInPairs2();
		ListNode ret = sn.swapPairs(head);
		sn.print(ret);
	}

	private void print(ListNode ret) {
		// TODO Auto-generated method stub
		while (ret != null) {
			System.out.print(ret.val + ",");
			ret = ret.next;
		}
	}

	//https://leetcode.com/discuss/14045/my-accepted-java-code-used-recursion
	public ListNode swapPairs2(ListNode head) {
		if ((head == null) || (head.next == null))
			return head;
		ListNode n = head.next;
		head.next = swapPairs2(head.next.next);
		n.next = head;
		return n;
	}

	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;
		else {
			ListNode p1 = head;
			ListNode p2 = head.next;
			ListNode ret = p2;
			ListNode last = new ListNode(-1);
			while (p1 != null && p2 != null) {
				p1.next = p2.next;
				p2.next = p1;
				last = p1;
				p1 = p1.next;
				if (p1 != null && p1.next != null) {
					p2 = p1.next;
					last.next = p2;
				} else
					p2 = null;
			}
			return ret;
		}
	}
}
