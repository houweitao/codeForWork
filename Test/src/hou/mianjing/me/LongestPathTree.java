package hou.mianjing.me;

import java.util.LinkedList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年2月12日上午12:19:26
 * @end 2016年02月12日00:45:14
 * @source http://www.1point3acres.com/bbs/thread-170490-1-1.html
 */

public class LongestPathTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BTreeNode node = new BTreeNode(3);
		node.left = new BTreeNode(5);
		node.left.left = new BTreeNode(6);
		node.left.right = new BTreeNode(2);
		node.left.right.left = new BTreeNode(7);
		node.left.right.right = new BTreeNode(4);

		node.right = new BTreeNode(1);
		node.right.left = new BTreeNode(0);
		node.right.right = new BTreeNode(8);
		LongestPathTree lpt = new LongestPathTree();
		lpt.print(lpt.getPath(node));
	}

	private void print(List<String> path) {
		// TODO Auto-generated method stub
		for (String str : path) {
			System.out.println(str);
		}
	}

	List<String> getPath(BTreeNode root) {
		List<String> ret = new LinkedList<>();

		if (root == null) {
			ret.add(" -> end");
			return ret;
		} else if (root.left == null && root.right == null) {
			ret.add(root.val+"");
			return ret;
		} else {
			int leftDepth = depth(root.left);
			int rightDepth = depth(root.right);
			if (leftDepth > rightDepth) {
				List<String> next = getPath(root.left);
				for (String str : next) {
					ret.add(root.val + " -> " + str);
				}
			} else if (leftDepth < rightDepth) {
				List<String> next = getPath(root.right);
				for (String str : next) {
					ret.add(root.val + " -> " + str);
				}
			} else {
				List<String> left = getPath(root.left);
				for (String str : left) {
					ret.add(root.val + " -> " + str);
				}
				List<String> right = getPath(root.right);
				for (String str : right) {
					ret.add(root.val + " -> " + str);
				}
			}

			return ret;
		}
	}

	private int depth(BTreeNode node) {
		if (node == null)
			return 0;
		else if (node.left == null && node.right == null)
			return 1;
		else
			return 1 + Math.max(depth(node.left), depth(node.right));
	}
}
