package hou.offerWrite;

import hou.leetcode.single.ListNode;

/**
 * @author houweitao
 * @date 2016年3月1日 下午1:57:39
 * @end 2016年3月1日14:07:32
 * 翻转链表
 */

public class ReverseList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode();
		head = head.BuildList("12345");

		ReverseList rl = new ReverseList();
		rl.reverse(head).nodePrint();
	}

	ListNode reverse(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode ret = new ListNode(-1);

		while (head != null) {
			ListNode tmp = ret.next;
			ListNode headCopy = head;
			ret.next = headCopy;
			head = head.next;
			headCopy.next = tmp;
		}
		return ret.next;
	}
}
