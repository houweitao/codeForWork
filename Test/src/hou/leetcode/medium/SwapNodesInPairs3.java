package hou.leetcode.medium;

/**
 * @author houweitao
 * @date 2016年2月29日 下午3:51:53
 * @end 2016年2月29日16:11:19
 * @source https://leetcode.com/problems/swap-nodes-in-pairs/
 */

public class SwapNodesInPairs3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode();
		head = head.BuildList("12345");

		SwapNodesInPairs3 sp = new SwapNodesInPairs3();
		sp.swapPairs2(head).nodePrint();
	}

	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode ret = new ListNode(-1);
		ListNode help = ret;

		ListNode p = head;

		while (p != null && p.next != null) {
			help.next = p.next;
			ListNode tmp = p;
			p = p.next.next;
			help.next.next = tmp;
			help = tmp;
			help.next = null;
		}
		help.next = p;

		return ret.next;
	}

	//递归
	public ListNode swapPairs2(ListNode head) {
		if (head == null || head.next == null)
			return head;
		
		ListNode help = new ListNode(-1);

		help.next=head.next;
		ListNode tmp=head;
		head=head.next.next;
		help.next.next=tmp;
		help.next.next.next=swapPairs2(head);
		
		return help.next;
	}
}
