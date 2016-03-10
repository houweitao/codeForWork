package hou.leetcode.single;

/**
 * @author houweitao
 * @date 2015年11月12日 上午11:49:36
 * @bug timeout 2015年11月12日11:59:03
 * https://leetcode.com/problems/palindrome-linked-list/
 * https://leetcode.com/discuss/65043/my-easy-understand-c-solution
 */

public class PalindromeLinkedList {
	ListNode temp = new ListNode();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromeLinkedList pl = new PalindromeLinkedList();
		ListNode node = new ListNode();
		node = node.BuildList("1234221");
		System.out.println(pl.isPalindrome(node));

		System.out.println(pl.other(node));

//		System.out.println(true & true);
	}
	// 入口	
	boolean other(ListNode head) {
		temp = head;
		return check(head);
	}

	//magic
	//递归到最后一层，temp才开始第一个next！	
	//https://leetcode.com/discuss/65043/my-easy-understand-c-solution
	boolean check(ListNode p) {
		if (null == p)
			return true;
		boolean isPal = check(p.next) & (temp.val == p.val);
		System.out.println(p.val + "," + temp.val + "," + isPal);// 测试
		temp = temp.next;
		return isPal;
	}
	// 我的。不足之处是得走完全程
	public boolean isPalindrome(ListNode head) {
		String left = "", right = "";
		while (head != null) {
			left = left + head.val;
			right = head.val + right;
			head = head.next;
		}

		System.out.println(left);
		System.out.println(right);

		return right.equals(left);
	}
}
