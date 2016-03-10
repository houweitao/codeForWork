package hou.structrue.tree;

/**
 * @author houweitao 2015年9月1日 下午4:43:57
 *         http://blog.csdn.net/derrantcm/article/details/47392965
 */

public class LevelOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean judge = true;
		LevelOrder lo = new LevelOrder();
		Node node = lo.buildNode();
		lo.levelOrder(node, judge);
	}

	void levelOrder(Node node, boolean judge) {

		if (node == null)
			return;

		// if (node.left == null && node.right == null)
		// return;

		if (judge) {
			System.out.println(node.key);
			judge = false;
		}
		if (node.left != null)
			System.out.println(node.left.key);
		else
			System.out.println("#");

		if (node.right != null)
			System.out.println(node.right.key);
		else
			System.out.println("#");

		levelOrder(node.left, judge);
		levelOrder(node.right, judge);

	}

	Node buildNode() {
		Node node = new Node(3);

		node.left = new Node(9);
		node.right = new Node(20);
		node.right.left = new Node(15);
		node.right.right = new Node(7);

		return node;
	}
}
