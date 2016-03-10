package hou.mianjing.me;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;

import hou.leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年2月29日下午10:26:38
 * @end 2016年02月29日23:03:24
 * @source http://www.1point3acres.com/bbs/thread-174400-1-1.html
 */

public class SameSubTree {
	HashMap<Integer, LinkedList<TreeNode>> treeDep = new HashMap<>();

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(3);
		root.right = new TreeNode(4);
		root.right.right = new TreeNode(3);

		SameSubTree sst = new SameSubTree();
		System.out.println(sst.getDep(root));

		sst.getSameTree(root);
		sst.showHashMap();

		HashMap<TreeNode, LinkedList<TreeNode>> same = sst.getSame();
		for (Entry<TreeNode, LinkedList<TreeNode>> entry : same.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}

	}

	void showHashMap() {
		for (Entry<Integer, LinkedList<TreeNode>> entry : treeDep.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}

	// 把可能相同的节点（深度相同），放到一起
	void getSameTree(TreeNode root) {
		if (root == null)
			return;

		int curDep = getDep(root);

		if (treeDep.containsKey(curDep)) {
			treeDep.get(curDep).add(root);
		} else {
			LinkedList<TreeNode> list = new LinkedList<>();
			list.add(root);
			treeDep.put(curDep, list);
		}

		getSameTree(root.left);
		getSameTree(root.right);
	}

	int getDep(TreeNode root) {
		int ret = 0;

		if (root == null)
			return ret;
		else
			return 1 + Math.max(getDep(root.left), getDep(root.right));
	}

	HashMap<TreeNode, LinkedList<TreeNode>> getSame() {
		HashMap<TreeNode, LinkedList<TreeNode>> hm = new HashMap<>();
		for (Entry<Integer, LinkedList<TreeNode>> entry : treeDep.entrySet()) {
			LinkedList<TreeNode> cur = entry.getValue();
			if (cur.size() > 1) {
				LinkedList<Integer> jump = new LinkedList<>();
				for (int i = 0; i < cur.size(); i++) {
					if (!jump.contains(i))
						for (int j = i + 1; j < cur.size(); j++) {
							if (isSame(cur.get(i), cur.get(j))) {
								jump.add(j);

								if (hm.containsKey(cur.get(i))) {
									hm.get(cur.get(i)).add(cur.get(j));
								} else {
									LinkedList<TreeNode> list = new LinkedList<>();
									list.add(cur.get(j));
									hm.put(cur.get(i), list);
								}
							}
						}
				}
			}
		}
		return hm;
	}

	// whether same or not; left and right has the same depth already
	boolean isSame(TreeNode left, TreeNode right) {
		if (left == null && right == null)
			return true;
		else {
			if (left == null || right == null)
				return false;
		}
		if (left.val != right.val)
			return false;
		if (getDep(left) != getDep(right))
			return false;
		else {
			boolean childSame = isSame(left.left, right.left) && isSame(left.right, right.right);

			return childSame;
		}
	}
}
