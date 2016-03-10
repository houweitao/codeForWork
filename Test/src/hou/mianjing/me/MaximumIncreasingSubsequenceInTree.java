package hou.mianjing.me;

import java.util.LinkedList;
import java.util.List;

import hou.leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年2月24日 下午4:05:17
 * @end 2016年2月24日16:38:44
 * list作为参数传递的时候要注意..
 * http://www.1point3acres.com/bbs/thread-160472-1-1.html
 */

public class MaximumIncreasingSubsequenceInTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.left.left = new TreeNode(4);
		root.left.left.left = new TreeNode(5);
		root.left.right = new TreeNode(0);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(7);

		MaximumIncreasingSubsequenceInTree max = new MaximumIncreasingSubsequenceInTree();
		List<Integer> ret = max.maxPath(root);
		System.out.println(ret);

	}

	List<Integer> maxPath(TreeNode root) {
		List<Integer> ret = new LinkedList<>();
		if (root == null)
			return null;
		else if (root.left == null && root.right == null) {
			ret.add(root.val);
			return ret;
		} else {
			List<Integer> last = new LinkedList<>();
			last.add(root.val);
			help(root, last, ret);

			return ret;
		}
	}

	void help(TreeNode root, List<Integer> last, List<Integer> finList) {
		if (last.get(last.size() - 1) >= root.val) {
			last.clear();
		}

		last.add(root.val);

		System.out.println(last);

		if (last.size() > finList.size()) {
			finList.clear();
			for (Integer i : last) {
				finList.add(i);
			}
		}

		List<Integer> le = new LinkedList<>();
		List<Integer> ri = new LinkedList<>();

		for (Integer i : last) {
			le.add(i);
			ri.add(i);
		}

		if (root.left != null)
			help(root.left, le, finList);
		if (root.right != null)
			help(root.right, ri, finList);
	}
}
