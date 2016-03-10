package hou.leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author houweitao
 * @date 2016年1月15日 下午3:42:38
 * @end 复杂了 2016年1月15日16:15:48
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 */

public class CopyListWithRandomPointer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null || head.next == null)
			return head;
		else {
			HashMap<Integer, HelpNode> record = new HashMap<>();
			HashMap<Integer, RandomListNode> node = new HashMap<>();
			RandomListNode ret = new RandomListNode(head.label);
			RandomListNode p = ret, q = head;

			if (head.random != null) {
				HelpNode hn = new HelpNode(head.random.label);
				hn.from.add(ret);
				record.put(hn.label, hn);
			}

			while (q.next != null) {
				p.next = new RandomListNode(q.next.label);
				p = p.next;
				q = q.next;

				if (q.next.random != null) {
					if (!record.containsKey(q.next.random.label)) {
						HelpNode hn = new HelpNode(q.next.random.label);
						hn.from.add(q.next);
						record.put(hn.label, hn);
					} else {
						HelpNode hn = record.get(q.next.random.label);
						hn.from.add(q.next);
						record.put(hn.label, hn);
					}
				}
			}

			p = ret;
			while (p.next != null) {
				ArrayList<RandomListNode> from = record.get(p.next.label).from;
				for (int i = 0; i < from.size(); i++) {
					RandomListNode fromNode = node.get(from.get(i).label);
					fromNode.random = p.next;
				}
			}
			return ret;
		}
	}
}

class RandomListNode {
	int label;
	RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
	}
}

class HelpNode {
	int label;
	ArrayList<RandomListNode> from = new ArrayList<>();

	HelpNode(int x) {
		this.label = x;
	}
}