package hou.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import hou.leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2015年11月30日 下午3:13:40
 * @end 2015年11月30日15:34:20
 */

public class BinaryTreeRightSideView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		node.left.right = new TreeNode(4);
		node.left.right.left = new TreeNode(5);
		node.right.right = new TreeNode(6);

		BinaryTreeRightSideView btrs = new BinaryTreeRightSideView();
		List<Integer> list = btrs.rightSideView2(node);
		for (int i = 0; i < list.size(); i++)
			System.out.print(list.get(i) + ",");
	}

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if (root == null)
			return list;
		else {
			list.add(root.val);
			if (root.right != null) {
				List<Integer> next = rightSideView(root.right);
				list.addAll(next);
			} else {
				List<Integer> next = rightSideView(root.left);
				list.addAll(next);
			}
			return list;
		}
	}

	public List<Integer> rightSideView2(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();

		if (root == null)
			return list;
		else {
			queue.add(root);
//			list.add(queue.peek().val);

			while (!queue.isEmpty()) {
				int time = queue.size();
				for (int i = 0; i < time; i++) {
					if(i==time-1)
						list.add(queue.peek().val);
					TreeNode node = queue.poll();
					if (node.left != null)
						queue.offer(node.left);
					if (node.right != null)
						queue.add(node.right);
				}
			}
			return list;
		}
	}
}
