package hou.leetcode.hard;

import java.util.HashMap;

/**
 * @author houweitao
 * @date 2016年1月15日 下午4:16:02
 * @end 2016年1月15日16:23:56
 */

public class CopyListWithRandomPointer2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomListNode node = new RandomListNode(0);
		RandomListNode node1 = new RandomListNode(1);
		RandomListNode node2 = new RandomListNode(2);
		RandomListNode node3 = new RandomListNode(3);
		RandomListNode node4 = new RandomListNode(4);

		node.random = node4;
		node1.random = node4;
		node2.random = node;
		node3.random = node2;

		node.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;

		CopyListWithRandomPointer2 copy = new CopyListWithRandomPointer2();
		copy.printRandomListNode(node);
		copy.printRandomListNode(copy.copyRandomList(node));
	}

	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) {
			return null;
		} else {
			HashMap<Integer, RandomListNode> node = new HashMap<>();
			RandomListNode ret = new RandomListNode(head.label);
			RandomListNode p = ret, q = head;

			node.put(ret.label, ret);

			while (q.next != null) {
				p.next = new RandomListNode(q.next.label);
				node.put(p.next.label, p.next);
				p = p.next;
				q = q.next;
			}

			p = ret;
			q = head;

			if (q.random != null) {
				p.random = node.get(q.random.label);
			}

			while (q.next != null) {
				if (q.next.random != null)
					node.get(q.next.label).random = node.get(q.next.random.label);

				p = p.next;
				q = q.next;
			}

			return ret;
		}
	}

	void printRandomListNode(RandomListNode node) {
		RandomListNode p = node;
		while (p != null) {
			if (p.random != null)
				System.out.print(p.label + " , " + p.random.label + "      ");
			else
				System.out.print(p.label + " , " + "#" + "      ");
			p = p.next;
		}
		System.out.println();
	}
}
