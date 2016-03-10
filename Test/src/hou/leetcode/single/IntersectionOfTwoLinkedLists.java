package hou.leetcode.single;

import java.util.ArrayList;

/**
 * @author houweitao
 * @date 2015年11月10日 下午2:00:13
 * https://leetcode.com/discuss/17177/concise-java-solution-o-1-memory-o-n-time
 */

public class IntersectionOfTwoLinkedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1=new ListNode(1);
		ListNode node2=new ListNode(2);
		ListNode node3=new ListNode(3);
		ListNode node4=new ListNode(4);
		ListNode node5=new ListNode(5);
		
		node1.next=node2;
		node2.next=node3;
		node3.next=node5;
		node4.next=node5;
		IntersectionOfTwoLinkedLists it=new IntersectionOfTwoLinkedLists();
		
		it.getIntersectionNode(node1, node4).nodePrint();
		
		it.getIntersectionNode2(node1, node4).nodePrint();
		
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

		if (headA == null || headB == null)
			return null;

		ArrayList<ListNode> nodeList = new ArrayList<ListNode>();

		ListNode tmp = headA;
		while (tmp != null) {
			if (!nodeList.contains(tmp))
				nodeList.add(tmp);
			tmp = tmp.next;
		}

		tmp = headB;
		while (tmp != null) {
			if (!nodeList.contains(tmp))
				nodeList.add(tmp);
			else
				return tmp;
			tmp = tmp.next;
		}

		return null;
	}
	
	
	//巧妙！最后的部分长度相同！
	ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
	    int lenA = length(headA), lenB = length(headB);
	    // move headA and headB to the same start point
	    while (lenA > lenB) {
	        headA = headA.next;
	        lenA--;
	    }
	    while (lenA < lenB) {
	        headB = headB.next;
	        lenB--;
	    }
	    // find the intersection until end
	    while (headA != headB) {
	        headA = headA.next;
	        headB = headB.next;
	    }
	    return headA;
	}

	private int length(ListNode node) {
	    int length = 0;
	    while (node != null) {
	        node = node.next;
	        length++;
	    }
	    return length;
	}
}
