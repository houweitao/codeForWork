package hou.mianjing.me;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author houweitao
 * @date 2015年12月10日 下午5:22:39
 * http://www.1point3acres.com/bbs/thread-157907-1-1.html
 */

public class MinimumHeightOfABinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNodeThis root = new TreeNodeThis(1);
		root.left = new TreeNodeThis(1);
		root.left.left = new TreeNodeThis(1);
		root.left.left.left = new TreeNodeThis(1);
		root.left.left.right = new TreeNodeThis(3);
		root.left.right = new TreeNodeThis(4);
		root.left.right.left = new TreeNodeThis(4);
		root.left.right.right = new TreeNodeThis(6);

		root.right = new TreeNodeThis(5);
		root.right.left = new TreeNodeThis(5);
		root.right.right = new TreeNodeThis(7);

		MinimumHeightOfABinaryTree mh = new MinimumHeightOfABinaryTree();
		System.out.println(mh.minHeight(root));
		
		System.out.println(mh.bfs(root));
	}

	// DFS
	int minHeight(TreeNodeThis root) {
		if (root == null)
			return 0;
		else if (root.left == null && root.right == null)
			return 1;
		else {
			return 1 + Math.min(minHeight(root.left), minHeight(root.right));
		}

	}

	//BFS
	int bfs(TreeNodeThis root) {
		Queue<DepthNode> queue = new LinkedList<>();
		if (root == null)
			return 0;
		else {
			queue.offer(new DepthNode(1, root));
			while (!queue.isEmpty()) {
				return minHeightBFS(queue);
			}
		}
		return 0;
	}

	int minHeightBFS(Queue<DepthNode> queue) {
		DepthNode root = queue.poll();

		if (root.node == null)
			return root.depth;
		else if (root.node.left == null && root.node.right == null)
			return root.depth;
		else {

			if (root.node.left != null)
				queue.offer(new DepthNode(root.depth + 1, root.node.left));
			if (root.node.right != null)
				queue.offer(new DepthNode(root.depth + 1, root.node.right));
			while (!queue.isEmpty()) {
				return minHeightBFS(queue);
			}
		}
		return 0;
	}
}

class DepthNode {
	int depth;
	TreeNodeThis node;

	DepthNode(int depth, TreeNodeThis node) {
		this.depth = depth;
		this.node = node;
	}
}
