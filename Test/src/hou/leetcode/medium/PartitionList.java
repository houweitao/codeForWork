package hou.leetcode.medium;

/**
 * @author houweitao
 * @date 2016年1月12日 下午2:37:06
 * @notFinish 2016年1月12日15:37:28
 * https://leetcode.com/problems/partition-list/
 */

public class PartitionList {

	public static void main(String[] args) {
		PartitionList pl = new PartitionList();
		ListNode head = new ListNode().BuildList("3111");
		pl.printNode(head);
		head = pl.partition(head, 2);
		System.out.println("out");
		pl.printNode(head);
	}

	public ListNode partition(ListNode head, int x) {
		if (head == null || head.next == null)
			return head;

		ListNode help = new ListNode(x - 1);
		help.next = head;

		ListNode ret = new ListNode(0);
		ret.next = help;

		printNode(ret);

		ListNode p = help, q = help;

		while (p != null && p.next != null && p.next.val < x) {
			p = p.next;
		}

		while (q != null && q.val != x) {
			q = q.next;
		}

		while (q != null) {
			while (q.next != null && q.next.val >= x) {
				q = q.next;
			}
			ListNode next = q.next;
			if (next != null) {
				q.next = next.next;

				next.next = p.next;
				p.next = next;
				printNode(ret.next.next);
//				if (q.next == null) {
//					System.out.println("sssssssssssss");
//					printNode(ret.next.next);
//					return ret.next.next;
//				}
			} else
				return ret.next.next;
		}

		return ret.next.next;
	}

	void printNode(ListNode node) {
		while (node != null) {
			System.out.print(node.val + ",");
			node = node.next;
		}
		System.out.println();
	}
}
