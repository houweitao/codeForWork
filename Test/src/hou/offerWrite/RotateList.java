package hou.offerWrite;

import hou.leetcode.single.ListNode;

/**
 * @author houweitao
 * @date 2016年3月9日 下午2:58:38
 * @end 2016年3月9日15:08:31
 * http://www.guolanzhe.com/?p=357
 */

public class RotateList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node=new ListNode();
		node=node.BuildList("12345");
		
		RotateList rl=new RotateList();
		rl.rotateRight(node, 3).nodePrint();
	}

	ListNode rotateRight(ListNode head, int k) {
		int len = getLen(head);
		if (len == 0 || len == 1)
			return head;
		else {
			int right = k % len;
			int beginPos = len - right;

			ListNode p = head;
			int i = 1;
			while (i < beginPos) {
				p = p.next;
				i++;
			}

			ListNode ret = p.next;
			p.next = null;

			ListNode help = ret;
			while (help.next != null)
				help = help.next;

			help.next = head;

			return ret;

		}
	}

	private int getLen(ListNode head) {
		if (head == null)
			return 0;
		int ret = 1;
		ListNode p = head;
		while (p != null) {
			p = p.next;
			ret++;
		}
		return ret;
	}
}
