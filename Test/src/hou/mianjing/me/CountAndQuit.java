package hou.mianjing.me;

/**
 * @author houweitao
 * @date 2015年12月8日 下午3:13:47
 * http://www.1point3acres.com/bbs/thread-154827-1-1.html
 */

public class CountAndQuit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountAndQuit cq = new CountAndQuit();
		int last = cq.finalPerson(10, 5);
		System.out.println(last);
	}

	//返回最后一个人的id
	int finalPerson(int n, int count) {
		if (n == 0)
			return -1;
		else if (n == 1) {
			return 1;
		} else if (count <= 0)
			return -1;
		else if (count == 1)
			return n;
		else {
			PeopleNode head = new PeopleNode(1);
			PeopleNode p = head;
			for (int i = 2; i <= n; i++) {
				p.next = new PeopleNode(i);
				p = p.next;
			}
			p.next = head;

			print(head);

			p = head;
			while (p.next != null && p.next != p) {
				for (int i = 2; i < count; i++) {
					p = p.next;
				}
				p.next = p.next.next;
				p = p.next;
				print(p);
			}

			return p.val;
		}
	}

	private void print(PeopleNode p) {
		PeopleNode tmp = p.next;
		boolean first = true;
		while (tmp != p) {
			if (first) {
				System.out.print(p.val + "->");
				first = false;
			}
			System.out.print(tmp.val + "->");
			tmp = tmp.next;
		}
		System.out.println();
	}
}

class PeopleNode {
	int val;
	PeopleNode next;

	public PeopleNode(int val) {
		this.val = val;
	}
}