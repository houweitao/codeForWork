package hou.leetcode.single;

import java.util.ArrayList;

/**
 * @author houweitao
 * @date 2015年11月9日 下午2:05:10
 * @end 2015年11月9日14:42:29
 */

public class RemoveDuplicatesFromSortedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode listNode = new ListNode();
		listNode = listNode.BuildList("2312431224");
		listNode.nodePrint();
		System.out.println();

		RemoveDuplicatesFromSortedList rd = new RemoveDuplicatesFromSortedList();
		listNode = rd.deleteDuplicates(listNode);
		listNode.nodePrint();
		System.out.println();
		
		listNode = listNode.BuildList("1212121");
		listNode.nodePrint();
		listNode=rd.deleteDuplicates2(listNode);
		listNode.nodePrint();
	}

	ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return head;
		if (head.next == null)
			return head;

		ArrayList<Integer> list = new ArrayList<Integer>();
		ListNode p = head;
		ListNode q = p.next;
		list.add(p.val);

		while (p != null && q != null) {
			if (!list.contains(q.val)) {
				list.add(q.val);
				p = p.next;
				q = q.next;
			} else {
				if (q.next != null) {
					q = q.next;
					p.next = q;
				} else {
					p.next = null;
					return head;
				}
			}
		}
		return head;
	}
	
//	https://leetcode.com/discuss/24195/my-pretty-solution-java
//	wrong?
	ListNode deleteDuplicates2(ListNode head) {
        ListNode list = head;

         while(list != null) {
             if (list.next == null) {
                 break;
             }
             if (list.val == list.next.val) {
                 list.next = list.next.next;
             } else {
                 list = list.next;
             }
         }

         return head;
    }
}
