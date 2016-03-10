package hou.offerWrite;

import hou.leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年3月2日 上午10:13:48
 * @end 细心！2016年3月2日10:38:26
 */

public class MidEndTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] mid = { 4, 2, 5, 1, 6, 7, 3, 8 };
		int[] end = { 4, 5, 2, 6, 7, 8, 3, 1 };

		MidEndTree tree = new MidEndTree();
		tree.getTree(mid, end).printPath();
	}

	TreeNode getTree(int[] mid, int[] end) {
		if (mid == null && end == null)
			return null;
		else if (mid.length != end.length)
			return null;
		else if (mid.length == 1) {
			return new TreeNode(mid[0]);
		} else if (mid.length == 2) {
			TreeNode ret = new TreeNode(end[1]);
			if (mid[0] == end[0]) {
				ret.left = new TreeNode(end[0]);
			} else {
				ret.right = new TreeNode(end[0]);
			}
			return ret;
		} else {
			int pos = -1;
			for (int i = 0; i < mid.length; i++) {
				if (mid[i] == end[end.length - 1]) {
					pos = i;
					break;
				}
			}

			int[] leftMid = get(mid, 0, pos - 1);
			int[] rightMid = get(mid, pos + 1, mid.length - 1);
			int[] leftEnd = get(end, 0, pos - 1);
			int[] rightEnd = get(end, pos, mid.length - 2);

			TreeNode ret = new TreeNode(end[end.length - 1]);
			ret.left = getTree(leftMid, leftEnd);
			ret.right = getTree(rightMid, rightEnd);

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
