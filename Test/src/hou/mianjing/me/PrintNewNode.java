package hou.mianjing.me;

/**
 * @author houweitao 2015年9月9日 下午4:16:55
 */

public class PrintNewNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node node = new Node(23);
		node.next = new Node(11);
		node.next.next = new Node(20);
		node.next.point = new Node(78);
		node.next.point.next = new Node(50);
		node.next.point.next.next = new Node(90);
		node.next.point.point = new Node(21);
		node.next.point.point.next = new Node(30);

		PrintNewNode pnn = new PrintNewNode();
		pnn.printNode(node);
	}

	void printNode(Node node) {
		if (node == null)
			return;
		System.out.print(node.val+",");
		printNode(node.point);
		printNode(node.next);
	}
}

class Node {
	int val;
	Node next;
	Node point;

	Node(int n) {
		this.val = n;
	}
}