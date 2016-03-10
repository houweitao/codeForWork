package hou.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

import hou.leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2015年12月13日 下午4:12:16
 * https://leetcode.com/problems/count-complete-tree-nodes/
 */

public class CountCompleteTreeNodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountCompleteTreeNodes count = new CountCompleteTreeNodes();

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		System.out.println(count.countNodes(root));
		System.out.println(count.countNodes2(root));
	}

	public int countNodes2(TreeNode root) {
		if (root == null)
			return 0;
		else {
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			queue.offer(root);
			int count = 1;

			while (!queue.isEmpty()) {
				TreeNode node = queue.poll();
				if (node.left == null || node.right == null) {
					if (node.left != null) {
						count++;
					}
					return count;
				} else {
					queue.offer(node.left);
					queue.offer(node.right);
					count++;
					count++;
				}
			}

			return count;
		}
	}

	// 方法1
	public int countNodes(TreeNode root) {

		if (root == null)
			return 0;

		else {
			int floor = 0;
			TreeNode node = root;
			while (node.right != null) {
				floor++;
				node = node.right;
			}

			System.out.println("floor: " + floor);

			if (floor == 0) {
				if (root.left == null)
					return 1;
				else
					return 2;
			} else {
				String[] dirs = new String[(int) Math.pow(2, floor)];
				Queue<TreeNode> queue = new LinkedList<TreeNode>();
				int lastFloorNum = 0;
				for (int i = 0; i < (int) Math.pow(2, floor); i++) {
					dirs[i] = Integer.toBinaryString(i);
					int length = dirs[i].length();
					while (length < floor) {
						dirs[i] = "0" + dirs[i];
						length++;
					}
				}

				System.out.println(dirs.length);
				System.out.println(dirs[0] + "." + dirs[1]);

				for (int i = 0; i < dirs.length; i++) {
					queue.offer(findNode(root, dirs[i]));
				}

				while (!queue.isEmpty()) {
					TreeNode tmp = queue.poll();
					if (tmp.left != null)
						lastFloorNum++;
					else
						return 2 * dirs.length - 1 + lastFloorNum;
					if (tmp.right != null)
						lastFloorNum++;
					else
						return 2 * dirs.length - 1 + lastFloorNum;
				}
			}
		}
		return 0;

	}

	private TreeNode findNode(TreeNode root, String string) {
		// TODO Auto-generated method stub
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) == '0')
				root = root.left;
			else
				root = root.right;
		}

		System.out.println("made: " + root.val);
		return root;
	}
}
