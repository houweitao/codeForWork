package hou.leetcode.single;

/**
 * @author houweitao
 * @date 2015年11月10日 下午3:32:57
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * 
 * smart!!
 * https://leetcode.com/discuss/21104/simple-java-solution-in-one-pass
 */

public class RemoveNthNodeFromEndOfList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveNthNodeFromEndOfList re = new RemoveNthNodeFromEndOfList();

		ListNode node = new ListNode();
		node = node.BuildList("1234567");
		node.nodePrint();
		System.out.println(re.getLength(node));

		re.removeNthFromEnd(node, 3).nodePrint();
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		int l = getLength(head);
		if (l == n)
			return head.next;
		if (l == 2 && n == 1) {
			head.next = head.next.next;
			return head;
		}
		ListNode p = head;
		for (int i = 1;; i++) {
			if (i == l - n) {
				p.next = p.next.next;
				break;
			}
			p = p.next;
		}

		return head;
	}

	int getLength(ListNode node) {
		if (node == null)
			return 0;
		else
			return getLength(node.next) + 1;
	}
}
