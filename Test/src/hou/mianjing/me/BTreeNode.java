package hou.mianjing.me;

/**
 * @author houweitao
 * @date 2016年2月12日上午12:22:40
 */

public class BTreeNode {
	int val;
	BTreeNode left;
	BTreeNode right;

	public BTreeNode(int val) {
		this.val = val;
	}

	public BTreeNode(boolean build) {
		// TODO Auto-generated method stub
		if (build) {
			BTreeNode node = new BTreeNode(3);
			node.left = new BTreeNode(5);
			node.left.left = new BTreeNode(6);
			node.left.right = new BTreeNode(2);
			node.left.right.left = new BTreeNode(7);
			node.left.right.right = new BTreeNode(4);

			node.right = new BTreeNode(1);
			node.right.left = new BTreeNode(0);
			node.right.right = new BTreeNode(8);
//			return node;
		} else
			this.val=-1;
	}
}
