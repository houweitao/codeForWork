package hou.lintcode;

/**
 * @author houweitao
 * @date 2016年1月21日 上午11:14:45
 * @end 2016年1月21日11:56:08
 * http://www.lintcode.com/zh-cn/problem/remove-node-in-binary-search-tree/
 */

public class RemoveNodeInBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.left.left=new TreeNode(2);
		root.left.right=new TreeNode(4);
		
		root.right=new TreeNode(6);
		root.right.left=new TreeNode(7);
		root.right.right=new TreeNode(8);
		root.right.right.right=new TreeNode(9);
		
		root.printNode();
		
		RemoveNodeInBinarySearchTree move=new RemoveNodeInBinarySearchTree();
		move.removeNode(root, 5).printNode();
	}

	public TreeNode removeNode(TreeNode root, int value) {
		if (root == null)
			return root;
		else if (root.val == value) {
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;
			else {
				root.val = dealLeft(root);
				return root;
			}
		} else {
			root.left = removeNode(root.left, value);
			root.right = removeNode(root.right, value);

			return root;
		}

	}

	private int dealLeft(TreeNode root) {
		// TODO Auto-generated method stub
		TreeNode left = root.left;

		if (left.right == null) {
			root.left = left.left;
			return left.val;
		}

		while (left.right.right != null)
			left = left.right;

		int ret = left.right.val;
		left.right = left.right.left;

		return ret;
	}

}
