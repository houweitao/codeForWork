package hou.leetcode.single;

/**
 * @author houweitao 2015年8月2日 下午4:41:28
 */

public class ReverseLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "123456789";
		show(s);

		ReverseLinkedList re = new ReverseLinkedList();
		ListNode node = new ListNode(1);
		node = node.BuildList(s);
		node.nodePrint();
		node = re.reverseList(node);
		node.nodePrint();
	}

	private static void show(String s) {
		// TODO Auto-generated method stub
		ListNode ln = new ListNode(0);
		ListNode node = ln.BuildList(s);

		ListNode p = node;
		while (p.next != null) {
			System.out.println(p.val);
			p = p.next;
		}

	}

//	2015年11月17日15:35:15
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		else if (head.next.next == null) {
			ListNode n = head.next;
			n.next = head;
			head.next = null;
			return n;
		} else {
			ListNode p = head, q = head.next, cur = q.next;
			while (cur != null) {
				q.next = p;
				if (p == head)
					p.next = null;
				p = q;
				q = cur;
				cur = cur.next;
			}
			q.next = p;
			return q;
		}
	}

}
