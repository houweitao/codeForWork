package hou.leetcode.medium;

/**
 * @author houweitao
 * @date 2016年2月29日 下午2:35:50
 */

public class ReorderList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head=new ListNode();
		head=head.BuildList("123456789");
		
		ReorderList rl=new ReorderList();
		rl.reorderList(head);
		head.nodePrint();
	}

	public void reorderList(ListNode head) {
		if (head == null || head.next == null || head.next.next == null)
			return;

		ListNode low = head;
		ListNode fast = head.next;
		ListNode ret = head;

		while (fast.next != null && fast.next.next != null) {
			low = low.next;
			fast = fast.next.next;
		}

		//偶数个
		if (fast.next == null) {
			fast = low.next;
			low.next = null;
			fast = reverse(fast);
			while (ret.next != null) {
				ListNode fNode = fast;
				fast = fast.next;
				fNode.next = ret.next;
				ret.next = fNode;

				ret = ret.next.next;
			}
			ret.next = fast;
		} else {
			ListNode mid = low.next;
			fast = low.next.next;

			low.next = null;
			mid.next = null;

			fast = reverse(fast);
			while (ret.next != null) {
				ListNode fNode = fast;
				fast = fast.next;
				fNode.next = ret.next;
				ret.next = fNode;

				ret = ret.next.next;
			}
			ret.next = fast;
			fast.next=mid;
		}

	}

	private ListNode reverse(ListNode node) {
		ListNode p = new ListNode(-1);

		while (node != null) {
			ListNode tmp = node;
			node = node.next;

			tmp.next = p.next;
			p.next = tmp;
		}

		return p.next;
	}
}
