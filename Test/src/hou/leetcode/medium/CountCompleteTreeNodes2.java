package hou.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

import hou.leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年2月8日下午10:16:46
 * @timeOut 2016年02月08日22:45:41
 * @timeOut2 2016年02月08日23:13:11
 * @source https://leetcode.com/submissions/detail/52955946/
 */

public class CountCompleteTreeNodes2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);

		node.left = n2;
		node.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;

		CountCompleteTreeNodes2 count = new CountCompleteTreeNodes2();
		System.out.println(count.countNodes(node));

		System.out.println(count.newWay(node));
	}

	public int countNodes(TreeNode root) {
		if (isFull(root)) {
			int depth = dep(root);
			return (int) Math.pow(2, depth) - 1;
		} else {
			int fullDep = dep(root);
			int fullNode = (int) (Math.pow(2, fullDep) - 1);

			int lastDepNum = getLastDep(root, fullDep);
			return fullNode + lastDepNum;
		}
	}

	// 满二叉树的深度
	private int dep(TreeNode root) {
		if (root == null)
			return 0;
		else if (root.left == null && root.right == null)
			return 1;
		else {
			TreeNode node = root;
			int depth = 0;
			while (node != null) {
				depth++;
				node = node.right;
			}
			return depth;
		}
	}

	boolean isFull(TreeNode root) {
		if (root == null || (root.left == null && root.right == null))
			return true;
		if (!(root.left != null && root.right != null))
			return false;

		TreeNode left = root.left;
		TreeNode right = root.right;
		while (true) {
			left = left.left;
			right = right.right;

			if (left == null)
				return true;
			if (left != null && right == null)
				return false;
		}
	}

	int getLastDep(TreeNode root, int dep) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		boolean findEnd = false;
		int count = 1;
		while (count <= dep) {
			for (int i = 0; i < Math.pow(2, count - 1); i++) {
				TreeNode node = queue.poll();
				if (!findEnd) {
					if (node.left != null)
						queue.offer(node.left);
					else
						findEnd = true;

					if (node.right != null)
						queue.offer(node.right);
					else
						findEnd = true;
				}
			}
			count++;
		}
		return queue.size();
	}

	int newWay(TreeNode root) {
		if (isFull(root)) {
			int depth = dep(root);
			return (int) Math.pow(2, depth) - 1;
		} else {
			int fullDep = dep(root);
			int fullNode = (int) (Math.pow(2, fullDep) - 1);

			String record = "";

			while (true) {

				if (root.left == null && root.right == null) {
					break;
				}

				int leftD = leftDep(root.left);
				int rightD = leftDep(root.right);

				// if (leftD == 0)

				if (leftD == rightD) {
					root = root.right;
					record = record + 1;
				} else {
					root = root.left;
					record = record + 0;
				}

//				System.out.println(record);
			}
			int ret = Integer.parseInt(0 + record, 2) + 1;

//			System.out.println("ret: " + ret);
//			System.out.println(fullNode);
			return ret + fullNode;
		}
	}

	int leftDep(TreeNode root) {
		if (root == null)
			return 0;
		else if (root.left == null)
			return 1;
		else
			return 1 + leftDep(root.left);
	}
}
