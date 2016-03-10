package hou.structrue.tree;

/**
 * @author houweitao 2015年8月31日 下午2:53:44
 *         http://blog.csdn.net/yannanying/article/details/48066517
 */

public class SwapTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SwapTree st = new SwapTree();
		Node node = st.buildNode();
		st.printNode(node);
		st.swapTree(node);
		st.printNode(node);

		st.countNum(node, 21);
	}

	Node buildNode() {
		Node node = new Node(8);
		Node left = new Node(6);
		Node right = new Node(10);

		node.left = left;
		node.right = right;

		left.left = new Node(5);
		left.right = new Node(7);

		right.left = new Node(9);
		right.right = new Node(11);

		return node;
	}

	void printNode(Node node) {
		if (node == null)
			return;
		else {
			System.out.println(node.key);
			printNode(node.left);
			printNode(node.right);
		}
	}

	void swapTree(Node node) {
		if (null == node) {
			return;
		} else {
			Node tmp;
			tmp = node.left;
			node.left = node.right;
			node.right = tmp;

			swapTree(node.left);
			swapTree(node.right);
		}
	}

	void countNum(Node node, int n) {
		int count = 0;
		if (null == node) {
			if (count == n)
				System.out.println("yes");
			else
				System.out.println("no");
			return;
		} else {
			count = count + node.key;

			countNum(node.left, n - count);
			countNum(node.right, n - count);
		}

	}
}
