package hou.leetcode.single;

/**
 * @author houweitao
 * @date 2015年11月23日 下午2:47:21
 * @end 2015年11月23日15:19:34
 * 花了这么长时间。。。个表
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * better：https://leetcode.com/discuss/8372/a-recursive-solution
 */

public class MergeTwoSortedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeTwoSortedLists ml = new MergeTwoSortedLists();

		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(3);
		l1.next.next = new ListNode(4);

		ListNode l2 = new ListNode(0);
		l2.next = new ListNode(7);

		ListNode node = ml.mergeTwoLists(l1, l2);
		while (node != null) {
			System.out.print(node.val + ",");
			node = node.next;
		}
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null)
			return null;
		else if (l1 == null)
			return l2;
		else if (l2 == null)
			return l1;
		else {
			ListNode node = new ListNode(0);
			ListNode p = l1, q = l2;
			ListNode ret = node;
			while (p != null && q != null) {
				if (p.val <= q.val) {
					node.next = new ListNode(p.val);
//					System.out.println(p.val);
					node = node.next;
					p = p.next;
				} else {
					node.next = new ListNode(q.val);
//					System.out.println(q.val);
					node = node.next;
					q = q.next;
				}
			}

			if (p != null)
				node.next = p;

			if (q != null)
				node.next = q;

			return ret.next;
		}
	}
}
