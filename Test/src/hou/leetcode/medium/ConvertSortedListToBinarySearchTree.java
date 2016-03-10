package hou.leetcode.medium;

import java.util.ArrayList;

import hou.leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年2月26日 下午3:36:05
 * @end 2016年2月26日15:53:46
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 */

public class ConvertSortedListToBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;
		ListNode p = head;
		ArrayList<Integer> list = new ArrayList<>();
		while (p != null) {
			list.add(p.val);
			p = p.next;
		}
		return help(list, 0, list.size() - 1);
	}

	private TreeNode help(ArrayList<Integer> list, int begin, int end) {
		int mid = (begin + end) / 2;
		TreeNode node = new TreeNode(list.get(mid));
		if (begin + 1 == end) {
			node.right = new TreeNode(list.get(end));
		} else if(begin<end){
			node.left = help(list, begin, mid - 1);
			node.right = help(list, mid + 1, end);
		}
		return node;
	}
}
