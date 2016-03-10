package hou.lintcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author houweitao
 * @date 2016年1月21日 上午11:15:36
 */

public class TreeNode {
	public int val;
	public TreeNode left, right;

	public TreeNode(int val) {
		this.val = val;
		this.left = this.right = null;
	}

	public void printNode() {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(this);
		while (!queue.isEmpty()) {
			int num = queue.size();
			for (int i = 0; i < num; i++) {
				TreeNode now = queue.poll();
				System.out.print(now.val + " ");
				if (now.left != null)
					queue.offer(now.left);
				if (now.right != null)
					queue.offer(now.right);
			}
			System.out.println();
		}
		System.out.println();
	}
}
