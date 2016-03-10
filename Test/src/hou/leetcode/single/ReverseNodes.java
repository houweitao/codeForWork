package hou.leetcode.single;

/**
 * @author houweitao 2015年9月22日 下午11:28:38
 *         http://www.1point3acres.com/bbs/thread-141325-1-1.html
 *         https://leetcode.com/problems/reverse-nodes-in-k-group/
 */

public class ReverseNodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseNodes rn = new ReverseNodes();
		ListNode node = rn.buildNode();
		rn.printNode(node);
		System.out.println();
		rn.reverseNode(node, 2);

//		node=null;
//		node = rn.buildNode("12345678");
//		rn.printNode(node);
	}

	ListNode buildNode() {
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		node.next.next.next.next = new ListNode(5);
		return node;
	}

//	ListNode buildNode(String str) {
//		if (str == null)
//			return null;
//		ListNode node = new ListNode(str.charAt(0));
//		ListNode tmp = node;
//		for (int i = 1; i < str.length()-1; i++) {
//			ListNode t=new LisNode(str.charAt(i));
//			tmp.next.val = str.charAt(i);
//			System.out.println(str.charAt(i));
//			tmp = tmp.next;
//		}
//		return node;
//	}

	void reverseNode(ListNode node, int k) {
		int size = 1;
		ListNode tmp = node;
		while (tmp.next != null) {
			size++;
			tmp = tmp.next;
		}
		System.out.println("链表长度为：" + size);

		tmp = node;

		int time = size / k;

		if (k > size)
			return;
		else {
			for (int i = 0; i < time; i++) {
				System.out.println(tmp.val + " 将要和 " + getNodeAfterK(tmp, k).val + " 交换");
				swap(tmp, getNodeAfterK(tmp, k));
				printNode(node);
				System.out.println();
				tmp = getNodeAfterK(tmp, k).next;
			}
		}
		printNode(node);
	}

	void printNode(ListNode node) {
		while (node != null) {
			System.out.print(node.val + "->");
			node = node.next;
		}
	}

	void swap(ListNode tmp, ListNode nodeAfterK) {
		// TODO Auto-generated method stub
		int middle = tmp.val;
		tmp.val = nodeAfterK.val;
		nodeAfterK.val = middle;
	}

	ListNode getNodeAfterK(ListNode node, int k) {
		ListNode tmp = node;

		for (int i = 1; i < k; i++) {
			tmp = tmp.next;
		}
		return tmp;
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
