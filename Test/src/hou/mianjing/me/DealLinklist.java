package hou.mianjing.me;

/**
 * @author houweitao
 * @date 2016年1月18日 上午10:12:15
 * http://www.1point3acres.com/bbs/thread-165969-1-1.html
 * @end 2016年1月18日10:32:23
 */

/*给一个链表类型： 
a->b->c->d
|    |
e    g 
|    |
f    h
返回： a->e->f->b->g->h->c->d. */

public class DealLinklist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WiredNode root = new WiredNode(1);
		root.down = new WiredNode(2);
		root.down.next = new WiredNode(3);
		root.down.down = new WiredNode(4);
		root.next = new WiredNode(5);
		root.next.down = new WiredNode(6);
		root.next.next = new WiredNode(7);
		root.next.next.next = new WiredNode(8);

		DealLinklist deal = new DealLinklist();
		deal.print(deal.deal(root));

	}

	private void print(WiredNode deal) {
		// TODO Auto-generated method stub
		while (deal != null) {
			System.out.print(deal.val + ",");
			deal = deal.next;
		}
	}

	WiredNode deal(WiredNode root) {
		if (root == null)
			return null;
		else if (root.down == null) {
			root.next = deal(root.next);
			return root;
		} else {
			WiredNode tmp = deal(root.down);
			WiredNode fNext=root.next;
			root.next = tmp;
			while(tmp.next!=null)
				tmp=tmp.next;
			tmp.next = deal(fNext);
			return root;
		}
	}

}

class WiredNode {
	int val;
	WiredNode next;
	WiredNode down;

	public WiredNode(int val) {
		this.val = val;
	}
}