package hou.mianjing.me;

import java.util.ArrayList;

/**
 * @author houweitao
 * @date 2016年1月31日 下午1:25:02
 * @end 2016年1月31日13:49:37@home
 * 并不好。
 * http://www.1point3acres.com/bbs/thread-167887-1-1.html
 */

public class SmallestSubtree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		TreeNode n9 = new TreeNode(9);
		TreeNode n10 = new TreeNode(10);
		TreeNode n11 = new TreeNode(11);
		n1.children.add(n2);
		n1.children.add(n3);
		n1.children.add(n4);
		n2.children.add(n5);
		n2.children.add(n6);
		n4.children.add(n7);
		n5.children.add(n8);
		n5.children.add(n9);
		n6.children.add(n10);
//		n10.children.add(n11);

		SmallestSubtree ss = new SmallestSubtree();
		System.out.println("out: " + ss.get(n1).val);
//		ss.depth(n1);
	}

	TreeNode get(TreeNode node) {
		if (node == null || node.children.size() == 0)
			return node;
		else {
			int maxDepth = Integer.MIN_VALUE;
			TreeNode next = null;

			if (node.children.size() == 1) {
				return get(node.children.get(0));
			}

			for (TreeNode child : node.children) {
				int depthCur = depth(child);
				if (depthCur > maxDepth) {
					maxDepth = depthCur;
					next = child;
				} else if (depthCur == maxDepth) {
					maxDepth = depthCur;
					next = node;
				}
			}

			if (next == node)
				return node;
			else {
				return get(next);
			}
		}
	}

	private int depth(TreeNode node) {
		if (node == null)
			return 0;
		else if (node.children == null || node.children.size() == 0)
			return 1;
		else {
			int max = -1;
			for (TreeNode child : node.children) {
				max = Math.max(max, depth(child));
			}

//			System.out.println(node.val + " 深度： " + (1 + max));
			return 1 + max;
		}
	}

	static class TreeNode {
		int val;
		ArrayList<TreeNode> children;

		public TreeNode(int val) {
			this.val = val;
			children = new ArrayList<>();
		}
	}

}
