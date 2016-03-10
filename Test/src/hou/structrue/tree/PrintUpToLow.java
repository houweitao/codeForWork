package hou.structrue.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author houweitao 2015年9月21日 上午10:20:46
 */

public class PrintUpToLow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> queue = new LinkedList<Integer>();

		PrintUpToLow pul = new PrintUpToLow();
		Node node = pul.buildNode();
		pul.printTree(node, queue);

		queue.clear();

		Queue<Node> queue2 = new LinkedList<Node>();
		Queue<Node> q = pul.printByQuene(node);
		int b = q.size();
		for (int i = 0; i < b; i++)
			System.out.print(q.poll() + ",");
	}

	Node buildNode() {
		Node node = new Node(3);

		node.left = new Node(9);

		node.left.left = new Node(200);
		node.right = new Node(20);
		node.right.left = new Node(15);
		node.right.right = new Node(7);

		node.right.left.left = new Node(100);

		return node;
	}

	void printTree(Node node, Queue<Integer> queue) {
		if (node == null)
			return;
		else {
			if (node.left != null) {
				System.out.println(node.left.key);
				queue.add(node.left.key);
			}
			if (node.right != null) {
				System.out.println(node.right.key);
				queue.add(node.right.key);
			}
			queue.add(node.key);

			printTree(node.left, queue);
			printTree(node.right, queue);
		}

	}

	//层次遍历的实现。
	//http://karlma8812.github.io/algorithm/2014/09/06/TreeTraverse.html
	Queue<Node> printByQuene(Node node) {
		Queue<Node> queue=new LinkedList<Node>();
		
		if (node == null) {
			return queue;
		} else {
			queue.add(node);
			while (!queue.isEmpty()) {
				Node tmp = queue.poll();
				System.out.print(tmp.key + "..");
				if (tmp.left != null)
					queue.add(tmp.left);
				if (tmp.right != null)
					queue.add(tmp.right);
			}
		}

		return queue;
	}
}
