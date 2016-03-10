package hou.leetcode.structure;

import java.util.LinkedList;
import java.util.List;

/**
 * @author houweitao
 * @date 2015年10月28日 下午2:32:02
 */

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int x) {
		val = x;
	}

	public List<List<TreeNode>> printPath() {
		List<List<TreeNode>> list = new LinkedList<>();
		list = path(this);
		
		System.out.println(list);
		return list;
	}

	private List<List<TreeNode>> path(TreeNode root) {
		List<List<TreeNode>> ret = new LinkedList<>();
		if (root == null)
			return ret;
		else if (root.left == null && root.right == null) {
			List<TreeNode> list = new LinkedList<>();
			list.add(root);
			ret.add(list);
			return ret;
		} else {
			List<List<TreeNode>> left = path(root.left);
			List<List<TreeNode>> right = path(root.right);

			if (left.size() != 0) {
				for (int i = 0; i < left.size(); i++) {
					List<TreeNode> list = new LinkedList<>();
					list.add(root);
					list.addAll(left.get(i));
					ret.add(list);
				}
			}
			if (right.size() != 0) {
				for (int i = 0; i < right.size(); i++) {
					List<TreeNode> list = new LinkedList<>();
					list.add(root);
					list.addAll(right.get(i));
					ret.add(list);
				}
			}

			return ret;
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.val+"";
	}
}