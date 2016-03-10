package hou.leetcode.medium;

/**
 * @author houweitao
 * @date 2016年2月29日 下午2:57:39
 * @end 2016年2月29日15:45:06
 * @source https://leetcode.com/problems/partition-list
 */

public class PartitionList2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode();
		head = head.BuildList("143252");

		PartitionList2 pl = new PartitionList2();
		pl.partition(head, 3).nodePrint();
	}

	//最简单有效的方法啊！
	//https://leetcode.com/discuss/21032/very-concise-one-pass-solution
	private ListNode partition(ListNode head, int x) {
		ListNode node1 = new ListNode(-1), node2 = new ListNode(-1);
		ListNode p1 = node1, p2 = node2;
		while (head != null) {
			if (head.val < x) {
				p1.next = head;
				p1 = p1.next;
//				p1.next=null;
			} else {
				p2.next = head;
				p2 = p2.next;
//				p2.next=null;
			}
			head = head.next;
		}
		//最后一起处理了..
		p2.next = null;
		p1.next = node2.next;
		return node1.next;
	}

//	public ListNode partition(ListNode head, int x) {
//		ListNode help = new ListNode(-1);
//		help.next = head;
//		ListNode low = help;
//		ListNode fast = head;
//		ListNode second = new ListNode(-1);
//		boolean first = false;
//
//		
//		if(head.val<x){
//			help.next=
//		}
//		
//		
//		
//		
//		ListNode prev = help;
//		while (fast != null) {
//			if (fast.val < x) {
//				prev.next = fast.next;
//				fast=fast.next;
//				low.next = fast;
//				low = low.next;
//				low.next = null;
//			} else {
//				if (!first) {
//					first = true;
//					second = fast;
//				}
//				prev = prev.next;
//				fast = fast.next;
//			}
//		}
//
//		low.next = second;
//		return help.next;
//	}

}
