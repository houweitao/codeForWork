package hou.leetcode.medium;

/**
 * @author houweitao
 * @date 2016年1月12日 下午1:17:41
 * @end 2016年1月12日13:59:12 
 * 这个真的好麻烦。。
 * https://leetcode.com/problems/add-two-numbers/
 */

public class AddTwoNumbers2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
//		l1.next = new ListNode(8);
//		l1.next.next = new ListNode(0);

		ListNode l2 = new ListNode(9);
		l2.next = new ListNode(9);
		l2.next.next = new ListNode(9);

		AddTwoNumbers2 at = new AddTwoNumbers2();

		ListNode ret = at.addTwoNumbers(l1, l2);
		System.out.println("final: ");
		at.printNode(ret);
	}

	private void printNode(ListNode ret) {
		// TODO Auto-generated method stub
		while (ret != null) {
			System.out.print(ret.val + ",");
			ret = ret.next;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		else if (l2 == null)
			return l1;
		else {
			ListNode ret = new ListNode(-1);
			ListNode p = ret;
			int add = 0;
			while (l1 != null && l2 != null) {
				int sum = add + l1.val + l2.val;
				System.out.println(add + "+" + l1.val + "+" + l2.val);
				add = sum / 10;
				sum = sum % 10;
				ListNode next = new ListNode(sum);
				p.next = next;
				p = next;

				l1 = l1.next;
				l2 = l2.next;
			}

			if (l1 != null) {
				p.next = madeNext(add, l1);
			}
			if (l2 != null) {
				p.next = madeNext(add, l2);
			}
			if (l1 == null && l2 == null && add != 0) {
				ListNode next = new ListNode(add);
				p.next = next;
			}
			return ret.next;
		}
	}

	private ListNode madeNext(int add, ListNode list) {
		// TODO Auto-generated method stub
		if (add == 0)
			return list;
		else {
			ListNode ret = new ListNode(-1);
			ListNode p = ret;

			while (list != null && add != 0) {
				int sum = add + list.val;
				add = sum / 10;
				sum = sum % 10;
				ListNode tmp = new ListNode(sum);
				p.next = tmp;
				p = tmp;

				System.out.println("zzzz " + add + "," + sum);

				list = list.next;
			}
			p.next = list;
			if (add != 0) {
				while (p != null && p.next != null)
					p = p.next;
				p.next = new ListNode(add);
			}

			printNode(ret.next);
			System.out.println("madeNext");
			return ret.next;
		}
	}
}
