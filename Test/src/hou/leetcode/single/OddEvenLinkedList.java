package hou.leetcode.single;

/**
 * @author houweitao
 * @date 2016年3月1日 下午12:09:00
 * @bad 2016年3月1日12:26:25
 * 写的太麻烦。还是研究下别人怎么写吧。
 * ps:理解错题意了。人家是123456789这样子。不管怎样，写我认为的吧。先去吃饭。2016年3月1日12:37:07
 * @end 2016年3月1日13:10:19
 * 想好再写。
 * https://leetcode.com/problems/odd-even-linked-list/
 */

public class OddEvenLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode();
		head = head.BuildList("12345");

		OddEvenLinkedList oe = new OddEvenLinkedList();
		oe.oddEvenListRight(head).nodePrint();
	}

	public ListNode oddEvenListOther(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode odd = head;
		ListNode even = head.next;
		ListNode even_head = head.next;
		while (even != null && even.next != null) {
			odd.next = odd.next.next;
			even.next = even.next.next;
			odd = odd.next;
			even = even.next;
		}
		odd.next = even_head;
		return head;
	}

	public ListNode oddEvenListRight(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode fast = head.next;
		ListNode low = head;

		while (fast != null) {
			ListNode lowNext = low.next;
			if (fast.next == null)
				break;
			ListNode fastNext = fast.next.next;
			low.next = fast.next;
			low = low.next;
			low.next = lowNext;

			fast.next = fastNext;
			fast = fast.next;

		}
		return head;
	}

	public ListNode oddEvenList(ListNode head) {
		ListNode first = new ListNode(-1);
		first.next = head;
		ListNode low = first;
		ListNode fast = first.next;
		ListNode beforeFast = first;

		while (fast != null) {
			if (fast.val % 2 == 0) {
				beforeFast = fast;
				break;
			} else {
				low = low.next;
				fast = fast.next;
			}
		}

		if (fast == null || fast.next == null)
			return head;
		fast = fast.next;

		while (fast != null) {
			if (fast.val % 2 == 1) {
				ListNode lowNext = fast;
				fast = fast.next;
				beforeFast.next = fast;

				ListNode beginEven = low.next;
				low.next = lowNext;
				low = low.next;
				low.next = beginEven;
			} else {
				beforeFast = beforeFast.next;
				fast = fast.next;
			}
		}

		return first.next;
	}
}
