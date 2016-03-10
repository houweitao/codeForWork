package hou.leetcode.single;

/**
 * @author houweitao
 * @date 2015年12月29日 下午3:50:46
 * @end 2015年12月29日16:09:16
 * https://leetcode.com/problems/remove-linked-list-elements
 */

public class RemoveLinkedListElements2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveLinkedListElements2 remove = new RemoveLinkedListElements2();
		ListNode test = new ListNode().BuildList("1266346");
		test.nodePrint();
		remove.removeElements(test, 6).nodePrint();
	}

	public ListNode removeElements(ListNode head, int val) {
		if (head == null)
			return null;
		else {
			ListNode node = new ListNode(-1);
			node.next = head;
			node.nodePrint();
			ListNode p = node;
			ListNode q = p.next;

			while (p != null && q != null) {
				while (q != null && q.val == val) {
					System.out.println(val);
					q = q.next;
				}

				p.next = q;
				p = p.next;
				if (q != null)
					q = q.next;
				else
					break;
			}
			return node.next;
		}
	}
}
