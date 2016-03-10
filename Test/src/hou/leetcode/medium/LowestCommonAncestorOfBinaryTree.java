package hou.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import hou.leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2015年12月10日 上午12:17:28
 * @end? 2015年12月10日00:52:30
 * tips: 要细心。left和right别光顾着复制粘贴给弄混了
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * https://leetcode.com/discuss/45399/my-java-solution-which-is-easy-to-understand
 * https://leetcode.com/discuss/45386/4-lines-c-java-python-ruby
 */

public class LowestCommonAncestorOfBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LowestCommonAncestorOfBinaryTree lca = new LowestCommonAncestorOfBinaryTree();
		TreeNode node = lca.buildTree();
		// 6,4
		TreeNode lowest = lca.lowestCommonAncestor(node, node.left.right.right, node.left.left);
		System.out.println(lowest.val);
	}

	private TreeNode buildTree() {
		// TODO Auto-generated method stub
		TreeNode node = new TreeNode(3);
		node.left = new TreeNode(5);
		node.left.left = new TreeNode(6);
		node.left.right = new TreeNode(2);
		node.left.right.left = new TreeNode(7);
		node.left.right.right = new TreeNode(4);

		node.right = new TreeNode(1);
		node.right.left = new TreeNode(0);
		node.right.right = new TreeNode(8);

		return node;
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		HashMap<List<TreeNode>, Boolean> hashMap = getListContainNode(root, p, q);
		List<List<TreeNode>> list = new ArrayList<>();

//		System.out.println(hashMap.size());

		for (Entry<List<TreeNode>, Boolean> entry : hashMap.entrySet()) {
			if (entry.getValue())
				list.add(entry.getKey());

//			printList(entry.getKey());
		}

		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++)
			printList(list.get(i));

		if (list.size() == 1) {
			for (int i = 0; i < list.size(); i++)
				if (list.get(0).get(i) == p || list.get(0).get(i) == q)
					return list.get(0).get(i);
		} else {
			int size = list.get(0).size() < list.get(1).size() ? list.get(0).size() : list.get(1).size();
			TreeNode tmp = new TreeNode(-1);
			for (int i = 0; i < size; i++) {
				if (list.get(0).get(i) == list.get(1).get(i))
					tmp = list.get(0).get(i);
				else
					return tmp;
			}
		}
		return null;

	}

	private void printList(List<TreeNode> key) {
		// TODO Auto-generated method stub
		for (int i = 0; i < key.size(); i++)
			System.out.print(key.get(i).val + ",");
		System.out.println();
	}

	private HashMap<List<TreeNode>, Boolean> getListContainNode(TreeNode root, TreeNode p, TreeNode q) {
		// TODO Auto-generated method stub
		HashMap<List<TreeNode>, Boolean> ret = new HashMap<>();
		if (root == null)
			return ret;
		else if (root.left == null && root.right == null) {
			List<TreeNode> tmp = new ArrayList<>();
			tmp.add(root);
			if (root.val == p.val || root.val == q.val)
				ret.put(tmp, true);
			else
				ret.put(tmp, false);

			return ret;
		} else {
			if (root.left != null) {
				HashMap<List<TreeNode>, Boolean> left = getListContainNode(root.left, p, q);
				if (left.size() > 0) {
					for (Entry<List<TreeNode>, Boolean> entry : left.entrySet()) {
						List<TreeNode> tmp = new ArrayList<>();
						tmp.add(root);
						tmp.addAll(entry.getKey());

						if (root.val == p.val || root.val == q.val || entry.getValue() == true) {
							ret.put(tmp, true);
						} else
							ret.put(tmp, false);
					}
				}
			}

			if (root.right != null) {
				HashMap<List<TreeNode>, Boolean> right = getListContainNode(root.right, p, q);
				if (right.size() > 0) {
					for (Entry<List<TreeNode>, Boolean> entry : right.entrySet()) {
						List<TreeNode> tmp = new ArrayList<>();
						tmp.add(root);
						tmp.addAll(entry.getKey());

						if (root.val == p.val || root.val == q.val || entry.getValue() == true) {
							ret.put(tmp, true);
						} else
							ret.put(tmp, false);
					}
				}
			}
			return ret;
		}
	}
}
