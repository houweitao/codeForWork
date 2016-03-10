package hou.leetcode.medium;

/**
 * @author houweitao
 * @date 2015年12月3日 上午11:45:40
 * @end 2015年12月3日12:01:07
 * https://leetcode.com/problems/insertion-sort-list/
 */

public class InsertionSortList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head=new ListNode(3);
		head.next=new ListNode(2);
		head.next.next=new ListNode(4);
		InsertionSortList is=new InsertionSortList();
		is.insertionSortList(head);

		is.print(head);
	}

	private void print(ListNode head) {
		// TODO Auto-generated method stub
		ListNode p=head;
		while(p!=null)
		{
			System.out.println(p.val+",");
			p=p.next;
		}
	}

	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		else {
			for (ListNode node = head.next; node != null; node = node.next) {
				for (ListNode p = head; p != node; p = p.next) {
					if (p.val > node.val) {
						int tmp = node.val;
						node.val = p.val;
						p.val = tmp;
					}
				}
			}
			return head;
		}
	}
}
