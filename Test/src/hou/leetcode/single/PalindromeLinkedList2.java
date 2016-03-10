package hou.leetcode.single;

/**
 * @author houweitao
 * @date 2015年12月29日 下午4:16:37
 * https://leetcode.com/problems/palindrome-linked-list/
 * https://leetcode.com/discuss/65043/my-easy-understand-c-solution
 * 对递归的理解
 */

public class PalindromeLinkedList2 {
	ListNode temp;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromeLinkedList2 pa = new PalindromeLinkedList2();
		ListNode node = new ListNode().BuildList("123321");
		System.out.println(pa.isPalindrome(node));
	}

	boolean isPalindrome(ListNode head) {
		temp = head;
		return check(head);
	}

	boolean check(ListNode p) {
		if (null == p)
			return true;
		boolean isPal = check(p.next) && (temp.val == p.val);
		temp = temp.next;
		return isPal;
	}

	public boolean isPalindromeMe(ListNode head) {
		if (head == null || head.next == null)
			return true;
		else {
			if (head.val == getNext(head).val) {
				head = head.next;
			} else
				return false;
		}
		return false;
	}

	ListNode getNext(ListNode head) {
		if (head.next == null)
			return head;
		else
			return getNext(head.next);
	}
}
