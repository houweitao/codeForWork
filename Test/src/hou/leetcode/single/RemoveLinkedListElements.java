package hou.leetcode.single;

/**
 * @author houweitao
 * @date 2015年11月10日 下午4:06:16
 * @end 2015年11月10日16:15:58
 * 
 * fucked....
 */

public class RemoveLinkedListElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode node = new ListNode();
		node = node.BuildList("121");
//		node.nodePrint();
		RemoveLinkedListElements re = new RemoveLinkedListElements();
		re.removeElements(node, 2).nodePrint();
	}

	public ListNode removeElements(ListNode head, int val) {
		if (head == null)
			return null;
		while (head.val == val)
			if (head.next != null)
				head = head.next;
			else
				return null;

		ListNode p = head, q = head.next;
		while (q != null) {
			if (q.val == val) {
				if (q.next == null) {
					p.next = null;
					break;
				}
				if (q.next != null)
					q = q.next;
				else
					return head;
			}
			p.next=q;
			p=q;
			q=q.next;
		}

		return head;
	}
}
