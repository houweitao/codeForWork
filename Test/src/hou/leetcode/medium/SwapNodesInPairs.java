package hou.leetcode.medium;

/**
 * @author houweitao
 * @date 2015年11月16日 上午11:53:26
 * @notfinished
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 */

public class SwapNodesInPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;
		else if(head.next.next==null){
		    	ListNode p = head, q = p.next;
		    	q.next=p;
		    	p.next=null;
		    	return q;
		}
		else {
			ListNode ret = head.next;
			ListNode p = head, q = p.next;
			while (p != null && q != null) {
				p.next = q.next;
				q.next = p;
				ListNode mark = p;

				if (p.next != null) {
					p = p.next;
					q = p.next;
					mark.next = q;
				}
			}

			return ret;
		}

	}
}
