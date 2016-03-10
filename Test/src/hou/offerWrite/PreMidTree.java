package hou.offerWrite;

import hou.leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年3月1日 下午4:58:15
 * @end 2016年3月1日17:30:15
 */

public class PreMidTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] pre = { 1, 2, 4, 5, 3, 6 };
		int[] mid = { 4, 2, 5, 1, 6, 3 };

		PreMidTree tree = new PreMidTree();
		TreeNode root = tree.getTree(pre, mid);
		root.printPath();
	}

	TreeNode getTree(int[] pre, int[] mid) {
		if (pre.length != mid.length)
			return null;
		else if (pre.length == 1) {
			return new TreeNode(pre[0]);
		} else if (pre.length == 2) {
			TreeNode ret = new TreeNode(pre[0]);
			if (pre[0] == mid[0]) {
				ret.right = new TreeNode(pre[1]);
			} else {
				ret.left = new TreeNode(pre[1]);
			}
			return ret;
		} else {
			TreeNode ret = new TreeNode(pre[0]);

			int pos = -1;
			for (int i = 0; i < mid.length; i++) {
				if (mid[i] == pre[0]) {
					pos = i;
					break;
				}
			}

			int[] leftPre = get(pre, 1, pos);
			int[] rightPre = get(pre, pos + 1, pre.length - 1);
			int[] leftMid = get(mid, 0, pos - 1);
			int[] rightMid = get(mid, pos + 1, mid.length - 1);

			ret.left = getTree(leftPre, leftMid);
			ret.right = getTree(rightPre, rightMid);

			return ret;
		}
	}

	private int[] get(int[] pre, int i, int j) {
		// TODO Auto-generated method stub

		if (i > j)
			return null;
		else {
			int[] leftPre = new int[j - i + 1];
			for (int k = 0; k < j - i + 1; k++) {
				leftPre[k] = pre[k + i];
			}
			return leftPre;
		}
	}
}
