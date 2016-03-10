//package hou.leetcode.medium;
//
///**
// * @author houweitao
// * @date 2015年12月8日 上午1:12:10
// * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
// */
//
//public class RemoveDuplicatesFromSortedListII {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//		
//	}
//
//	public ListNode deleteDuplicates(ListNode head) {
//		if (head == null || head.next == null)
//			return head;
//		else {
//			ListNode ret = head;
//			ListNode last = head;
//			ListNode p = head;
//
//			while (p.next != null) {
//				while (p.val == p.next.val) {
//					p = p.next;
//				}
//			}
//			if (head.val == head.next.val) {
//				p = p.next;
//				last = p;
//				ret = p;
//			}
//
//			while (p != null && p.next != null) {
//				if (p.next.val == last.val) {
//					p = p.next.next;
//				} else {
//					p = p.next;
//					last = p;
//				}
//			}
//			
//			return ret;
//		}
//	}
//}
