package hou.structrue.tree;

import java.util.Stack;

/**
 * @author houweitao
 * @date 2015年11月19日 上午11:39:52
 */

public class PostOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PostOrder po = new PostOrder();
		Node node = po.buildNode();
		po.postOrder(node);
	}

	//后序遍历非递归做法
	//http://karlma8812.github.io/algorithm/2014/09/06/TreeTraverse.html
	void postOrder(Node node) {
		Stack<Node> stack = new Stack<Node>();
		Node cur = node;
		Node pre = null;
		stack.push(node);
		while (!stack.isEmpty()) {
			if ((cur.left == null && cur.right == null) || (pre != null && (pre == cur.left || pre == cur.right))) {
				cur = stack.peek();
				System.out.print(cur.key + ",");
				stack.pop();
				pre = cur;
				if (!stack.isEmpty())
					cur = stack.peek();
			} else {
				cur = stack.peek();
				if (cur.right != null)
					stack.push(cur.right);
				if (cur.left != null)
					stack.push(cur.left);
			}
		}
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
}
