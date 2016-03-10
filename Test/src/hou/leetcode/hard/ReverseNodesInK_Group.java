package hou.leetcode.hard;

import hou.leetcode.single.ListNode;

/**
 * @author houweitao
 * @date 2016年2月29日 下午2:16:20
 * @end 2016年2月29日14:35:57
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 */

public class ReverseNodesInK_Group {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head=new ListNode();
		head=head.BuildList("12345678");
		head.nodePrint();
		
		ReverseNodesInK_Group re=new ReverseNodesInK_Group();
		re.reverseKGroup(head, 3).nodePrint();
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null)
			return null;
		if (k == 1)
			return head;

		ListNode p = head;
		ListNode cur = null;
		int time = k;
		while (time > 0 && p != null) {
			cur = p;
			p = p.next;
			time--;
			if (time == 0) {
				cur.next = null;
			}
		}

		if (time > 0)
			return head;
		else {
			ListNode first = reverse(head);
			
			ListNode t=first;
			while(t.next!=null)
				t=t.next;
			t.next = reverseKGroup(p, k);
			
			return first;
		}

	}

	private ListNode reverse(ListNode head) {
		ListNode cur = new ListNode(-1);

		while (head != null) {
			ListNode p = head;
			head = head.next;

			p.next = cur.next;
			cur.next = p;
		}

		return cur.next;
	}
}
